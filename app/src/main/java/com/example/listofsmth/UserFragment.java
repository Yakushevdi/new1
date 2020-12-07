package com.example.listofsmth;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserFragment extends Fragment {
    private User user;
    private TextView textView_UserName;
    private EditText editName;
    private EditText editLastName;
    private Button updateBtn;
    private UserList userList;
    private Button deleteUserBtn;



    @Override
    public void onCreate(Bundle savedInstanceState) {//создание фрагмента юзерфрагмент
        super.onCreate(savedInstanceState);
        user = new User();
        Bundle bundle = getArguments();
        user = (User) bundle.getSerializable("user");// получили объект из списка пользовтелей-то на который указали

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){//метод создается в момент создания отображения на экране
        View view = inflater.inflate(R.layout.fragmen_user,container,false);//создаем пременнную с типом данных вью, и указываем какой именно фрагмент будет отбражен на экране с помощью рвздыувания из указанного файла
        userList = UserList.get(getActivity());
        textView_UserName = view.findViewById(R.id.textView_UserName);
        editName = view.findViewById(R.id.editName);
        editLastName = view.findViewById(R.id.editLastName);
        updateBtn = view.findViewById(R.id.updateBtn);
        deleteUserBtn = view.findViewById(R.id.deleteUserBtn);
        String userName = "Name: "+user.getUserName()+"\n"+"LastName: "+user.getUserLastName();
        textView_UserName.setText(userName);

        updateBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String newUserName = editName.getText().toString();
                String newUserLastName = editLastName.getText().toString();
                user.setUserName(newUserName);
                user.setUserLastName(newUserLastName);
                userList.updateUser(user);
                Toast.makeText(getActivity(),"uppload well done", Toast.LENGTH_SHORT).show();
            }
        });

        deleteUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userList.deleteUser(user);
            }
        });
        return view;
    }
}
