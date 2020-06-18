package com.example.uasmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.Menu;

public class profile extends AppCompatActivity {

    TextView textuser;
    SharedPreference sp;
    Activity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        sp = new SharedPreference();
        textuser=(TextView) findViewById(R.id.txtuserprofile);
        String username;
        username= sp.getValue(context, "username");

        textuser.setText(username);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.profile, menu);
        return true;
    }


}
