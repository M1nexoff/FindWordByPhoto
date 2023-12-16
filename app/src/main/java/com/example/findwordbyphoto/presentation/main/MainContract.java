package com.example.findwordbyphoto.presentation.main;

import com.example.findwordbyphoto.data.QuestionData;

import java.util.List;

public interface MainContract {
    interface Model {
        QuestionData getQuestionById(int id);
    }
    interface View {
        void setImages(List<Integer> images);
        void clearAnswer();
        void setVariants(String variants);
        void setVisibleVariant(int index);
        void setInvisibleVariant(int index);
        void setAnswer(int index, String answer);
        void deleteAnswer(int index);

        void showResult(String s);
    }
    interface Presenter {
        void setQuestion();
        void clickAnswer(int index);
        void clickVariant(int index);
        void check();
    }
}
