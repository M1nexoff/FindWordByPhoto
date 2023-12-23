package com.example.findwordbyphoto.presentation.main;

import android.content.Context;

import com.example.findwordbyphoto.data.QuestionData;
import java.util.ArrayList;
import java.util.List;

public class MainPresenter implements MainContract.Presenter {
    private  int score = 0;
    private static final int MAX_LENGTH = 8;
    private int level;
    private List<String> answers = new ArrayList<>();
    private List<Boolean> variants = new ArrayList<>();
    private MainContract.View view;
    private MainContract.Model model;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        this.model = new MainModel((Context) view);
        level = model.getLevel();
    }

    @Override
    public void setQuestion(String s) {
        if (s!=null){
            level = 0;
            model.setLevel(level);
        }
        if (level>8){
            model.setLevel(0);
            view.startFinish();
            return;
        }
        QuestionData question = model.getQuestionById(level);
        view.clearAnswer();
        for (int i = 0; i < MAX_LENGTH; i++) {
            if (question.getAnswer().length() <= i) {
                view.deleteAnswer(i);
            } else {
                answers.add(null);
            }
        }
        view.setLevel(level+1);
        view.setImages(question.getImages());
        view.setVariants(question.getVariant());
        for (int i = 0; i < question.getVariant().length(); i++) {
            variants.add(false);
        }
    }
    @Override
    public void clickAnswer(int index) {
        String clickedAnswer = answers.get(index);
        if (clickedAnswer == null || clickedAnswer.equals("")) {
            return;
        }
        QuestionData questionData = model.getQuestionById(level);
        String variants = questionData.getVariant();

        for (int i = 0; i < variants.length(); i++) {
            String currentVariant = String.valueOf(variants.charAt(i));
            if (clickedAnswer.equals(currentVariant) && this.variants.get(i)) {
                answers.set(index, null);
                view.setAnswer(index, "");
                view.setVisibleVariant(i);
                this.variants.set(i, false);
                return;
            }
        }
    }

    @Override
    public void clickVariant(int index) {
        int freeIndex = answers.indexOf(null);
        if (freeIndex == -1) return;
        QuestionData questionData = model.getQuestionById(level);
        answers.set(freeIndex, String.valueOf(questionData.getVariant().charAt(index)));
        view.setAnswer(freeIndex, String.valueOf(questionData.getVariant().charAt(index)));
        view.setInvisibleVariant(index);
        this.variants.set(index, true);
        freeIndex = answers.indexOf(null);
        if (freeIndex == -1) check();
    }

    @Override
    public void check() {
        StringBuilder userAnswers = new StringBuilder();
        for (String answer : answers) {
            if (answer != null) {
                userAnswers.append(answer);
            }
        }

        QuestionData questionData = model.getQuestionById(level);
        String correctAnswer = questionData.getAnswer();

        if (!userAnswers.toString().equals(correctAnswer)) {
            view.showResult("Incorrect!");
            return;
        }
        model.setLevel(level+1);
        view.showDialogNext();
    }

    @Override
    public void save() {

    }

    @Override
    public void load() {

    }

    @Override
    public void restart() {
        for (int i = 0; i < answers.size(); i++) {
            clickAnswer(i);
        }
    }

    @Override
    public void nextLevel() {
        level++;
        answers.clear();
        variants.clear();
        setQuestion(null);
    }

    @Override
    public void menu() {
        view.exit();
    }
}