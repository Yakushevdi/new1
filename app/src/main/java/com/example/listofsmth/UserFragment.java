package com.example.listofsmth;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class UserFragment extends Fragment {
    private User user;
    private TextView textView_UserName;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = new User();
        Bundle bundle = getArguments();
        user = (User) bundle.getSerializable("user");// получили объект из списка пользовтелей-то на который указали

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){//открытие контейнера
        View view = inflater.inflate(R.layout.fragmen_user,container,false);// отображение самого View на экране(открытие Фаргмента)
        textView_UserName = view.findViewById(R.id.textView_UserName);
        String userName = "Name: "+user.getUserName()+"\n"+"LastName: "+user.getUserLastName();
        textView_UserName.setText(userName);
        return view;

    }




}
