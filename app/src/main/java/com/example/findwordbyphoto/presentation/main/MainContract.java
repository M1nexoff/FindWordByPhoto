package com.example.findwordbyphoto.presentation.main;

import com.example.findwordbyphoto.data.QuestionData;

import java.util.List;

public interface MainContract {
    interface Model {
        QuestionData getQuestionById(int id);
        List<String> getAnswers();
        List<Boolean> getVariants();
        int getLevel();
        void setLevel(int level);
        void setAnswers(List<String> answers);
        void setVariants(List<Boolean> variants);
    }
    interface View {
        void startFinish();
        void showDialogNext();
        void setImages(List<Integer> images);
        void clearAnswer();
        void setLevel(int level);
        void setVariants(String variants);
        void setVisibleVariant(int index);
        void setInvisibleVariant(int index);
        void setAnswer(int index, String answer);
        void deleteAnswer(int index);

        void showResult(String s);
        void exit();
    }
    interface Presenter {
        void restart();
        void nextLevel();
        void menu();
        void setQuestion(String newOrLoad);
        void clickAnswer(int index);
        void clickVariant(int index);
        void check();
        void save();
        void load();
    }
}
