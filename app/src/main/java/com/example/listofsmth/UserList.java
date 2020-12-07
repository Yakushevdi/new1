package com.example.listofsmth;
//класс для одного объекта!!


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.listofsmth.database.UserBaseHelper;
import com.example.listofsmth.database.UserCursorWrapper;
import com.example.listofsmth.database.UserDbSchema;

import org.w3c.dom.UserDataHandler;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private static UserList userList;
    private Context context;
    private SQLiteDatabase database;


    private List users = new ArrayList();

    public static UserList get(Context context) {
        if(userList==null){
            userList=new UserList(context);
        }
        return userList;
    }
    private UserList(Context context){
        this.context = context.getApplicationContext();
        database = new UserBaseHelper(context).getWritableDatabase();
    }


    public List getUsers(){
        UserCursorWrapper cursor = queryUsers(null,null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                users.add(cursor.getUser());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return users;
    }

    public void addUser (User user){
        ContentValues values = getContentValues(user);
        database.insert(UserDbSchema.UserTable.NAME,null,values);
    }

    private static ContentValues getContentValues(User user){//обработка данных класса юзер в базу данных с указанием куда какие данные из класса будут попадать
        ContentValues values = new ContentValues();
        values.put(UserDbSchema.UserTable.Cols.UUID, user.getUuid().toString());
        values.put(UserDbSchema.UserTable.Cols.USERNAME,user.getUserName());
        values.put(UserDbSchema.UserTable.Cols.USERLASTNAME,user.getUserLastName());

           return values;
    }

    private UserCursorWrapper queryUsers(String whereClause, String [] whereArgs){
        Cursor cursor = database.query(UserDbSchema.UserTable.NAME,null,whereClause,whereArgs,null,null,null);

        return new UserCursorWrapper(cursor);
    }


}
