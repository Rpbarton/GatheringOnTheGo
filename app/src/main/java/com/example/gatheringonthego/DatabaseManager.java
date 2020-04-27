package com.example.gatheringonthego;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {

    public DatabaseManager(Context context){
        super(context, "DeckDB", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        String sql = "create table DeckTable(";
        sql += "id integer primary key autoincrement, ";
        sql += "name text, cmc text, oracle text)";
        db.execSQL(sql);
    }

    public void insert(String cardName, String cmcName, String oracleName) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "insert into DeckTable values(";
        sql += "null, '"+cardName+"', '"+cmcName+"', '"+oracleName+"')";
        db.execSQL(sql);
        db.close();
    }

    public ArrayList<String> getTitles() {
        ArrayList<String> list = new ArrayList<String>();
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select * from DeckTable";
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()) {
            String name = cursor.getString(1);
            list.add(name);
        }
        db.close();
        return list;
    }

    public String[] get(String cardName){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "select * from DeckTable where name = '"+cardName+"' ";
        Cursor cursor = db.rawQuery(sql, null);
        String[] entry  = new String[3];
        if(cursor.moveToFirst()) {
            String name = cursor.getString(1);
            String cmc = cursor.getString(2);
            String oracle = cursor.getString(3);
            entry[0] = name;
            entry[1] = cmc;
            entry[2] = oracle;
        }
        db.close();
        return entry;
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
