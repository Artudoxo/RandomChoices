package com.liarkat.randomchoices;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.String;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button solve;
    private Spinner sp1,sp2, spop;
    private EditText etmin, etmax;
    private ImageButton btnrandom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnsolve = findViewById(R.id.solve);
        final Spinner sp1 = findViewById(R.id.sp1);
        final Spinner sp2 = findViewById(R.id.sp2);
        final Spinner spop = findViewById(R.id.spop);
        ImageButton btnrandom = findViewById(R.id.imgbutton);

        btnrandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random ran = new Random();

                EditText txt1 = findViewById(R.id.etmin);
                EditText txt2 = findViewById(R.id.etmax);

                int val1 = Integer.parseInt(txt1.getText().toString());
                int val2 = Integer.parseInt(txt2.getText().toString());

                int nresult = val2 - val1;
                int [] arr = new int[nresult];
                for(nresult = 0; nresult < arr.length; nresult++){
                    arr[nresult]= ran.nextInt();
                }
                //int ranint = ran.nextInt(nresult);


                String ranintstring = Arrays.toString(arr);
                try{
                    sp1.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, Collections.singletonList(ranintstring)));
                    sp2.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, Collections.singletonList(ranintstring)));
                    //Toast.makeText(getApplicationContext(), ranintstring, Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Ups!, algo esta mal bro!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnsolve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    int selec1 = Integer.parseInt(sp1.getSelectedItem().toString());
                    int selec2 = Integer.parseInt(sp2.getSelectedItem().toString());
                    String selec3 = spop.getSelectedItem().toString();

                    if (selec3.equals("Multiplicación")){
                        int multiplicacion = selec1 * selec2;
                        String result = String.valueOf(multiplicacion);
                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                    } else if (selec3.equals("División")){
                        int dividir = selec1 / selec2;
                        String result = String.valueOf(dividir);
                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                    } else if (selec3.equals("Suma")){
                        int sumar = selec1 + selec2;
                        String result = String.valueOf(sumar);
                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                    }else if (selec3.equals("Resta")){
                        int resta = selec1 - selec2;
                        String result = String.valueOf(resta);
                        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Algo esta mal, revisa bien los spinners!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
