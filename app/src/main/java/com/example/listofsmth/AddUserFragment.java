package com.example.listofsmth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AddUserFragment {
    //private Button addUserBtn;
    // private EditText nameEditText;
    // private EditText lastNameEditText;

/*
    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = layoutInflater.inflate(R.layout.activity_add_user,viewGroup,false);
        nameEditText=view.findViewById(R.id.nameEditText);
        lastNameEditText=view.findViewById(R.id.lastNameEditText);
        addUserBtn=view.findViewById(R.id.addUserBtn);
        addUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = nameEditText.getText().toString();
                String userLastName = lastNameEditText.getText().toString();
                User user = new User();
                user.setUserName(userName);
                user.setUserLastName(userLastName);
                UserList userlist = UserList.get();
                userlist.addUser(user);
                onBackPressed();
            }
        });


    }*/
}
