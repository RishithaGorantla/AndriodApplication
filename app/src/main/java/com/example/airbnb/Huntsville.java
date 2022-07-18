package com.example.airbnb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Huntsville extends AppCompatActivity {
    ImageButton huntsville1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.huntsville_main);

        huntsville1 = (ImageButton) findViewById(R.id.huntsville1);

        huntsville1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(Huntsville.this, Ville.class);
                startActivity(intent);
            }

        });
    }
}
