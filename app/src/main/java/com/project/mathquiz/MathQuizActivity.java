package com.project.mathquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class MathQuizActivity extends AppCompatActivity {

    public static final long COUNTDOWN_IN_MILLIS = 15000;
    public static final String INTENT_SCORE = "extraScore";
    private TextView mQuestion;
    private TextView mScore;
    private TextView mCategoryType;
    private TextView mFinalScore;
    private TextView mCountDown;
    private TextView mQnResult;
    private RadioGroup mRadioGrp;
    private RadioButton mRadioBtn1;
    private RadioButton mRadioBtn2;
    private RadioButton mRadioBtn3;
    private RadioButton mRadioBtn4;
    private Button mConfirm;

    private ColorStateList defaultColorRadioBtn;
    private ColorStateList defaultCountdownTimer;
    private CountDownTimer countDownTimer;
    private long timeRemaining;

    private int qnCount;
    private int totalQn;
    private Quiz currentQn;
    private int score;
    private boolean answeredQn;

    private List<Quiz> qnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_quiz);

        mQuestion = findViewById(R.id.mQuestion);
        mScore = findViewById(R.id.mScore);
        mQnResult = findViewById(R.id.qnResult);
        mCountDown = findViewById(R.id.mCountdown);
        mFinalScore = findViewById(R.id.mFinalScore);
        mRadioGrp = findViewById(R.id.radio_group);
        mRadioBtn1 = findViewById(R.id.mRadioBtn1);
        mRadioBtn2 = findViewById(R.id.mRadioBtn2);
        mRadioBtn3 = findViewById(R.id.mRadioBtn3);
        mRadioBtn4 = findViewById(R.id.mRadioBtn4);
        mConfirm = findViewById(R.id.mConfirmNextQsn);


        defaultColorRadioBtn = mRadioBtn2.getTextColors();
        defaultCountdownTimer = mCountDown.getTextColors();
        mCategoryType = findViewById(R.id.mCategoryType);
        String categoryType = getIntent().getExtras().getString(MainActivity.CATEGORIES);
        mCategoryType.setText("Category: " + categoryType);
        SQLHelper dbHelper = new SQLHelper(this);
        qnList = dbHelper.getQn(categoryType);
        totalQn = qnList.size();
        Collections.shuffle(qnList);
        displayFollowingQn();
        countDown();
        mConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!answeredQn){
                    if(mRadioBtn1.isChecked()|| mRadioBtn2.isChecked()||mRadioBtn3.isChecked()|| mRadioBtn4.isChecked()){
                        validateAns();
                    }else{
                        Toast.makeText(MathQuizActivity.this, "Please select an option!!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    displayFollowingQn();
                }
            }
        });



    }

    private void displayFollowingQn(){
        mQnResult.setText("");
        mRadioBtn1.setTextColor(defaultColorRadioBtn);
        mRadioBtn2.setTextColor(defaultColorRadioBtn);
        mRadioBtn3.setTextColor(defaultColorRadioBtn);
        mRadioBtn4.setTextColor(defaultColorRadioBtn);
        mRadioGrp.clearCheck();

        if(qnCount<totalQn){
            currentQn = qnList.get(qnCount);
            mQuestion.setText(currentQn.getQuestion());
            mRadioBtn1.setText(currentQn.getOption1());
            mRadioBtn2.setText(currentQn.getOption2());
            mRadioBtn3.setText(currentQn.getOption3());
            mRadioBtn4.setText(currentQn.getOption4());
            qnCount +=1;
            answeredQn  = false;
            mConfirm.setText("Submit");
            timeRemaining = COUNTDOWN_IN_MILLIS;


        }else{
            mFinalScore.setTextColor(Color.WHITE);
            mFinalScore.setText("FINAL SCORE: " + score);
            mConfirm.setText("End Of Quiz");
            countDownTimer.cancel();
            mConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    endMathQuiz();
                }
            });
        }

    }

    private void endMathQuiz(){


        Intent scoringIntent = new Intent();
        scoringIntent.putExtra(INTENT_SCORE, score);
        setResult(RESULT_OK,scoringIntent);
        finish();
    }

    private void validateAns(){
        answeredQn = true;
        //countDownTimer.cancel();
        RadioButton mSelectedRadioBtn = findViewById(mRadioGrp.getCheckedRadioButtonId());
        int ansNum = mRadioGrp.indexOfChild(mSelectedRadioBtn) + 1;

        if(ansNum == currentQn.getCorrectAnswer()){
            score ++;
            mScore.setText("Points: " + score);
            mQnResult.setTextColor(Color.GREEN);
            mQnResult.setText("CORRECT");
        }else{
            mQnResult.setTextColor(Color.RED);
            mQnResult.setText("WRONG");
        }

        displayAnswer();
    }

    private void displayAnswer(){
        mRadioBtn1.setTextColor(Color.RED);
        mRadioBtn2.setTextColor(Color.RED);
        mRadioBtn3.setTextColor(Color.RED);
        mRadioBtn4.setTextColor(Color.RED);

        switch(currentQn.getCorrectAnswer()){
            case 1:
                mRadioBtn1.setTextColor(Color.GREEN);
                break;
            case 2:
                mRadioBtn2.setTextColor(Color.GREEN);
                break;
            case 3:
                mRadioBtn3.setTextColor(Color.GREEN);
                break;
            case 4:
                mRadioBtn4.setTextColor(Color.GREEN);
                break;
        }
        if (qnCount<totalQn){
            mConfirm.setText("Next");
        }else{
            mConfirm.setText("End Of Quiz");
        }
    }

    private void countDown(){
        countDownTimer = new CountDownTimer(timeRemaining,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeRemaining = millisUntilFinished;
                int min = (int)(timeRemaining/1000)/60;
                int sec = (int)(timeRemaining/1000)%60;
                String time = String.format(Locale.getDefault(), "%02d:%02d", min,sec);
                mCountDown.setText(time);
                if (timeRemaining<5000){
                    mCountDown.setTextColor(Color.RED);
                }else{
                    mCountDown.setTextColor(Color.WHITE);
                }
            }
            @Override
            public void onFinish() {
                timeRemaining = 0;
                mCountDown.setTextColor(Color.RED);
                String time = String.format(Locale.getDefault(), "%02d:%02d", 0,0);
                mCountDown.setText(time);
                validateAns();
                mFinalScore.setTextColor(Color.WHITE);
                mFinalScore.setText("FINAL SCORE: " + score);
                mConfirm.setText("End Of Quiz");
                mConfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        endMathQuiz();
                    }
                });

            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(countDownTimer!=null){
            countDownTimer.cancel();
        }
    }
}