package com.example.controle2mnldad;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {


        public static String DB_NAME = " enterprises.db»";
        public static String TABLE_NAME = "enterprises";
        public static String COL1 = "ID";
        public static String COL2 = "RaisonSociale";
        public static String COL3 = "Adresse";
        public static String COL4 = "Capitale ";

    public MyDatabase (Context c) {
            super(c, DB_NAME, null, 1); }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + TABLE_NAME + "(" + COL1 + " integer primary key autoincrement," + COL2 + " text," + COL3 + " text," + COL4 + " double)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
