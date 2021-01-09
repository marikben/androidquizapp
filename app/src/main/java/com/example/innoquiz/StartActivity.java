package com.example.innoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.innoquiz.R;

public class StartActivity extends AppCompatActivity {
private Button aloitus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        aloitus =(Button)findViewById(R.id.aloita);
        
        aloitus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent i = new Intent(StartActivity.this, MainActivity.class);
                    StartActivity.this.finish();
                    startActivity(i);

            }
        });
    }
}
