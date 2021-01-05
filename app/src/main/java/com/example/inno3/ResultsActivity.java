package com.example.innoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ResultsActivity extends AppCompatActivity {
    private Button alusta, random;
    private TextView vastauxet;
    private ListView ehdot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        vastauxet=(TextView)findViewById(R.id.results);
        ehdot= (ListView) findViewById(R.id.paatos);
        alusta= (Button)findViewById(R.id.alkuun);
        random = (Button)findViewById(R.id.random);


        Bundle bundle = getIntent().getExtras();
        String lopetus = bundle.getString("vastaukset");
        // vastauxet.setText(lopetus);
        String valinnat [] = lopetus.split(" ");
        final String virkeys = valinnat[0];
        String paikka = valinnat[1];
        if(paikka.equals("Sisällä")){
            paikka="'s'";
        }else if(paikka.equals("Ulkona")){
            paikka="'u'";
        }else {
            paikka="'u' OR SisallaUlkona='s'";
        }

        String raha = valinnat[2];
        if(raha.equals("Maksullinen")){
            raha="1";
        }else{
            raha="0";
        }

        alusta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ResultsActivity.this, StartActivity.class);
                ResultsActivity.this.finish();
                startActivity(i);

            }
        });

        final String finalPaikka = paikka;
        final String finalRaha = raha;
        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    DBAccess databaseAccess = DBAccess.getInstance(getApplicationContext());
                    databaseAccess.open();
                    String n = virkeys;
                    String m= finalPaikka;
                    String o= finalRaha;
                    String nimi = databaseAccess.getName(n, m, o);
                    String nimi1 = databaseAccess.getName2(n, m);
                    String nimi2 = databaseAccess.getName3(n);
                    String nimi3 = databaseAccess.getName4(n);
                    String nimi4 = databaseAccess.getName5(n);
                    String nimi5 = databaseAccess.getName6(o);
                    String kaikki = nimi+nimi1+nimi2+nimi3+nimi4+nimi5;
                    String str[] = kaikki.split(",");
                    List<String> allin = Arrays.asList(str);
                    Collections.shuffle(allin);
                    String valitut [] = allin.toArray(str);
                    String vara [] = {valitut[0], valitut[1], valitut[2], valitut[3],valitut[4], valitut[5], valitut[6], valitut[7], valitut[8]};

                ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(vara));
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(ResultsActivity.this, android.R.layout.simple_list_item_1, arrayList);


                ehdot.setAdapter( adapter );

                    databaseAccess.close();



            }
        });


    }
}