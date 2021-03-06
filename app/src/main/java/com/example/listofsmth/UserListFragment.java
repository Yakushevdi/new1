package com.example.listofsmth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class UserListFragment extends Fragment {
    private RecyclerView userRecyclerView; //переменная ресайклер вью - отображение с выходом на экран нового элемента
    private UserAdapter userAdapter;
    private Button openAddUserScreen;

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle savedInstanceState){//метод создается в момент создания отображения на экране
        View view = layoutInflater.inflate(R.layout.fragment_user_list,viewGroup,false); //создаем пременнную с типом данных вью, и указываем какой именно фрагмент будет отбражен на экране с помощью рвздыувания из указанного файла
        userRecyclerView = view.findViewById(R.id.userRecyclerView); //связываем переменную с интерфейсом по аналогии как привязываем кнопки(дали айди в описании интерфеса, на фрагменте или активити обозначили переменную и далее приравняли переменную и айди)
        userRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity())); //включает менеджер отображения для Интерфейска и выбираем построчное отображение элементов и указываем активность где менеджер будет работать
        openAddUserScreen =view.findViewById(R.id.openAddUserScreen);
        UserList userList = UserList.get(getActivity());
        List<User> users = userList.getUsers();
        userAdapter = new UserAdapter(users);
        userRecyclerView.setAdapter(userAdapter);
        openAddUserScreen.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                MainActivity.changeFragment1(view);
                //startActivity(new Intent(getContext(), AddUser.class));//тут прописать смену фрагмента
            }
        });
        return view;
    }

    private class UserHolder extends RecyclerView.ViewHolder implements View.OnClickListener{ //создание элементов списка для отображение на Интерфейск ресйакл вью
        private TextView textView_UserItem;//переменная для элемента списка
        private User itemUser;// переменная для полученния текущего пользователя
        public UserHolder (LayoutInflater inflater, ViewGroup viewGroup){
            super(inflater.inflate(R.layout.list_item_user,viewGroup,false));//передаем макет интерфейса юзерлист
            textView_UserItem = itemView.findViewById(R.id.textView_UserItem); // присваем развернутому макету интерфейса значение в холдере
            itemView.setOnClickListener(this);     //-'элемент списка - ждет нажатия кнопки в этой вью
        }
        public void bind(User user){
            itemUser = user;
            String userName = "ИМЯ: "+user.getUserName()+"\n"+"ФАМИЛИЯ: "+ user.getUserLastName()+"\n_____________________";
            textView_UserItem.setText(userName);
        }

        @Override
        public void onClick(View view) {
          MainActivity.changeFragment(view, itemUser);
        }// смена фрегмента по щелчку на главной активности
    }


    private class UserAdapter extends RecyclerView.Adapter<UserHolder>{ //класс нужен для передачи Элементов созданных в держателе отображения в интерфейс ресайклер вью
        private List<User> users ;
        public UserAdapter(List <User> users){
         this.users = users;
        }

        @NonNull
        @Override
        public UserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new UserHolder(inflater,viewGroup);
        }

        @Override
        public void onBindViewHolder(UserHolder userHolder, int position){//определяет какой порядковый номер нужно вывести на экран
            User user = users.get(position);
            userHolder.bind(user);

        }


        @Override
        public int getItemCount() {
            return users.size();
        }//всего элементов которые будут отображены на экране- у нас задан размер массива аррей лист
    }
}
