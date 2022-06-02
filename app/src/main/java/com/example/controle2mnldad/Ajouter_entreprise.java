package com.example.controle2mnldad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Ajouter_entreprise extends AppCompatActivity {

    EditText e1,e2,e3;
    MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_entreprise);
        db=new MyDatabase(getApplicationContext());
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
    }





    public void Ajouter(View view) {
        if(e1.getText().toString().isEmpty()){
            Toast.makeText(this, "Raison sociale vide", Toast.LENGTH_SHORT).show();
            e1.requestFocus();
            return;
        }
        if(e1.getText().toString().isEmpty()){
            Toast.makeText(this, "Adresse vide", Toast.LENGTH_SHORT).show();
            e2.requestFocus();
            return;
        }
        if(e1.getText().toString().isEmpty()){
            Toast.makeText(this, "Capitale vide", Toast.LENGTH_SHORT).show();
            e3.requestFocus();
            return;
        }

        Entreprise e=new Entreprise();
        e.setRaisonSociale(e1.getText().toString());
        e.setAdresse(e2.getText().toString());
        e.setCapitale(Double.parseDouble(e3.getText().toString()));

        if(MyDatabase.AddEntreprise(db.getWritableDatabase(),e)==-1)
            Toast.makeText(this, "Insertion echouer", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Insertion reussi", Toast.LENGTH_SHORT).show();
    }
    public void annuler(View view) {
        finish();
    }
}