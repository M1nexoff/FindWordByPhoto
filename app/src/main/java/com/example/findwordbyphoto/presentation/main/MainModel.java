package com.example.findwordbyphoto.presentation.main;


import android.content.Context;

import com.example.findwordbyphoto.data.QuestionData;
import com.example.findwordbyphoto.domein.AppController;

import java.util.List;

public class MainModel implements MainContract.Model{
    private AppController appController;
    public MainModel(Context context) {
        appController = AppController.getInstance(context);
    }

    @Override
    public QuestionData getQuestionById(int id) {
        return appController.getQuestionByLevel(id);
    }

    @Override
    public List<String> getAnswers() {
        return appController.getButtonsAnswers();
    }

    @Override
    public List<Boolean> getVariants() {
        return appController.getButtonsVariants();
    }

    @Override
    public int getLevel() {
        return appController.getLevel();
    }

    @Override
    public void setLevel(int level) {
        appController.saveLevel(level);
    }

    @Override
    public void setAnswers(List<String> answers) {
        appController.setButtonsAnswers(answers);
    }

    @Override
    public void setVariants(List<Boolean> variants) {
        appController.setButtonsVariants(variants);
    }

}
