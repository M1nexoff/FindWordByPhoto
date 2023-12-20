package com.example.findwordbyphoto.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.findwordbyphoto.R;
import com.example.findwordbyphoto.domein.AppController;

public class Finish extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        findViewById(R.id.finish).setOnClickListener(v->restartGame());
    }

    private void restartGame() {
        AppController appController = AppController.getInstance(this);
        appController.saveLevel(1);
    }
}