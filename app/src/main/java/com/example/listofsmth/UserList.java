package com.example.listofsmth;
//класс для одного объекта!!


import java.util.ArrayList;
import java.util.List;

public class UserList {
    private static UserList userList;
    private List users;

    public static UserList get() {
        if(userList==null){
            userList=new UserList();
        }
        return userList;
    }
    private UserList(){
        users = new ArrayList();
        for (int i = 0; i <100 ; i++) {//создали рандомный список из 100 человек начиная с 0
            User user = new User();
            user.setUserName("Name"+i);
            user.setUserLastName("LastName"+i);
            users.add(user);
        }

    }
    public List getUsers(){

        return users;
    }
}
