package com.example.uasmobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class databuku extends AppCompatActivity {

    String[] daftar;
    Menu menu;
    ListView ListView01;
    sql dbHelper;
    protected Cursor cursor;
    public static databuku ma;
    private Object android;
    private String add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_databuku2);
        ma = this;
        dbHelper = new sql(this);
        RefreshList();
    }

    private void RefreshList() {
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        cursor = db.rawQuery("Select * FROM buku", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc<cursor.getCount();cc++){
            cursor.moveToPosition(cc);
            daftar[cc]=cursor.getString(1).toString();
        }

        ListView01 = (ListView) findViewById(R.id.ListView01);
        ListView01.setAdapter(new ArrayAdapter<Object>(this,android.R.layout.simple_list_item_1,daftar));
        ListView01.setSelected(true);
        ((ArrayAdapter)ListView01.getAdapter()).notifyDataSetInvalidated();
        ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                //TODO Aut--generated method stub
                final String selection = daftar[arg2];
                final CharSequence[] dialogitem=("Edit","Delete");
                AlertDialog.Builder builder = new AlertDialog.Builder(databuku.this);
                builder.setTitle("PILIH");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item){
                            case 0;
                            Intent inten = new Intent(databuku.this,Edit.class);
                            inten.putExtra("judul_buku", selection);
                                    startActivity(inten);
                                    break;
                                    case 1;
                                    SQLiteDatabase db=dbHelper.getWritableDatabase();
                                    String sql="DELETE from buku where judul_buku='"+ selection +"'";
                                    db.execSQL(sql);
                                    RefreshList();
                                    break;

                        }
                    }
                });
                builder.create().show();
            }
        });
    }

    @Override
    public boolean OnCreateOptionsMenu (Menu menu){
        this.menu=menu;
        menu.add(0,1,0,"Tambah");
        menu.add(0,2,0,"Refresh");
        menu.add(0,3,0,"Exit");
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case 1;
                //koding menampilkan activity tambah
                Intent intent = new Intent(databuku.this.add.class);
                startActivities(intent);
                return true;
            case 2;
                RefreshList();
                return true;
            case 3;
                finish();
                return true;

        }
        return false;
    }
}
