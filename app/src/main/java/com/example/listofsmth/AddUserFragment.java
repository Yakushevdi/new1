package com.example.listofsmth;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUserFragment extends Fragment {
    private Button addUserBtn;
    private EditText nameEditText;
    private EditText lastNameEditText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState) {//метод создается в момент создания отображения на экране
        View view = layoutInflater.inflate(R.layout.activity_add_user,viewGroup,false);//создаем пременнную с типом данных вью, и указываем какой именно фрагмент будет отбражен на экране с помощью рвздыувания из указанного файла
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
                UserList userlist = UserList.get(getContext());
                userlist.addUser(user);
                Toast.makeText(getActivity(),"Ваши данные записаны"+"\nНажмите кнопку назад",Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

}
