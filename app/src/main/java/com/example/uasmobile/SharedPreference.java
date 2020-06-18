package com.example.uasmobile;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPreference {
    public static final String Prefs_name = "Shared_Pref_aplikasi";

    public SharedPreference(){
        super();
    }

    public void save(Context context,String key,String text){
        SharedPreferences setting;
        Editor editor;

        setting = context.getSharedPreferences(Prefs_name, Context.MODE_PRIVATE);
        editor=setting.edit();

        editor.putString(key, text);
        editor.commit();
    }

    public String getValue(Context context, String key){
        SharedPreferences setting;
        String text;

        setting = context.getSharedPreferences(Prefs_name, Context.MODE_PRIVATE);
        text = setting.getString(key, null);
        return text;

    }

    public void clearSharedPreference(Context context){
        SharedPreferences setting;
        Editor editor;

        setting = context.getSharedPreferences(Prefs_name, Context.MODE_PRIVATE);
        editor=((SharedPreferences) setting).edit();

        editor.clear();
        editor.commit();
    }


}
