package com.example.fsi_notes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DataSource {
    private SQLiteDatabase sqLiteDatabase;
    private MySQLHelper db;

    public DataSource(Context context){

        db = new MySQLHelper(context);
    }

    public void open () throws SQLException {
        sqLiteDatabase = db.getWritableDatabase();
    }

    public String info(){
        return db.TABLE_COMMENT;
    }

    public void close(){
        db.close();
    }

    public Utilisateur insertuser(Utilisateur utilisateur){
        ContentValues values = new ContentValues();
        values.put("id", utilisateur.getId());
        values.put("nomUti", utilisateur.getNomUti());
        values.put("preUti", utilisateur.getPreUti());
        values.put("telUti", utilisateur.getTelUti());
        values.put("mailUti", utilisateur.getMailUti());
        values.put("nomMaitapp", utilisateur.getNomMaitapp());
        values.put("preMaitapp", utilisateur.getPreMaitapp());
        values.put("telMaitapp", utilisateur.getTelMaitapp());
        values.put("mailMaitapp", utilisateur.getMailMaitapp());
        values.put("nomEnt", utilisateur.getNomEnt());
        values.put("nomTut", utilisateur.getNomTut());
        values.put("preTut", utilisateur.getPreTut());
        values.put("telTut", utilisateur.getTelTut());
        values.put("mailTut", utilisateur.getMailTut());
        values.put("datVisBil1", utilisateur.getDatVisBil1());
        values.put("notEnt", utilisateur.getNotEntBil1());
        values.put("notDosBil1", utilisateur.getNotDosBil1());
        values.put("notOraBil1", utilisateur.getNotOrBil1());
        values.put("moyBil1", utilisateur.getMoyBil1());
        values.put("remBil1", utilisateur.getRemBil1());
        values.put("datVisBil2", utilisateur.getDatVisBil2());
        values.put("notDosBil2", utilisateur.getNotDossBil2());
        values.put("notOraBil2", utilisateur.getNotOrBil2());
        values.put("moyBil2", utilisateur.getMoyBil2());
        values.put("remBil2", utilisateur.getRemBil2());

        int id  = (int) sqLiteDatabase.insert("Utilisateur", null, values);
        utilisateur.setId(id);

        return utilisateur;
    }

    public Utilisateur getsoloUtilisateur() {
        Utilisateur unutilsateur = null;

        Cursor cursor = sqLiteDatabase.query(true, "Utilisateur", new String[]{"id", "nomUti", "preUti", "telUti", "mailUti","nomMaitapp", "preMaitapp", "telMaitapp", "mailMaitapp", "nomEnt", "nomTut", "preTut", "telTut", "mailTut", "datVisBil1", "notEnt", "notDosBil1", "notOraBil1", "moyBil1", "remBil1", "datVisBil2", "notDosBil2", "notOraBil2", "moyBil2", "remBil2"}, null, null, null, null, null, "1" // LIMIT 1 pour récupérer un seul utilisateur
        );

        if (cursor.moveToFirst()) {
            unutilsateur = cursorToUtilisateur(cursor);
        }

        cursor.close();
        return unutilsateur;
    }


    public void deleteUtilisateur(){
        sqLiteDatabase.delete("Utilisateur", null, null);
    }

    private Utilisateur cursorToUtilisateur(Cursor cursor) {
        Utilisateur cursorutilsateur = new Utilisateur(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10), cursor.getString(11), cursor.getString(12), cursor.getString(13), cursor.getString(14), cursor.getFloat(15), cursor.getFloat(16), cursor.getFloat(17), cursor.getFloat(18), cursor.getString(19), cursor.getString(20), cursor.getFloat(21), cursor.getFloat(22), cursor.getFloat(23), cursor.getString(24));
        return cursorutilsateur;
    }
}