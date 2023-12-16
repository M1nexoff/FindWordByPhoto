package com.example.findwordbyphoto.domein;

import com.example.findwordbyphoto.R;
import com.example.findwordbyphoto.data.QuestionData;

public class AppController {
    private static AppController instance;
    public static AppController getInstance() {
        if (instance == null) {
            instance = new AppController();
        }
        return instance;
    }
    private AppController() {}
    public QuestionData getQuestionByLevel(int level) {
        switch (level) {
            case 0:
                return new QuestionData("fruit", "guaebjdritfc", R.drawable.level1_1, R.drawable.level1_2, R.drawable.level1_3, R.drawable.level1_4);
            case 1:
                return new QuestionData("hacker", "ajdrkiefhbcg", R.drawable.level2_1, R.drawable.level2_2, R.drawable.level2_3, R.drawable.level2_4);
            case 2:
                return new QuestionData("java", "dikvbacajfeg", R.drawable.level3_1, R.drawable.level3_2, R.drawable.level3_3, R.drawable.level3_4);

            default:
                return new QuestionData("fruit", "guaebjdritfc", R.drawable.level1_1, R.drawable.level1_2, R.drawable.level1_3, R.drawable.level1_4);
        }
    }
}
