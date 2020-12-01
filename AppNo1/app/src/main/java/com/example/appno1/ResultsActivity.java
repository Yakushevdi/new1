package com.example.appno1;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;

public class ResultsActivity extends AppCompatActivity {
    private int[] questions;
    private ArrayList<String> results;
    private TextView listName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        results = getIntent().getStringArrayListExtra("result");
        questions = getIntent().getIntArrayExtra("questions");

        TextView textView = (TextView)findViewById(R.id.listName);

        ListView listView = (ListView)findViewById(R.id.resList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, results);
        listView.setAdapter(adapter);


    }
}