package com.project.mathquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQLHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "MathQuiz.db";
    private static final int DB_VER = 1;

    private SQLiteDatabase db;

    public SQLHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String CREATE_QN_TABLE = "CREATE TABLE " +
                                        Constants.QuizTable.NAME + " ( " +
                                        Constants.QuizTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        Constants.QuizTable.COL_QUESTION + " TEXT, " +
                                        Constants.QuizTable.COL_OPT1 + " TEXT, " +
                                        Constants.QuizTable.COL_OPT2 + " TEXT, " +
                                        Constants.QuizTable.COL_OPT3 + " TEXT, " +
                                        Constants.QuizTable.COL_OPT4 + " TEXT, " +
                                        Constants.QuizTable.COL_ANS + " INTEGER, " +
                                        Constants.QuizTable.COL_CATEGORY + " TEXT" + ")";
        db.execSQL(CREATE_QN_TABLE);
        updateQn();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.QuizTable.NAME);
        onCreate(db);
    }

    private void updateQn(){
        Quiz q1 = new Quiz("Calculate: 14 + 7",
                "21", "22", "23", "24", 4, Quiz.CAT_ADDITION);
        addQn(q1);
        Quiz q2 = new Quiz("Calculate: 1 + 1",
                "0", "1", "2", "3", 3, Quiz.CAT_ADDITION);
        addQn(q2);
        Quiz q3 = new Quiz("Calculate: 6 + 7",
                "12", "13", "14", "15", 2, Quiz.CAT_ADDITION);
        addQn(q3);
        Quiz q4 = new Quiz("Calculate: 8 + 6",
                "12", "13", "14", "15", 3, Quiz.CAT_ADDITION);
        addQn(q4);
        Quiz q5 = new Quiz("Calculate: 18 + 3",
                "21", "22", "23", "24", 1, Quiz.CAT_ADDITION);
        addQn(q5);
        Quiz q6 = new Quiz("Calculate: 16 + 18",
                "24", "34", "26", "36", 2, Quiz.CAT_ADDITION);
        addQn(q6);
        Quiz q7 = new Quiz("Calculate: 24 + 19",
                "45", "35", "43", "35", 3, Quiz.CAT_ADDITION);
        addQn(q7);
        Quiz q8 = new Quiz("Calculate: 88 + 16",
                "94", "104", "96", "97", 2, Quiz.CAT_ADDITION);
        addQn(q8);
        Quiz q9 = new Quiz("Calculate: 104 + 27",
                "111", "133", "132", "131", 4, Quiz.CAT_ADDITION);
        addQn(q9);
        Quiz q10 = new Quiz("Calculate: 108 + 12",
                "120", "130", "110", "100", 1, Quiz.CAT_ADDITION);
        addQn(q10);
        Quiz q11 = new Quiz("Calculate: 69 + 96",
                "169", "145", "155", "165", 4, Quiz.CAT_ADDITION);
        addQn(q11);
        Quiz q12 = new Quiz("Calculate: 88 + 66",
                "188", "174", "154", "136", 3, Quiz.CAT_ADDITION);
        addQn(q12);
        Quiz q13 = new Quiz("Calculate: 111 + 99",
                "220", "200", "210", "199", 3, Quiz.CAT_ADDITION);
        addQn(q13);
        Quiz q14 = new Quiz("Calculate: 68 + 76",
                "123", "135", "144", "151", 3, Quiz.CAT_ADDITION);
        addQn(q14);
        Quiz q15 = new Quiz("Calculate: 356 + 987",
                "1245", "1343", "1355", "1223", 2, Quiz.CAT_ADDITION);
        addQn(q15);
        Quiz q16 = new Quiz("Calculate: 14 - 7",
                "6", "7", "8", "9", 2, Quiz.CAT_SUBTRACTION);
        addQn(q16);
        Quiz q17 = new Quiz("Calculate: 1 - 1",
                "0", "1", "2", "3", 1, Quiz.CAT_SUBTRACTION);
        addQn(q17);
        Quiz q18 = new Quiz("Calculate: 6 - 7",
                "-2", "13", "-1", "-3", 3, Quiz.CAT_SUBTRACTION);
        addQn(q18);
        Quiz q19 = new Quiz("Calculate: 8 - 6",
                "2", "3", "4", "5", 1, Quiz.CAT_SUBTRACTION);
        addQn(q19);
        Quiz q20 = new Quiz("Calculate: 18 - 3",
                "11", "12", "13", "15", 4, Quiz.CAT_SUBTRACTION);
        addQn(q20);
        Quiz q21 = new Quiz("Calculate: 16 - 18",
                "-2", "-3", "-4", "-5", 1, Quiz.CAT_SUBTRACTION);
        addQn(q21);
        Quiz q22 = new Quiz("Calculate: 24 - 19",
                "15", "3", "5", "15", 3, Quiz.CAT_SUBTRACTION);
        addQn(q22);
        Quiz q23 = new Quiz("Calculate: 88 - 16",
                "14", "24", "72", "74", 3, Quiz.CAT_SUBTRACTION);
        addQn(q23);
        Quiz q24 = new Quiz("Calculate: 104 - 27",
                "78", "77", "87", "88", 2, Quiz.CAT_SUBTRACTION);
        addQn(q24);
        Quiz q25 = new Quiz("Calculate: 108 - 12",
                "120", "130", "94", "96", 4, Quiz.CAT_SUBTRACTION);
        addQn(q25);
        Quiz q26 = new Quiz("Calculate: 69 - 96",
                "-165", "-27", "27", "165", 2, Quiz.CAT_SUBTRACTION);
        addQn(q26);
        Quiz q27 = new Quiz("Calculate: 88 - 66",
                "22", "74", "54", "32", 1, Quiz.CAT_SUBTRACTION);
        addQn(q27);
        Quiz q28 = new Quiz("Calculate: 111 - 99",
                "15", "20", "12", "19", 3, Quiz.CAT_SUBTRACTION);
        addQn(q28);
        Quiz q29 = new Quiz("Calculate: 68 - 76",
                "-8", "16", "8", "-16", 1, Quiz.CAT_SUBTRACTION);
        addQn(q29);
        Quiz q30 = new Quiz("Calculate: 356 - 987",
                "631", "1343", "-1343", "-631", 4, Quiz.CAT_SUBTRACTION);
        addQn(q30);
        Quiz q31 = new Quiz("Calculate: 2 X 2",
                "21", "24", "23", "4", 4, Quiz.CAT_MULTIPLICATION);
        addQn(q31);
        Quiz q32 = new Quiz("Calculate: 2 X 3",
                "0", "1", "6", "3", 3, Quiz.CAT_MULTIPLICATION);
        addQn(q32);
        Quiz q33 = new Quiz("Calculate: 2 X 4",
                "12", "8", "14", "15", 2, Quiz.CAT_MULTIPLICATION);
        addQn(q33);
        Quiz q34 = new Quiz("Calculate: 2 X 5",
                "12", "13", "10", "15", 3, Quiz.CAT_MULTIPLICATION);
        addQn(q34);
        Quiz q35 = new Quiz("Calculate: 2 X 6",
                "12", "22", "23", "24", 1, Quiz.CAT_MULTIPLICATION);
        addQn(q35);
        Quiz q36 = new Quiz("Calculate: 2 X 7",
                "24", "14", "26", "36", 2, Quiz.CAT_MULTIPLICATION);
        addQn(q36);
        Quiz q37 = new Quiz("Calculate: 2 X 8",
                "45", "35", "16", "35", 3, Quiz.CAT_MULTIPLICATION);
        addQn(q37);
        Quiz q38 = new Quiz("Calculate: 2 X 9",
                "94", "18", "96", "97", 2, Quiz.CAT_MULTIPLICATION);
        addQn(q38);
        Quiz q39 = new Quiz("Calculate: 2 X 10",
                "111", "133", "132", "20", 4, Quiz.CAT_MULTIPLICATION);
        addQn(q39);
        Quiz q40 = new Quiz("Calculate: 2 X 11",
                "22", "130", "110", "100", 1, Quiz.CAT_MULTIPLICATION);
        addQn(q40);
        Quiz q41 = new Quiz("Calculate: 2 X 12",
                "169", "145", "155", "24", 4, Quiz.CAT_MULTIPLICATION);
        addQn(q41);
        Quiz q42 = new Quiz("Calculate: 2 X 13",
                "188", "174", "26", "136", 3, Quiz.CAT_MULTIPLICATION);
        addQn(q42);
        Quiz q43 = new Quiz("Calculate: 2 X 14",
                "220", "200", "28", "199", 3, Quiz.CAT_MULTIPLICATION);
        addQn(q43);
        Quiz q44 = new Quiz("Calculate: 2 X 15",
                "123", "135", "30", "151", 3, Quiz.CAT_MULTIPLICATION);
        addQn(q44);
        Quiz q45 = new Quiz("Calculate: 56 X 24",
                "1245", "1344", "1355", "1223", 2, Quiz.CAT_MULTIPLICATION);
        addQn(q45);
        Quiz q46 = new Quiz("Calculate: 14 / 7",
                "6", "2", "8", "9", 2, Quiz.CAT_DIVISION);
        addQn(q46);
        Quiz q47 = new Quiz("Calculate: 1 / 1",
                "0", "1", "2", "3", 2, Quiz.CAT_DIVISION);
        addQn(q47);
        Quiz q48 = new Quiz("Calculate: 28 / 7",
                "-2", "13", "4", "-3", 3, Quiz.CAT_DIVISION);
        addQn(q48);
        Quiz q49 = new Quiz("Calculate: 24 / 6",
                "2", "3", "4", "5", 3, Quiz.CAT_DIVISION);
        addQn(q49);
        Quiz q50 = new Quiz("Calculate: 18 / 3",
                "11", "12", "13", "6", 4, Quiz.CAT_DIVISION);
        addQn(q50);
        Quiz q51 = new Quiz("Calculate: 144 / 12",
                "12", "-3", "-4", "-5", 1, Quiz.CAT_DIVISION);
        addQn(q51);
        Quiz q52 = new Quiz("Calculate: 21 / 3",
                "15", "3", "7", "15", 3, Quiz.CAT_DIVISION);
        addQn(q52);
        Quiz q53 = new Quiz("Calculate: 88 / 16",
                "14", "24", "5.5", "74", 3, Quiz.CAT_DIVISION);
        addQn(q53);
        Quiz q54 = new Quiz("Calculate: 105 / 3",
                "78", "35", "87", "88", 2, Quiz.CAT_DIVISION);
        addQn(q54);
        Quiz q55 = new Quiz("Calculate: 121 / 11",
                "120", "130", "94", "11", 4, Quiz.CAT_DIVISION);
        addQn(q55);
        Quiz q56 = new Quiz("Calculate: 999 / 111",
                "-165", "9", "27", "165", 2, Quiz.CAT_DIVISION);
        addQn(q56);
        Quiz q57 = new Quiz("Calculate: 162 / 27",
                "6", "74", "54", "32", 1, Quiz.CAT_DIVISION);
        addQn(q57);
        Quiz q58 = new Quiz("Calculate: 294 / 98",
                "15", "20", "3", "19", 3, Quiz.CAT_DIVISION);
        addQn(q58);
        Quiz q59 = new Quiz("Calculate: 100 / 4",
                "-25", "16", "8", "25", 4, Quiz.CAT_DIVISION);
        addQn(q59);
        Quiz q60 = new Quiz("Calculate: 5048 / 8",
                "631", "1343", "-1343", "-631", 1, Quiz.CAT_DIVISION);
        addQn(q60);

    }
    private void addQn(Quiz qsn) {
        ContentValues cv = new ContentValues();
        cv.put(Constants.QuizTable.COL_QUESTION, qsn.getQuestion());
        cv.put(Constants.QuizTable.COL_OPT1, qsn.getOption1());
        cv.put(Constants.QuizTable.COL_OPT2, qsn.getOption2());
        cv.put(Constants.QuizTable.COL_OPT3, qsn.getOption3());
        cv.put(Constants.QuizTable.COL_OPT4, qsn.getOption4());
        cv.put(Constants.QuizTable.COL_ANS, qsn.getCorrectAnswer());
        cv.put(Constants.QuizTable.COL_CATEGORY, qsn.getCategory());
        db.insert(Constants.QuizTable.NAME, null,cv);

    }

    public List<Quiz> getAllQn(){
        List<Quiz> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + Constants.QuizTable.NAME, null);
        if(c.moveToFirst()){
            do{
                Quiz qsn = new Quiz();
                qsn.setQuestion(c.getString(c.getColumnIndex(Constants.QuizTable.COL_QUESTION)));
                qsn.setOption1(c.getString(c.getColumnIndex(Constants.QuizTable.COL_OPT1)));
                qsn.setOption2(c.getString(c.getColumnIndex(Constants.QuizTable.COL_OPT2)));
                qsn.setOption3(c.getString(c.getColumnIndex(Constants.QuizTable.COL_OPT3)));
                qsn.setOption4(c.getString(c.getColumnIndex(Constants.QuizTable.COL_OPT4)));
                qsn.setCorrectAnswer(c.getInt(c.getColumnIndex(Constants.QuizTable.COL_ANS)));
                qsn.setCategory(c.getString(c.getColumnIndex(Constants.QuizTable.COL_CATEGORY)));
                questionList.add(qsn);
            }while(c.moveToNext());
        }
        c.close();
        return questionList;
    }


    public List<Quiz> getQn(String category){
        List<Quiz> questionList = new ArrayList<>();
        db = getReadableDatabase();
        String[] selection = new String[]{category};
        Cursor c = db.rawQuery("SELECT * FROM " + Constants.QuizTable.NAME + " WHERE " + Constants.QuizTable.COL_CATEGORY + " = ?", selection);
        if(c.moveToFirst()){
            do{
                Quiz qsn = new Quiz();
                qsn.setQuestion(c.getString(c.getColumnIndex(Constants.QuizTable.COL_QUESTION)));
                qsn.setOption1(c.getString(c.getColumnIndex(Constants.QuizTable.COL_OPT1)));
                qsn.setOption2(c.getString(c.getColumnIndex(Constants.QuizTable.COL_OPT2)));
                qsn.setOption3(c.getString(c.getColumnIndex(Constants.QuizTable.COL_OPT3)));
                qsn.setOption4(c.getString(c.getColumnIndex(Constants.QuizTable.COL_OPT4)));
                qsn.setCorrectAnswer(c.getInt(c.getColumnIndex(Constants.QuizTable.COL_ANS)));
                qsn.setCategory(c.getString(c.getColumnIndex(Constants.QuizTable.COL_CATEGORY)));
                questionList.add(qsn);
            }while(c.moveToNext());
        }
        c.close();
        return questionList;
    }
}
