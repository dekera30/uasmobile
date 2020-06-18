package com.example.uasmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity  {
    Button btnprofil, btnkeluar, btnaboutus,btnmhs,btnpmjm, btndatabuku;
    SharedPreference sp;
    Activity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnprofil = (Button) findViewById(R.id.btnprofil);
        btnkeluar = (Button) findViewById(R.id.btnkeluar);
        sp = new SharedPreference();

        btnprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Menu.this,profile.class);
                startActivity(intent);
            }
        });

        btnkeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.clearSharedPreference(context);
                finish();
            }
        });

        btnaboutus=findViewById(R.id.btnaboutus);
        btnaboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menu.this.getApplicationContext(), aboutus.class);
                Menu.this.startActivity(intent);
            }
        });

        btnmhs=findViewById(R.id.btnmhs);
        btnmhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menu.this.getApplicationContext(), datamahasiswa.class);
                Menu.this.startActivity(intent);
            }
        });

        btnpmjm=findViewById(R.id.btnpmjm);
        btnpmjm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menu.this.getApplicationContext(), datapeminjaman.class);
                Menu.this.startActivity(intent);
            }
        });

        btndatabuku=findViewById(R.id.btndatabuku);
        btndatabuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Menu.this.getApplicationContext(), databuku.class);
                Menu.this.startActivity(intent);
            }
        });

    }

    public void add(int i, int i1, int i2, String tambah) {
    }
}
