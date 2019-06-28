package com.liarkat.randomchoices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.String;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button solve;
    private Spinner sp1,sp2, spop;
    private EditText etmin, etmax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnsolve = findViewById(R.id.solve);
        Spinner sp1 = findViewById(R.id.sp1);
        Spinner sp2 = findViewById(R.id.sp2);
        Spinner spop = findViewById(R.id.spop);




        btnsolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Random r = new Random();
                    EditText etmin = findViewById(R.id.etmin);
                    EditText etmax = findViewById(R.id.etmax);
                    String etextmin = etmin.getText().toString();
                    String etextmax = etmax.getText().toString();
                    int finaletextmin = Integer.parseInt(etextmin);
                    int finaletextmax = Integer.parseInt(etextmax);
                    int randomNumber = r.nextInt((finaletextmax-finaletextmin)+1)+finaletextmin;

                    Toast.makeText(MainActivity.this,
                            randomNumber, Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Ups! Algo estas haciendo mal bro!", Toast.LENGTH_LONG).show();
                };

            }
        });
    }
}
