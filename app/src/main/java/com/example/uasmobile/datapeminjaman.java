package com.example.uasmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class datapeminjaman extends AppCompatActivity {

    //Deklarasi variable
    SQLiteDatabase myDB = null;
    String TableName = "Peminjaman";
    String Data = "";

    TextView dtPmjm;
    Button bSimpan, bEdit, bHapus;
    EditText tNim, tNama, tTgl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datapeminjaman);

        dtPmjm = (TextView)findViewById(R.id.txtDataPmjm);
        bSimpan = (Button)findViewById(R.id.btnSimpan);
        bEdit = (Button)findViewById(R.id.btnEdit);
        bHapus = (Button)findViewById(R.id.btnHapus);

        tNim = (EditText)findViewById(R.id.txtNim);
        tNama = (EditText)findViewById(R.id.txtNama);
        tTgl = (EditText)findViewById(R.id.txttgl);

        createDB();
        tampilData();

        bSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpan();
            }


        });

        bEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit();
            }
        });

        bHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hapus();
            }
        });
    }

    //Method Clear TextField

    public void clearField(){
        tNim.setText("");
        tNama.setText("");
        tTgl.setText("");
    }

    //Buat Method Create Database

    private void createDB() {
        try{
            myDB = this.openOrCreateDatabase("DBPMJM",MODE_PRIVATE,null);
            myDB.execSQL("CREATE TABLE IF NOT EXISTS " +
                    TableName + "(NIM VARCHAR PRIMARY KEY, NAMA VARCHAR, TGL VARCHAR);");

            //myDB.execSQL("Insert Into " + TableName + " Values('126','HusnulM','Lombok');");

        }catch (Exception e){
            //Log.e("Error", "Error", e);
        }
    }

    //Buat Method Tampilkan Data

    private void tampilData() {
        try{
            Data = "";
            clearField();
            Cursor c = myDB.rawQuery("Select * From " + TableName, null);
            int col1 = c.getColumnIndex("NIM");
            int col2 = c.getColumnIndex("NAMA");
            int col3 = c.getColumnIndex("TGL");
            c.moveToFirst();

            if (c!= null){
                do{
                    String nimMhs = c.getString(col1);
                    String nmMhs = c.getString(col2);
                    String tglkembali = c.getString(col3);

                    Data = Data + nimMhs + " | " + nmMhs+ " | " + tglkembali + "\n";
                }
                while (c.moveToNext());
            }
            dtPmjm.setText(Data);
        }catch (Exception e){
            dtPmjm.setText(Data);
        }
    }

    //Method Simpan Data

    private void simpan() {
        myDB.execSQL("Insert Into " + TableName + " Values('" + tNim.getText() + "','" + tNama.getText() + "','" + tTgl.getText() + "');");
        tampilData();
    }

    //Method Edit

    private void edit() {
        myDB.execSQL("Update " + TableName + " Set NAMA = '"+ tNama.getText() +"', TGL = '"+ tTgl.getText() +"' Where NIM = '"+ tNim.getText() +"';");
        tampilData();
    }

    //Method Hapus
    private void hapus() {
        myDB.execSQL("Delete From " + TableName + " Where NIM = '" + tNim.getText() + "';");
        tampilData();
    }



}
