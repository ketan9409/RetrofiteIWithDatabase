package app.retrofiteiwithdatabase.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ketan on 7/7/17.
 */

public class DatabaseManager extends SQLiteOpenHelper {

    private static DatabaseManager sInstance = null;

    public DatabaseManager(Context context, String name, SQLiteDatabase.CursorFactory factory,
                           int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }

    public static synchronized DatabaseManager getInstance(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        if (sInstance == null) {
            sInstance = new DatabaseManager(context.getApplicationContext(),
                    name, factory, version);
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        sqLiteDatabase.execSQL(storeData());

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {



    }


    private String storeData() {


        return "CREATE TABLE IF NOT EXISTS " + DatabaseHelper.GETLIST_TABLE
                + "(" + DatabaseHelper.ID + " INTEGER PRIMARY KEY, "
                + DatabaseHelper.GETLIST_TITLE + " text, "
                + DatabaseHelper.GETLIST_OPENDATE + " text);";
    }

}
