package com.example.listofsmth;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {// создание активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// отображение которое запускается на главной активности
        FragmentManager fragmentManager = getSupportFragmentManager();//нужен для управления фрагментами
        Fragment fragment = new UserListFragment();//присвоили переменной фрагмент значение фрагмета (список пользователей фрагмент)
        Fragment fragment1 = new UserFragment();
        fragmentManager.beginTransaction().add(R.id.fragmentContainer,fragment).commit();//начинает отображение фрагмента на главной активити



    }

    @Override
    public void onBackPressed(){
        Toast.makeText(MainActivity.this,"lock down", Toast.LENGTH_SHORT).show();

    }

    public static void changeFragment(View view, User user){//метод смены отображаемого фрагмента на то что задано
        FragmentActivity activity =(FragmentActivity) view.getContext();
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        Fragment fragment = new UserFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", user);
        fragment.setArguments(bundle);
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
    }
}
