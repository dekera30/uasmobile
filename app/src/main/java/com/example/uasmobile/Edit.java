package com.example.uasmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Edit extends AppCompatActivity {

    EditText txtjudulbuku,txtnamapengarang,txttahunterbit,txtpenerbit;
    Button btnSimpan;
    sql dbHelper;
    protected Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        dbHelper =new sql(this);
        txtjudulbuku = (EditText)findViewById(R.id.txtJudulBuku);
        txtnamapengarang = (EditText)findViewById(R.id.txtPengarang);
        txttahunterbit = (EditText)findViewById(R.id.txtTahunTerbit);
        txtpenerbit = (EditText)findViewById(R.id.txtPenerbit);
        btnSimpan = (EditText)findViewById(R.id.btnSimpan);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql="SELECT * from buku where judul_buku = '"+ getIntent().getStringExtra("judul buku")+"'";
        cursor=db.rawQuery(sql, null);
        cursor.moveToFirst();
        if (cursor.getColumnCount()>0){
            cursor.moveToPosition(0);
            txtjudulbuku.setText(cursor.getString(1).toString());
            txtnamapengarang.setText(cursor.getString(2).toString());
            txttahunterbit.setText(cursor.getString(3).toString());
            txtpenerbit.setText(cursor.getString(4).toString());
        }

        btnSimpan.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onCLick(View arg0){
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String sql="UPDATE buku SET judul_buku = '"+ txtjudulbuku.getText().toString() +"',"+
                        "nama_pengarang = '"+ txtnamapengarang.getText().toString() +"',"+
                        "tahun_terbit = '"+ txttahunterbit.getText().toString() +"',"+
                        "penerbit = '"+ txtpenerbit.getText().toString() +"'"+
                        "WHERE judul_buku = '"+ getIntent().getStringExtra("judul buku") +"'";
                db.execSQL(sql);
                Toast.makeText(getApplicationContext(), "Berhasil Mengubah Data", Toast.LENGTH_LONG).show();
                databuku.ma.RefreshList();
                finish();
            }
        });


    }
}
