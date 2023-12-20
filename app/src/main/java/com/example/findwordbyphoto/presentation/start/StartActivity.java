package com.example.findwordbyphoto.presentation.start;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.findwordbyphoto.R;
import com.example.findwordbyphoto.presentation.main.MainActivity;

public class StartActivity extends AppCompatActivity implements StartContract.View {
    private AppCompatButton playButton;
    private AppCompatButton exitButton;
    private AppCompatButton newGame;
    private StartContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        initialize();
        presenter = new StartPresenter(this);

    }

    private void initialize() {
        playButton = (AppCompatButton) findViewById(R.id.loadButton);
        exitButton = (AppCompatButton) findViewById(R.id.exitButton);
        newGame = (AppCompatButton) findViewById(R.id.newButton);
        newGame.setOnClickListener(view -> presenter.newGame());
        playButton.setOnClickListener(view -> presenter.start());
        exitButton.setOnClickListener(view -> presenter.exit());
    }

    @Override
    public void start(int i) {
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        if (i==1){
            intent.putExtra("game", "newGame");
        }
        startActivity(intent);
    }

    @Override
    public void exit() {
        new AlertDialog.Builder(StartActivity.this)
                .setMessage("Are you want to exit?")
                .setTitle("Exit?")
                .setPositiveButton("Exit", (dialog, which) -> finish())
                .setNegativeButton("Cancel", (dialog, which) -> {})
                .create().show();
    }
}