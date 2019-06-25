package com.agrais.quizapp;

public class Hint {
   private int mTextResId;

    public Hint(int textResId) {
        mTextResId = textResId;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }
}
