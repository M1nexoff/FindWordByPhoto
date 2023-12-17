package com.example.findwordbyphoto.data.source;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Pref {
    private static Pref instance;
    private SharedPreferences pref;

    private Pref(Context context) {
        this.pref = context.getSharedPreferences("STATE", Context.MODE_PRIVATE);
    }

    public static synchronized Pref getInstance(Context context) {
        if (instance == null) {
            instance = new Pref(context);
        }
        return instance;
    }

    public void put(String key, String value) {
        pref.edit().putString(key, value).apply();
    }

    public String get(String key) {
        return pref.getString(key, null);
    }

    public void putLevel(int level) {
        pref.edit().putInt("LEVEL", level).apply();
    }
    public int getLevel() {
        return pref.getInt("LEVEL", 0);
    }
}
