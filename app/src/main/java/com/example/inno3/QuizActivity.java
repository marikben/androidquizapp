package com.example.inno3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
    private QuestionLib kyssarit = new QuestionLib();

    private TextView kysymys;
    private Button valinta1;
    private Button valinta2;
    private Button valinta3;
    private ArrayList<String> vastauxet;

    private int kysnro = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        kysymys = (TextView)findViewById(R.id.text_view_question_1);
        valinta1 = (Button)findViewById(R.id.vasynyt);
        valinta2 = (Button)findViewById(R.id.normaali);
        valinta3 = (Button)findViewById(R.id.virkea);


        valinta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kyssarit.mQuestions.length == kysnro){
                    Intent i = new Intent(QuizActivity.this, Results.class);
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("Vastauksesi", vastauxet);
                    i.putExtras(bundle);
                    //Tässä kohti pitää jotenkin lisätä vastaukset ja lähettää ne results-activityyn
                    QuizActivity.this.finish();
                    startActivity(i);

                }else{
                    String vastaus = (String) valinta1.getText();
                    vastauxet.add(vastaus);
                    updateQuestion();
                }

            }
        });
        valinta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kyssarit.mQuestions.length == kysnro){
                    Intent i = new Intent(QuizActivity.this, Results.class);
                    Bundle bundle = new Bundle();
                    //Tässä kohti pitää jotenkin lisätä vastaukset ja lähettää ne results-activityyn
                    QuizActivity.this.finish();
                    startActivity(i);

                }else{
                    String vastaus = (String) valinta1.getText();
                    vastauxet.add(vastaus);
                    updateQuestion();
                }
            }
        });
        valinta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kyssarit.mQuestions.length == kysnro){
                    Intent i = new Intent(QuizActivity.this, Results.class);
                    Bundle bundle = new Bundle();
                    //Tässä kohti pitää jotenkin lisätä vastaukset ja lähettää ne results-activityyn
                    QuizActivity.this.finish();
                    startActivity(i);

                }else{
                    String vastaus = (String) valinta1.getText();
                    vastauxet.add(vastaus);
                    updateQuestion();
                }
            }
        });


    }

    private void updateQuestion(){
        kysymys.setText((kyssarit.getQuestion(kysnro)));
        valinta1.setText(kyssarit.getChoice1(kysnro));
        valinta2.setText(kyssarit.getChoice2(kysnro));
        valinta3.setText(kyssarit.getChoice3(kysnro));
        kysnro++;
    }
}
