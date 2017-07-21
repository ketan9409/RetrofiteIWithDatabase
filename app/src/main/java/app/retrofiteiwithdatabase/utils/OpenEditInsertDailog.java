package app.retrofiteiwithdatabase.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import app.retrofiteiwithdatabase.Database.DatabaseHelper;
import app.retrofiteiwithdatabase.R;
import app.retrofiteiwithdatabase.activities.MainActivity;
import app.retrofiteiwithdatabase.apiInterface.UpdateList;

/**
 * Created by ketan on 20/7/17.
 */

public class OpenEditInsertDailog extends Dialog {


    private final DatabaseHelper mDatabaseHelper;
    private String strID, strNAME, strAddress;
    private boolean isPremium;
    private boolean isFromREdit = false;
    private int position = 0;
    Context mContext;
    UpdateList mainActivity;


    public OpenEditInsertDailog(Context context, String NAME, String Address, boolean isFromEdit, int position, UpdateList mainActivity) {

        super(context);

        this.strNAME = NAME;
        this.strAddress = Address;
        this.isFromREdit = isFromEdit;
        this.position = position;
        this.mContext = context;
        this.mainActivity = mainActivity;

        mDatabaseHelper = new DatabaseHelper(context);
        mDatabaseHelper.open();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);

        final EditText edtId = (EditText) findViewById(R.id.edtId);
        final EditText edtName = (EditText) findViewById(R.id.edtName);
        final EditText edtAddress = (EditText) findViewById(R.id.edtAddress);
        TextView txtSaveData = (TextView) findViewById(R.id.txtSaveData);


        if (isFromREdit) {

            edtId.setText(strID);
            edtName.setText(strNAME);
            edtAddress.setText(strAddress);

        }


        txtSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(!isFromREdit) {
                    mDatabaseHelper.insertListData(edtName.getText().toString(), edtAddress.getText().toString());
                }else {
                    mDatabaseHelper.updateListData(position, edtName.getText().toString(), edtAddress.getText().toString());
                }
                mainActivity.updateList();
                dismiss();

            }
        });


    }
}