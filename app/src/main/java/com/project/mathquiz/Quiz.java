package com.project.mathquiz;

public class Quiz {

    public static final String CAT_ADDITION = "Addition";
    public static final String CAT_SUBTRACTION = "Subtraction";
    public static final String CAT_MULTIPLICATION = "Multiplication";
    public static final String CAT_DIVISION = "Division";

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int correctAnswer;



    private String category;

    public Quiz(){}

    public Quiz(String question, String option1, String option2, String option3, String option4, int correctAnswer, String category) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.correctAnswer = correctAnswer;
        this.category = category;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static String[] getAllCategory(){
        return new String[]{
                CAT_ADDITION,CAT_SUBTRACTION,CAT_MULTIPLICATION,CAT_DIVISION
        };
    }
}
