package com.example.intencjejawne;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), Activity2.class));
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Activity2.class);
                //intent.putExtra("Imie", "Adam");
                //intent.putExtra("rozmiar buta", 41);
                EditText imie = findViewById(R.id.imie);
                EditText rozmier = findViewById(R.id.rozmiar);
                intent.putExtra("Imie", imie.getText().toString());
                intent.putExtra("rozmiar buta",
                        Integer.parseInt(rozmier.getText().toString()));
                startActivity(intent);
            }
        });
    }

    public void log(View view){
        Intent intent = new Intent(this, Activity3.class);
        getResult.launch(intent);

    }

    ActivityResultLauncher<Intent> getResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    // pobranie danych
                    Intent data = result.getData();
                    if(data!=null){
                        String imie = data.getStringExtra("imie");
                        Toast.makeText(MainActivity.this, "Witaj "+ imie,
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
    );
}