package com.example.uasmobile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class sql extends SQLiteOpenHelper{
    private static final String DATABASE_NAME="buku.db"
    private static final int DATABASE_VERSION=1;

    public sql(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql ="create table buku (id integer primary key autoincrement, " +
                " judul_buku text null," +
                " nama_pengarang text null," +
                " tahun_terbit text null," +
                " penerbit text null);";
        Log.d("Data","OnCreate:"+sql);
        db.execSQL(sql);
        sql="INSERT INTO buku(id,judul_buku,nama_pengarang,tahun_terbit,penerbit)" +
                " VALUES (1,'Penerapan Sistem Informasi','Jogiyanto','2010','Andi');";

        db.execSQL(sql);
        sql="INSERT INTO buku(id,judul_buku,nama_pengarang,tahun_terbit,penerbit)" +
                " VALUES (2,'Pengantar TI','Sutarman','2012','Bumi AKsara');";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

