package com.example.findwordbyphoto.data.source;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;

public class Pref {
    private static Pref instance;
    private SharedPreferences pref;

    private Pref(Context context) {
        pref = context.getSharedPreferences("MyGame", Context.MODE_PRIVATE);
    }
    public static Pref getInstance(Context context) {
        if (instance == null) {
            instance = new Pref(context);
        }
        return instance;
    }
    public void saveScore(int score) {
        pref.edit().putInt("SCORE", score).apply();
    }
    public int getScore() {
        return pref.getInt("SCORE", 0);
    }
    public void saveButtonsAnswers(List<String> s){
        StringBuilder sb = new StringBuilder();
        for (String answer : s) {
            if (answer.length()==0){
                sb.append('*');
            }else{
                sb.append(answer);
            }
        }
        pref.edit().putString("BUTTONS_ANSWERS", sb.toString()).apply();
    }
    public List<String> getButtonsAnswers(){
        String answerS = pref.getString("BUTTONS_ANSWERS", "********");
        List<String> answerL= new ArrayList<String>();
        for (int i = 0; i < answerS.length(); i++) {
            if (answerS.charAt(i) == '*'){
                answerL.add("");
            }else{
                answerL.add(String.valueOf(answerS.charAt(i)));
            }
        }
        return answerL;
    }
    public void saveButtonsVariants(List<Boolean> variants){
        StringBuilder sb = new StringBuilder();
        for (Boolean variant : variants) {
            if (variant){
                sb.append("1");
            }else {
                sb.append("0");
            }
        }
        pref.edit().putString("BUTTONS_VARIANTS", sb.toString()).apply();
    }
    public List<Boolean> getButtonsVariants(){
        String variantS = pref.getString("BUTTONS_VARIANTS", "000000000000");
        List<Boolean> answerL= new ArrayList<Boolean>();
        for (int i = 0; i < variantS.length(); i++) {
            if (variantS.charAt(i) == '1'){
                answerL.add(true);
            }else {
                answerL.add(false);
            }
        }
        return answerL;
    }
    public void saveLastLevel(int level) {
        pref.edit().putInt("LEVEL", level).apply();
    }

    public int getLastLevel() {
        return pref.getInt("LEVEL", 0);
    }
}