package app.retrofiteiwithdatabase.utils;

import android.util.Log;

/**
 * Created by ketan on 7/7/17.
 */

public class AppLogs {

    public  static  AppLogs mAppLogs;

    public AppLogs() {

    }

    public static AppLogs getInstance(){

        if(mAppLogs==null){

            mAppLogs= new AppLogs();
        }
        return mAppLogs;
    }

    public void debugeE(String TAG,String printString){

        Log.e(TAG ,printString);
    }

}
