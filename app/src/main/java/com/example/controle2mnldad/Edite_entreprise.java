package com.example.controle2mnldad;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class Edite_entreprise extends AppCompatActivity {
    Spinner sp;
    MyDatabase db;
    EditText e1,e2,e3;
    ArrayList<Entreprise> entrps;
    ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edite_entreprise);
        db=new MyDatabase(getApplicationContext());
        sp=findViewById(R.id.sp);
        e1=findViewById(R.id.e1Edit);
        e2=findViewById(R.id.e2Edit);
        e3=findViewById(R.id.e3Edit);
        entrps=MyDatabase.getAllEntreprise(db.getReadableDatabase());
        ArrayList<String> id=new ArrayList<>();
        for(Entreprise e:entrps)
            id.add(String.valueOf(e.getID()));
        ad=new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,id);
        sp.setAdapter(ad);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Entreprise e=entrps.get(i);
                e1.setText(e.getRaisonSociale());
                e2.setText(e.getAdresse());
                e3.setText(String.valueOf(e.getCapitale()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    }


