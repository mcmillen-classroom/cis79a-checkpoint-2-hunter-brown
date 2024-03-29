package com.agrais.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView;
    private TextView mScoreView;

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mHintButton;
    private ImageButton mNextButton;
    private ImageButton mBackButton;

    private Question[] mQuestions;
    private Hint[] mHints;
    private int mIndex;
    private int mScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton=(Button)findViewById(R.id.true_button);
        mFalseButton=(Button)findViewById(R.id.false_button);
        mHintButton= (Button)findViewById(R.id.hint_button);
        mNextButton = (ImageButton)findViewById(R.id.next_button);
        mBackButton = (ImageButton)findViewById(R.id.back_button);

        mTrueButton.setOnClickListener(this);
        mFalseButton.setOnClickListener(this);
        mHintButton.setOnClickListener(this);
        mNextButton.setOnClickListener(this);
        mBackButton.setOnClickListener(this);

        mTextView=(TextView)findViewById(R.id.text_view);

        mScoreView=(TextView)findViewById(R.id.score_value);

        //Initialize Array of Questions
        mQuestions= new Question[7];
        mIndex = 0;


        //Initialize Array of Hints
        mHints= new Hint[7];

        //Initialize Score
        mScore= 0;
        String scr= String.valueOf(mScore);
        mScoreView.setText(scr);

        //Initialize each slot in the Questions array
        mQuestions[0] = new Question(R.string.question_1,true);
        mQuestions[1] = new Question(R.string.question_2,true);
        mQuestions[2] = new Question(R.string.question_3,true);
        mQuestions[3] = new Question(R.string.question_4,true);
        mQuestions[4] = new Question(R.string.question_5,false);
        mQuestions[5] = new Question(R.string.question_6,true);
        mQuestions[6] = new Question(R.string.question_7,false);

        //Initialize each slot in the Hints array
        mHints[0] = new Hint(R.string.hint_1);
        mHints[1] = new Hint(R.string.hint_2);
        mHints[2] = new Hint(R.string.hint_3);
        mHints[3] = new Hint(R.string.hint_4);
        mHints[4] = new Hint(R.string.hint_5);
        mHints[5] = new Hint(R.string.hint_6);
        mHints[6] = new Hint(R.string.hint_7);






        mTextView.setText(mQuestions[mIndex].getTextResId());
    }

    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.true_button) {
            checkAwnser(true);
        }
        else if (view.getId()== R.id.false_button) {
            checkAwnser(false);
        }
        else if (view.getId()== R.id.hint_button) {
            Toast myToast = Toast.makeText(this,  mHints[mIndex].getTextResId(), Toast.LENGTH_LONG);
            myToast.setGravity(Gravity.CENTER, 0, 0);
            myToast.show();
        }
        else if (view.getId()== R.id.next_button) {
                if( mIndex+1 < mQuestions.length) {
                    //Increment Question Index by 1
                    mIndex++;

                    //change to next question
                    mTextView.setText(mQuestions[mIndex].getTextResId());
                }
                else {
                    mIndex = 0;
                    mTextView.setText(mQuestions[mIndex].getTextResId());
                }
        }
        else if (view.getId()== R.id.back_button) {
            if( mIndex > 0) {
                //Increment Question Index by 1
                mIndex--;

                //change to next question
                mTextView.setText(mQuestions[mIndex].getTextResId());
            }
            else {
                mIndex = mQuestions.length-1;
                mTextView.setText(mQuestions[mIndex].getTextResId());
            }
        }


    }
    public boolean checkAwnser(boolean userInput){
        if( mQuestions[mIndex].getAnswer()== userInput){
            Toast myToast = Toast.makeText(this, "You are correct,", Toast.LENGTH_SHORT);
            myToast.setGravity(Gravity.TOP, 0, 0);
            myToast.show();
            mScore++;
            String scr= String.valueOf(mScore);
            mScoreView.setText(scr);
            return true;
        }
        else{
            Toast myToast = Toast.makeText(this, "You are incorrect,", Toast.LENGTH_SHORT);
            myToast.setGravity(Gravity.TOP, 0, 0);
            myToast.show();
            mScore--;
            String scr= String.valueOf(mScore);
            mScoreView.setText(scr);
            return false;
        }
    }

}
