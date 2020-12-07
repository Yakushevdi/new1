package com.example.listofsmth.database;

public class UserDbSchema {
    public static class UserTable{
        public static final String NAME = "users";// константа - принято писать большими буквами
        public static final class Cols{
            public static final String UUID = "uuid";
            public static final String USERNAME = "username";
            public static final String USERLASTNAME = "userlastname";
        }
    }
}
