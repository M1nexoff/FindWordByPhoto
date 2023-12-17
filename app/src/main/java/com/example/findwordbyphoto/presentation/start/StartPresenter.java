package com.example.findwordbyphoto.presentation.start;

public class StartPresenter implements StartContract.Presenter {
    private StartContract.View view;
    private StartContract.Model model;
    public StartPresenter(StartContract.View view){
        this.view = view;
        this.model = new StartModel();
    }
    @Override
    public void start() {
        view.start();
    }

    @Override
    public void exit() {
        view.exit();
    }
}
