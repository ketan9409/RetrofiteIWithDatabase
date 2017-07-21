package app.retrofiteiwithdatabase.apiInterface;

import java.util.concurrent.TimeUnit;

import app.retrofiteiwithdatabase.constants.Constant;
import app.retrofiteiwithdatabase.models.GetListModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ketan on 7/7/17.
 */

public  interface ApiInterface {


    //-----(Get list)-------//
    @GET(Constant.MAIN_URL+Constant.GET_LIST)
    Call<GetListModel> getList(
            @Query("AuthGUID") String AuthGUID,
            @Query("LanguageID") String LanguageID,
            @Query("ItemType") String ItemType,
            @Query("PageNumber") String PageNumber,
            @Query("CategoryID") String CategoryID,
            @Query("Package") String Package
    );




}
