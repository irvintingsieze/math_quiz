package com.project.mathquiz;

import android.provider.BaseColumns;

public final class Constants {

    public static class QuizTable implements BaseColumns {
        public static final String NAME = "questions";
        public static final String COL_QUESTION = "question";
        public static final String COL_OPT1 = "opt1";
        public static final String COL_OPT2 = "opt2";
        public static final String COL_OPT3 = "opt3";
        public static final String COL_OPT4 = "opt4";
        public static final String COL_ANS = "ansNum";
        public static final String COL_CATEGORY = "category";

    }

}
