package com.example.findwordbyphoto.presentation.start;

import android.content.Intent;

public class StartPresenter implements StartContract.Presenter {
    private StartContract.View view;
    private StartContract.Model model;
    public StartPresenter(StartContract.View view){
        this.view = view;
        this.model = new StartModel();
    }
    @Override
    public void start() {
        view.start(0);
    }

    @Override
    public void exit() {
        view.exit();
    }

    @Override
    public void newGame() {
        view.start(1);
    }
}
