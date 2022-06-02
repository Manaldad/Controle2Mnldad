package com.example.controle2mnldad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {


        public static String DB_NAME = " enterprises.db»";
        public static String TABLENAME = "enterprises";
        public static String COL1 = "ID";
        public static String COL2 = "RaisonSociale";
        public static String COL3 = "Adresse";
        public static String COL4 = "Capitale";

    public MyDatabase (Context c) {
            super(c, DB_NAME, null, 1); }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLENAME + "(" + COL1 + " integer primary key autoincrement," + COL2 + " text," + COL3 + " text," + COL4 + " double)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE " + TABLENAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
    public static long AddEntreprise(SQLiteDatabase db, Entreprise e){
        ContentValues ct = new ContentValues();
        ct.put(COL2, e.getRaisonSociale());
        ct.put(COL3, e.getAdresse());
        ct.put(COL4, e.getCapitale());
        return db.insert(TABLENAME, null, ct);
    }

    public static long UpdateEntreprise(SQLiteDatabase db, Entreprise e){
        ContentValues ct = new ContentValues();
        ct.put(COL2, e.getRaisonSociale());
        ct.put(COL3, e.getAdresse());
        ct.put(COL4, e.getCapitale());
        return db.update(TABLENAME, ct, "ID = " + e.getID(), null);
    }

    public static long DeleteEntreprise(SQLiteDatabase db, int id) {
        return db.delete(TABLENAME, "ID = " + id, null);
    }
    public static ArrayList<Entreprise> getAllEntreprise(SQLiteDatabase db) {
        ArrayList<Entreprise> entreprises = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLENAME, null);

        while (c.moveToNext()) {
            Entreprise e = new Entreprise();
            e.setID(c.getInt(0));
            e.setRaisonSociale(c.getString(1));
            e.setAdresse(c.getString(2));
            e.setCapitale(c.getDouble(3));

            entreprises.add(e);
        }

        return entreprises;
    }

    public static Entreprise getOneEntreprise(SQLiteDatabase db, int id) {
        Entreprise e = null;
        Cursor c = db.rawQuery("SELECT * from " + TABLENAME + " WHERE id=" + id, null);
        if(c.moveToNext()){
            e=new Entreprise();
            e.setID(c.getInt(0));
            e.setRaisonSociale(c.getString(1));
            e.setAdresse(c.getString(2));
            e.setCapitale(c.getDouble(3));

        }

        return e;
    }
}
