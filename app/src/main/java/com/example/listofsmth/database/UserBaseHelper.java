package com.example.listofsmth.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import static com.example.listofsmth.database.UserDbSchema.*;

public class UserBaseHelper extends SQLiteOpenHelper {
    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "userBase.db";

    public UserBaseHelper(Context context){
        super(context, DATABASE_NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ UserTable.NAME+"("+
                "_id integer primary key autoincrement," +
                UserTable.Cols.UUID+","+
                UserTable.Cols.USERNAME+","+
                UserTable.Cols.USERLASTNAME+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
