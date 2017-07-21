package app.retrofiteiwithdatabase.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

import app.retrofiteiwithdatabase.Database.DatabaseHelper;
import app.retrofiteiwithdatabase.R;
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


public class MainActivity extends AppCompatActivity implements UpdateList{

    private static final String TAG = "MainActivity";
    Context mContext;
    Activity mActivity;
    DatabaseHelper mDatabaseHelper;
    private RecyclerView list;
    ArrayList<GetListModel.ContentBean> mContentBeen;
    private FloatingActionButton mFabButton;
    private ListAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
      //  callWebService();

    }

    private void initView() {

        mActivity=MainActivity.this;
        mContext=MainActivity.this;

        mDatabaseHelper= new DatabaseHelper(mActivity);
        mDatabaseHelper.open();

        list=(RecyclerView)findViewById(R.id.listDemo);
        mFabButton=(FloatingActionButton)findViewById(R.id.mFabButton);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
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

       /* mContentBeen= mDatabaseHelper.getLanguageInformation();
        mListAdapter = new ListAdapter(mContext ,mContentBeen,this);
        list.setAdapter(mListAdapter);*/
    }


    @Override
    public void updateList() {

        bindList();

    }

    public void passData(){

      /*  //----(Sending data)------//
        Intent mIntent = new Intent(mActivity, ForexAcademyLessonsDetailActivity.class);
        Gson gson = new Gson();
        String json = gson.toJson(allCoursesList.get(CoursePosition));
        mIntent.putExtra("FxSingleCourseData", json);
        mIntent.putExtra("LessonPosition", position);
        mActivity.startActivity(mIntent);

        //--------(Receiving Data)------//

        Gson gson = new Gson();
        mFxAcademyCoursesListModel = gson.fromJson(getIntent().getStringExtra("FxSingleCourseData"), ForexAcademyCoursesModel.CoursesBean.CourseBean.class);
        LessomnPosition = getIntent().getIntExtra("LessonPosition", 0);*/


    }
}
