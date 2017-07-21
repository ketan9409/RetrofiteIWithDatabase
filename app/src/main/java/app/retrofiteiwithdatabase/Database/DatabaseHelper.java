package app.retrofiteiwithdatabase.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import app.retrofiteiwithdatabase.models.GetListModel;

/**
 * Created by ketan on 7/7/17.
 */

public class DatabaseHelper {

    private DatabaseManager mDatabaseManager;
    private Context mContext;
    private SQLiteDatabase mSqLiteDatabase;
    private Cursor result = null;

    public static String DATABASE_NAME="Demo.db";
    private static final int DATABASE_VERSION = 1;

    public static String GETLIST_TABLE ="Content";
    public static String ID ="id";
    public static String GETLIST_TITLE ="Title";
    public static String GETLIST_OPENDATE ="OpenDate";






    public DatabaseHelper(Context mContext) {
        // TODO Auto-generated constructor stub
        this.mContext = mContext;
        mDatabaseManager = DatabaseManager.getInstance(mContext, DATABASE_NAME, null,
                DATABASE_VERSION);

    }

    public void open() {
        if (mSqLiteDatabase == null || !mSqLiteDatabase.isOpen())
            mSqLiteDatabase = mDatabaseManager.getWritableDatabase();
    }

    public void close() {
        mSqLiteDatabase.close();
    }


    public long insertListData(String title, String openDate) {

        ContentValues values = new ContentValues();
        values.put(GETLIST_TITLE, title);
        values.put(GETLIST_OPENDATE, openDate);

        return mSqLiteDatabase.insert(GETLIST_TABLE, null, values);

    }

    public void updateListData(int posittion,  String title, String openDate) {

        ContentValues args = new ContentValues();
        args.put(GETLIST_TITLE, title);
        args.put(GETLIST_OPENDATE, openDate);
        String whereArgs[] = new String[1];
        whereArgs[0] = "" + posittion;
        mSqLiteDatabase.update(GETLIST_TABLE, args, ID+"= ?", whereArgs);


    }
    public void clearData(){

        mSqLiteDatabase.execSQL("delete from "+ GETLIST_TABLE);
    }

    public void deleteItem(int id)
    {
        mSqLiteDatabase.delete(GETLIST_TABLE, ID + "=" + id, null);
    }




    public ArrayList<GetListModel.ContentBean> getLanguageInformation() {
        ArrayList<GetListModel.ContentBean> listOfLang = new ArrayList<GetListModel.ContentBean>();

        Cursor result = null;
        try {
            result = mSqLiteDatabase.query(GETLIST_TABLE, new String[] {}, null, null,
                    null, null, null);

            if (result.moveToFirst()) {
                do {
                    GetListModel.ContentBean lang = new GetListModel.ContentBean();
                    lang.setID(result.getInt(0));
                    lang.setTitle(result.getString(1));
                    listOfLang.add(lang);

                } while (result.moveToNext());
            }

        } catch (Exception e) {

        } finally {
            if (result != null) {
                result.close();
                result = null;
            }
        }

        return listOfLang;
    }


}
