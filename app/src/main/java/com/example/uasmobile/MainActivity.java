package com.example.uasmobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    EditText txtusername, txtpassword;
    Button btnlogin;
    private SharedPreference sp;
    Activity context = this;
    private String Menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = new SharedPreference();

        txtusername = (EditText) findViewById(R.id.txtusername);
        txtpassword = (EditText) findViewById(R.id.txtpassword);
        btnlogin = (Button) findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtusername.getText().toString();

                if (username.equals("")) {
                    Toast.makeText(getBaseContext(), "Username masing kosong!", Toast.LENGTH_LONG).show();
                } else {
                    sp.save(context, "username", username);
                    Intent intent = new Intent(MainActivity.this, Menu.class);
                    startActivity(intent);
                    Toast.makeText(getBaseContext(), "Berhasil Login", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    }
