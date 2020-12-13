package com.example.kinomap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private EditText name;
    private Button buttonMenu;
    String name0;
    private static final String SHARED_PREF = "user";
    private static final String KEY = "key_user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.name = findViewById(R.id.name);
        this.buttonMenu = findViewById(R.id.buttonMenu);
        buttonMenu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                name0 = name.getText().toString();
                if (name0.isEmpty()){
                    name.setError("erreur");
                    name.requestFocus();
                } else {
                    SharedPreferences sp = getSharedPreferences(SHARED_PREF,  MODE_PRIVATE);
                    SharedPreferences.Editor spe = sp.edit();
                    spe.putString(KEY, name0);
                    spe.apply();
                    Intent activity2 = new Intent(getApplicationContext(), ViewVehicle.class);
                    startActivity(activity2);
                    Toast.makeText(getApplicationContext(), "Bienvenue", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }


        });
    }


}