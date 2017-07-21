package app.retrofiteiwithdatabase.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.retrofiteiwithdatabase.Database.DatabaseHelper;
import app.retrofiteiwithdatabase.Fragments.HomeFragment;
import app.retrofiteiwithdatabase.R;
import app.retrofiteiwithdatabase.activities.MainActivity;
import app.retrofiteiwithdatabase.models.GetListModel;
import app.retrofiteiwithdatabase.utils.OpenEditInsertDailog;

/**
 * Created by ketan on 20/7/17.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private final DatabaseHelper mDatabaseHelper;
    private List<GetListModel.ContentBean> getDataList;
    public Context mContext;
    HomeFragment mainActivity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTitle;
        public ImageView imgDeleteItem, imgEditIcon;



        public MyViewHolder(View view) {
            super(view);
            txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            imgDeleteItem = (ImageView) view.findViewById(R.id.imgDeleteItem);
            imgEditIcon = (ImageView) view.findViewById(R.id.imgEditIcon);

        }
    }


    public ListAdapter(Context mContext, ArrayList<GetListModel.ContentBean> getDataList, HomeFragment mainActivity) {


        this.getDataList = getDataList;
        this.mContext= mContext;
        this.mainActivity= mainActivity;

        mDatabaseHelper = new DatabaseHelper(mContext);
        mDatabaseHelper.open();

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_items, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


        holder.txtTitle.setText(getDataList.get(position).getTitle());

        holder.imgDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder;
                builder = new AlertDialog.Builder(mContext);
                builder.setTitle("Delete entry")
                        .setMessage("Are you sure you want to delete this entry?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                mDatabaseHelper.deleteItem(mDatabaseHelper.getLanguageInformation().get(position).getID());
                                mainActivity.updateList();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

            }
        });

        holder.imgEditIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OpenEditInsertDailog mOpenEditInsertDailog= new OpenEditInsertDailog(mContext ,getDataList.get(position).getTitle(),getDataList.get(position).getOpenDate() ,true ,mDatabaseHelper.getLanguageInformation().get(position).getID(),mainActivity);
                mOpenEditInsertDailog.show();
            }
        });
}

    @Override
    public int getItemCount() {
        return getDataList.size();
    }
}
