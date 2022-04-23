package com.example.intencjejawne;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String imie = bundle.getString("Imie");
            int rozmiar = bundle.getInt("rozmiar buta");
            Toast.makeText(this, "Mam na imię "+ imie
                            + " mój rozmiar buta to " + rozmiar
                    , Toast.LENGTH_SHORT).show();
        }
    }
}