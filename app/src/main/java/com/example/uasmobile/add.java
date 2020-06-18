package com.example.uasmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add extends AppCompatActivity {

    sql dbHelper;
    Button btnSimpan;
    EditText txtjudulbuku, txtnamapengarang, txttahunterbit, txtpenerbit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        dbHelper = new sql(this);
        txtjudulbuku=(EditText)findViewById(R.id.txtJudulBuku);
        txtnamapengarang=(EditText)findViewById(R.id.txtPengarang);
        txttahunterbit=(EditText)findViewById(R.id.txtTahunTerbit);
        txtpenerbit=(EditText)findViewById(R.id.txtPenerbit);
        btnSimpan=(Button) findViewById(R.id.btnSimpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db= dbHelper.getWritableDatabase();
                String sql="INSERT INTO buku(judul_buku,nama_pengarang,tahun_terbit,penerbit)" +
                        " VALUES ('"+ txtjudulbuku.getText().toString() +"',"+
                        "         '"+ txtnamapengarang.getText().toString() +"',"+
                        "         '"+ txttahunterbit.getText().toString() +"',"+
                        "          '"+ txtpenerbit.getText().toString() +"')";
                db.execSQL(sql);
                Toast.makeText(getApplicationContext(), "Berhasil Menambah Data", Toast.LENGTH_LONG).show();

                databuku.ma.RefreshList();
                finish();
            }
        });
    }
}
