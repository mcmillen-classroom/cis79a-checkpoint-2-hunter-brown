package com.agrais.quizapp;

public class Question {

    private int mTextResId;
    private boolean mAnswerTrue;

    public Question(int TextResId, boolean answerTrue )
    {
        mTextResId=TextResId;
        mAnswerTrue=answerTrue;
    }
}
