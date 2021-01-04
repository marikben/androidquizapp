package com.example.inno3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DBhelper db;
    ListView lista;
    Button arvo, again;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lopetus);

        lista = findViewById(R.id.ehdotukset);
        again = findViewById(R.id.uudestaan);

        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBaccess datacces = DBaccess.getInstance(getApplicationContext());
                datacces.open();
                //tähän tulisi ne hakuehdot, jotka saa nappien teksteistä
                //String n = getjne
                //String nimi = DBaccess.getNimiElokuva(virkeys, paikka, hinta);
                //lisättäisiin kaikki jutut listaan ja kun kaikki kategoriat käyty läpi
                //suoritettaisiin arvonta ja sitten lisättäisiin tulokset listaobjekteihin
                //dataccess.close();
            }
        });

    }
}
