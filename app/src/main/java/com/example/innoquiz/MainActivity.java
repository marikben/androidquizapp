package com.example.innoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.innoquiz.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

        private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

        private TextView mQuestionView;
        private Button mButtonChoice1;
        private Button mButtonChoice2;
        private Button mButtonChoice3;
        private Button alku;
        //tähän vastauksille mAnswer string arraylist
    private int mQuestionNumber = 0;
    private String mVastaukset= "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1= (Button)findViewById(R.id.valinta1);
        mButtonChoice2= (Button)findViewById(R.id.valinta2);
        mButtonChoice3= (Button)findViewById(R.id.valinta3);
        alku=(Button)findViewById(R.id.alusta);
        updateQuestion();

        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVastaukset= mVastaukset+mButtonChoice1.getText().toString()+" ";
                if(mQuestionNumber==mQuestionLibrary.mQuestion.length){
                    Intent i = new Intent(MainActivity.this, ResultsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("vastaukset", mVastaukset);
                    i.putExtras(bundle);
                    MainActivity.this.finish();
                    startActivity(i);
                }else{

                    updateQuestion();
                }
            }
        });
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVastaukset= mVastaukset+mButtonChoice2.getText().toString()+" ";
                if(mQuestionNumber==mQuestionLibrary.mQuestion.length){
                    Intent i = new Intent(MainActivity.this, ResultsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("vastaukset", mVastaukset);
                    i.putExtras(bundle);
                    MainActivity.this.finish();
                    startActivity(i);
                }else{

                    updateQuestion();
                }
            }
        });
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVastaukset= mVastaukset+mButtonChoice3.getText().toString()+" ";
                if(mQuestionNumber==mQuestionLibrary.mQuestion.length){
                    Intent i = new Intent(MainActivity.this, ResultsActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("vastaukset", mVastaukset);
                    i.putExtras(bundle);
                    MainActivity.this.finish();
                    startActivity(i);
                }else{

                    updateQuestion();
                }
            }
        });


        alku.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    Intent i = new Intent(MainActivity.this, StartActivity.class);
                    MainActivity.this.finish();
                    startActivity(i);

                }
        });
    }
    private void updateQuestion(){
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
        mQuestionNumber++;
    }



}