package com.project.mathquiz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_MATH_QUIZ = 100;
    public static final String CATEGORIES = "categories";

    public static final String SHARED_PREF = "sharedPreferences";
    public static final String HIGHSCORE = "highscore";
    public TextView mHighscore;
    private int highscore;

    private Spinner mCategoryChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHighscore = findViewById(R.id.mHighscore);
        loadHighscore();
        Button mStartQuiz = findViewById(R.id.mStartQuiz);
        mCategoryChoice = findViewById(R.id.mCategory);
        String [] categoryChoices = Quiz.getAllCategory();

        ArrayAdapter<String> adapterCategory = new ArrayAdapter<String>(this,
                                            R.layout.spinner_layout, categoryChoices);
        adapterCategory.setDropDownViewResource(R.layout.spinner_layout);
        mCategoryChoice.setAdapter(adapterCategory);
        mStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String category = mCategoryChoice.getSelectedItem().toString();
                Intent i = new Intent(MainActivity.this, MathQuizActivity.class);
                i.putExtra(CATEGORIES,category);
                startActivityForResult(i,REQ_MATH_QUIZ);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_MATH_QUIZ){
            if (resultCode == RESULT_OK){
                int score = data.getIntExtra(MathQuizActivity.INTENT_SCORE, 0);
                if(score>highscore){
                    saveHighscore(score);
                }
            }
        }
    }

    private void loadHighscore(){
        SharedPreferences pref = getSharedPreferences(SHARED_PREF,MODE_PRIVATE);
        highscore = pref.getInt(HIGHSCORE,0);
        mHighscore.setText("Highscore: " + highscore);
    }

    private void saveHighscore(int newHighScore){
        highscore = newHighScore;
        mHighscore.setText("Highscore: " + highscore);

        SharedPreferences pref = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(HIGHSCORE,highscore);
        editor.apply();

    }
}


