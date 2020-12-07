package com.example.listofsmth;

import android.content.Context;
import android.content.Intent;
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
    FragmentManager fragmentManager = getSupportFragmentManager();//нужен для управления фрагментами
    @Override
    protected void onCreate(Bundle savedInstanceState) {// создание активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// отображение которое запускается на главной активности
        fragmentManager.beginTransaction().add(R.id.fragmentContainer,new UserListFragment(),"main_screen").addToBackStack("main_screen").commit();
    }

    @Override
    public void onStart(){//проверить работает ли при фрагментах
        super.onStart();
        Fragment fragment = new UserListFragment();//присвоили переменной фрагмент значение фрагмета (список пользователей фрагмент) который не следующей строке отображается в главном экране
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragment,"main_screen").commit();//начинает отображение фрагмента на главной активити

    }
    @Override
    public void onBackPressed() {
        Fragment currentFragment = fragmentManager.findFragmentByTag("main_screen");
        if (currentFragment !=null && currentFragment.isVisible()) {
            super.onBackPressed();
        } else{
            Fragment fragment = new UserListFragment();
            fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment,"main_screen").commit();
        }
    }
    public static void changeFragment(View view, User user) {//метод смены отображаемого фрагмента на то что задано
        FragmentActivity activity = (FragmentActivity) view.getContext();
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        Fragment fragment = new UserFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("user", user);
        fragment.setArguments(bundle);
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
    }

    public static void changeFragment1(View view){//метод смены отображаемого фрагмента на то что задано
        FragmentActivity activity =(FragmentActivity) view.getContext();
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        Fragment fragment2 = new AddUserFragment();
        //Bundle bundle = new Bundle();
        //bundle.putSerializable("user", user);
        //fragment2.setArguments(bundle);
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragment2).commit();

    }
}
