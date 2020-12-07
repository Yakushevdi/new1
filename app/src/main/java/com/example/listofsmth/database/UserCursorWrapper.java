package com.example.listofsmth.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.listofsmth.User;

import java.util.UUID;

public class UserCursorWrapper extends CursorWrapper {
    public UserCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public User getUser(){
        String uuidString = getString(getColumnIndex(UserDbSchema.UserTable.Cols.UUID));
        String userName = getString(getColumnIndex(UserDbSchema.UserTable.Cols.USERNAME));
        String userLastName = getString(getColumnIndex(UserDbSchema.UserTable.Cols.USERLASTNAME));

        User user = new User(UUID.fromString(uuidString));
        user.setUserName(userName);
        user.setUserLastName(userLastName);
        return user;

    }
}
