package app.retrofiteiwithdatabase.apiInterface;

import java.util.concurrent.TimeUnit;

import app.retrofiteiwithdatabase.constants.Constant;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ketan on 7/7/17.
 */

public class WebServiceCall {


    public static ApiInterface initializeRetrofite(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(1, TimeUnit.MINUTES).readTimeout(1, TimeUnit.MINUTES).addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.MAIN_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface mRestAPI = retrofit.create(ApiInterface.class);
        return mRestAPI;
    }


}
