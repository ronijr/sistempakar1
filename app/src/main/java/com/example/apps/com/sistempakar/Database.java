package com.example.apps.com.sistempakar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RONIJR on 7/31/18.
 */

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME ="sistempakar";
    private static final String TABLE_DIAGNOSA ="table_diagnosa";

    private static final String ID="id";
    private static final String MD="md";
    private static final String MB="mb";
    private static final String NAME="name";
    private static final String ID_PENYAKIT ="id_penyakit";

    public Database(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE "+TABLE_DIAGNOSA + "("
                + ID + " TEXT PRIMARY KEY,"
                + MD + " DOUBLE,"
                + NAME + " TEXT,"
                + ID_PENYAKIT + " TEXT,"
                + MB + " DOUBLE" + ")";

        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DIAGNOSA);
        onCreate(db);
    }


    // Created
    public void addDiagnosa(Diagnosa diagnosa) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ID, diagnosa.getId());
        values.put(MD, diagnosa.getMd());
        values.put(MB, diagnosa.getMb());
        values.put(NAME, diagnosa.getName());
        values.put(ID_PENYAKIT, diagnosa.getId_penyakit());

        db.insert(TABLE_DIAGNOSA, null, values);
        db.close();
    }

    // Reading Data
    public Diagnosa getDiagnosa(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_DIAGNOSA, new String[]{ ID, MD, NAME,ID_PENYAKIT,MB}, ID + "=?",
                new String[]{id}, null, null,null,null);

        if(cursor != null) {
            cursor.moveToFirst();
        }

        Diagnosa diagnosa = new Diagnosa(cursor.getString(0),
                Double.parseDouble(cursor.getString(4)),
                Double.parseDouble(cursor.getString(1)),
                cursor.getString(3),
                cursor.getString(2));

        return diagnosa;
    }

    // Reading All Data
    public List<Diagnosa> getAllDiagnosa() {
        List<Diagnosa> diagnosaList = new ArrayList<Diagnosa>();

        // Select All Query
        String selectQuery = "SELECT * FROM "+ TABLE_DIAGNOSA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do {
                Diagnosa diagnosa = new Diagnosa();
                diagnosa.setId(cursor.getString(0));
                diagnosa.setMd(Double.parseDouble(cursor.getString(1)));
                diagnosa.setName(cursor.getString(2));
                diagnosa.setId_penyakit(cursor.getString(3));
                diagnosa.setMb(Double.parseDouble(cursor.getString(4)));

                // Adding contact to list
                diagnosaList.add(diagnosa);
            } while (cursor.moveToNext());
        }

        return diagnosaList;
    }


}
