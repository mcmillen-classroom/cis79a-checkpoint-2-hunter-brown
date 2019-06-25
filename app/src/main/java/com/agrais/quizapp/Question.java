package com.agrais.quizapp;

import java.io.StreamCorruptedException;

public class Question {

    private int mTextResId;

    private boolean mAnswer;

    public Question(int TextResId, boolean answer )
    {
        mTextResId=TextResId;
        mAnswer=answer;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean getAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }


}
