package com.example.findwordbyphoto.presentation.start;

public interface StartContract {
    interface View {
        void start(int i);
        void exit();

    }
    interface Presenter {
        void start();
        void exit();

        void newGame();
    }
    interface Model {

    }
}
