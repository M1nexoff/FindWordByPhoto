package com.example.findwordbyphoto.data.source;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Pref {
    private SharedPreferences pref;
    public Pref(Context context) {
        this.pref = context.getSharedPreferences("STATE", Context.MODE_PRIVATE);
    }
    public void put(String key, String value) {
        pref.edit().putString(key, value).apply();
    }
    public String get(String key) {
        return pref.getString(key, null);
    }
    public void putLevel(String key,int level) {
        pref.edit().putInt(key, level).apply();
    }
}
