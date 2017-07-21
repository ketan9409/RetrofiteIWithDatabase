package app.retrofiteiwithdatabase.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.retrofiteiwithdatabase.Database.DatabaseHelper;
import app.retrofiteiwithdatabase.R;
import app.retrofiteiwithdatabase.activities.MainActivity;
import app.retrofiteiwithdatabase.adapters.ListAdapter;
import app.retrofiteiwithdatabase.apiInterface.ApiInterface;
import app.retrofiteiwithdatabase.apiInterface.UpdateList;
import app.retrofiteiwithdatabase.apiInterface.WebServiceCall;
import app.retrofiteiwithdatabase.constants.Constant;
import app.retrofiteiwithdatabase.models.GetListModel;
import app.retrofiteiwithdatabase.utils.AppLogs;
import app.retrofiteiwithdatabase.utils.OpenEditInsertDailog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ketan on 21/7/17.
 */

public class HomeFragment extends Fragment implements UpdateList {

    private static final String TAG = "MainActivity";
    Context mContext;
    Activity mActivity;
    DatabaseHelper mDatabaseHelper;
    private RecyclerView list;
    ArrayList<GetListModel.ContentBean> mContentBeen;
    private FloatingActionButton mFabButton;
    private ListAdapter mListAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);

        initView(view);
        callWebService();
        return view;
    }

    private void initView(View view) {
        mActivity=getActivity();
        mContext=getActivity();

        mDatabaseHelper= new DatabaseHelper(mActivity);
        mDatabaseHelper.open();

        list=(RecyclerView)view.findViewById(R.id.listDemo);
        mFabButton=(FloatingActionButton)view.findViewById(R.id.mFabButton);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        list.setLayoutManager(mLayoutManager);

        mFabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openInstertValueDailog();

            }
        });
    }
    private void openInstertValueDailog() {

        OpenEditInsertDailog mOpenEditInsertDailog= new OpenEditInsertDailog(mContext ,"","" ,false ,0,this);
        mOpenEditInsertDailog.show();


    }
    private void callWebService() {


        ApiInterface mApiInterface = WebServiceCall.initializeRetrofite();
        Call<GetListModel> call = mApiInterface.getList(Constant.AUTH_ID,Constant.LANGUAGE_ID,Constant.ITEM_TYPE,Constant.PAGE_NUMBER,Constant.CATAGORY_ID,Constant.PACK_PURCHASE);
        call.enqueue(new Callback<GetListModel>() {
            @Override
            public void onResponse(Call<GetListModel> call, Response<GetListModel> response) {

                AppLogs.getInstance().debugeE(TAG ,"onResponse");
                storedIndatavase(response);

            }

            @Override
            public void onFailure(Call<GetListModel> call, Throwable t) {

                AppLogs.getInstance().debugeE(TAG ,"onFailure");

            }
        });

    }

    private void storedIndatavase(Response<GetListModel> response) {


        mDatabaseHelper.clearData();

        for(int i =0;  i< response.body().getContent().size() ;i ++) {
            mDatabaseHelper.insertListData(response.body().getContent().get(i).getTitle(),response.body().getContent().get(i).getOpenDate());
        }

        bindList();


    }

    private void bindList() {

        mContentBeen= mDatabaseHelper.getLanguageInformation();
        mListAdapter = new ListAdapter(mContext ,mContentBeen,this);
        list.setAdapter(mListAdapter);
    }


    @Override
    public void updateList() {

        bindList();

    }


}
