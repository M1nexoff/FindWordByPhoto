package com.example.findwordbyphoto.presentation.main;


import com.example.findwordbyphoto.data.QuestionData;
import com.example.findwordbyphoto.domein.AppController;

public class MainModel implements MainContract.Model{
    private AppController appController;
    public MainModel() {
        appController = AppController.getInstance();
    }

    @Override
    public QuestionData getQuestionById(int id) {
        return appController.getQuestionByLevel(id);
    }
}
