package com.example.findwordbyphoto.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.example.findwordbyphoto.R;
import com.example.findwordbyphoto.domein.AppController;
import com.example.findwordbyphoto.presentation.main.MainActivity;

public class Finish extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        findViewById(R.id.finish).setOnClickListener(v->restartGame());
        findViewById(R.id.menu).setOnClickListener(v->menu());
    }
    private void restartGame() {
        AppController appController = AppController.getInstance(this);
        appController.saveLevel(0);
        Intent intent = new Intent(Finish.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    private void menu() {
        AppController appController = AppController.getInstance(this);
        appController.saveLevel(0);
        finish();
    }
}