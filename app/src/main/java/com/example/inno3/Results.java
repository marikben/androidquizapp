package com.example.inno3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Results extends AppCompatActivity {
    TextView vastaukset;
    Button again, arvo;
    String tunne, raha, paikka;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lopetus);
        vastaukset = (TextView)findViewById(R.id.ehdotukset);
        again = (Button)findViewById(R.id.uudestaan);
        arvo = (Button)findViewById(R.id.arvo);

        Bundle bundle = getIntent().getExtras();
        ArrayList<String> valinnat = bundle.getStringArrayList("Vastauksesi");
        tunne = valinnat.get(0);
        raha = valinnat.get(1);
        paikka = valinnat.get(2);

        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Results.this, QuizActivity.class));
                Results.this.finish();
            }
        });
    }

}
