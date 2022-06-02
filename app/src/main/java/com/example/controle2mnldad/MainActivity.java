package com.example.controle2mnldad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void accederer(View view) {
        Intent i = null;
        switch (view.getId()) {
            case (R.id.btnAdd):
                i = new Intent(MainActivity.this, Ajouter_entreprise.class);
                break;
            case (R.id.btnEdit):
                i = new Intent(MainActivity.this, Edite_entreprise.class);
                break;
            case (R.id.btnAllEnt):
                i = new Intent(MainActivity.this, Lister_entreprise.class);
                break;
        }
        startActivity(i);
    }
}