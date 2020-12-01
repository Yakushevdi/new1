package com.example.appno1;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button yesBtn;
    private Button noBtn;
    private Button showAnswerBtn;
    private TextView textView;

    private ArrayList<String> answers = new ArrayList<>();
    private Question[] questions = new Question[]{
            new Question(R.string.question1,true),
            new Question(R.string.question2,false),
            new Question(R.string.question3,false),
            new Question(R.string.question4,true),
            new Question(R.string.question5,true)
    };

    private int questionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textView);
        yesBtn = findViewById(R.id.yesBtn);
        noBtn = findViewById(R.id.noBtn);
        showAnswerBtn = findViewById(R.id.showAnswerBtn);

        if(savedInstanceState !=null){
            questionIndex = savedInstanceState.getInt("questionIndex");
            answers = savedInstanceState.getStringArrayList("answers");
        } //возврат сохранения

        textView.setText(questions[questionIndex].getQuestionResId());

        yesBtn.setOnClickListener((view) ->  {//ожидание клика на кнопки ДА
            if (questions[questionIndex].isAnswerTrue()) {
                Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                String string = getString(R.string.yes);
                String string1= getString(questions[questionIndex].getQuestionResId());
                String string2= getString(R.string.correct);
                answers.add(string1+" - Ваш ответ: "+string+" Результат: "+string2);
            } else {
                Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                String string = getString(R.string.yes);
                String string1= getString(questions[questionIndex].getQuestionResId());
                String string2= getString(R.string.incorrect);
                answers.add(string1+" - Ваш ответ: "+string+" Результат: "+string2);
            }
            questionIndex ++;
            startResults();
        });//кнопка да

        noBtn.setOnClickListener(new View.OnClickListener() {//ожидание клика на кнопки НЕТ
            @Override
            public void onClick(View view) {
                if (questions[questionIndex].isAnswerTrue()) {
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                    String string = getString(R.string.no);
                    String string1= getString(questions[questionIndex].getQuestionResId());
                    String string2= getString(R.string.incorrect);
                    answers.add(string1+" - Ваш ответ: "+string+" Результат: "+string2);
                } else {
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                    String string = getString(R.string.no);
                    String string1= getString(questions[questionIndex].getQuestionResId());
                    String string2= getString(R.string.correct);
                    answers.add(string1+" - Ваш ответ: "+string+" Результат: "+string2);
                }
                questionIndex ++;
                startResults();
            }
        }); //кнопка нет

        showAnswerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                intent.putExtra("answer", questions[questionIndex].isAnswerTrue());
                startActivity(intent);
            }
        });// кнопка подсказка
    }


    private void startResults() {
        if (questionIndex<questions.length){
            textView.setText(questions[questionIndex].getQuestionResId());
        }
        else {
            Intent i = new Intent(MainActivity.this, ResultsActivity.class);
            i.putStringArrayListExtra("result", answers); // передает сохраненные ответы пользователя
            Intent q = new Intent(MainActivity.this, ResultsActivity.class);
            q.putExtra("questions", questions);
            startActivity(i);
        }

    }//открывает Активити результатов

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public  void onPause(){
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("questionIndex", questionIndex);
        savedInstanceState.putStringArrayList("answers",answers);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}