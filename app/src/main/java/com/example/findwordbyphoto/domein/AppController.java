package com.example.findwordbyphoto.domein;

import android.content.Context;

import com.example.findwordbyphoto.R;
import com.example.findwordbyphoto.data.QuestionData;
import com.example.findwordbyphoto.data.source.Pref;

import java.util.ArrayList;
import java.util.List;

public class AppController {
    private static AppController instance;
    private Pref pref;
    private int level;

    public static AppController getInstance(Context context) {
        if (instance == null) {
            instance = new AppController(context);
        }
        return instance;
    }
    private AppController(Context context) {
        pref = Pref.getInstance(context);
        level = pref.getLastLevel();
    }
    public List<String> getButtonsAnswers(){
        return pref.getButtonsAnswers();
    }
    public List<Boolean> getButtonsVariants(){
        return pref.getButtonsVariants();
    }
    public void setButtonsVariants(List<Boolean> buttonsVariants){
        pref.saveButtonsVariants(buttonsVariants);
    }
    public void setButtonsAnswers(List<String> buttonsAnswers){
        pref.saveButtonsAnswers(buttonsAnswers);
    }
    public int getLevel() {
        return pref.getLastLevel();
    }
    public void saveLevel(int level) {
        pref.saveLastLevel(level);
    }
    public void incrementLevel() {
        level++;
    }
    public QuestionData getQuestionByLevel(int level) {
        switch (level) {
            case 0:
                return new QuestionData("java", "dikvbacajfeg", R.drawable.level3_1, R.drawable.level3_2, R.drawable.level3_3, R.drawable.level3_4);
            case 1:
                return new QuestionData("bed", "vgdfaijakecb", R.drawable.level6_1, R.drawable.level6_2, R.drawable.level6_3, R.drawable.level6_4);
            case 2:
                return new QuestionData("bank", "ndjfgkbaleic", R.drawable.level9_1, R.drawable.level9_2, R.drawable.level9_3, R.drawable.level9_4);
            case 3:
                return new QuestionData("time", "fgijmatcedkb", R.drawable.level8_1, R.drawable.level8_2, R.drawable.level8_3, R.drawable.level8_4);
            case 4:
                return new QuestionData("fruit", "guaebjdritfc", R.drawable.level1_1, R.drawable.level1_2, R.drawable.level1_3, R.drawable.level1_4);
            case 5:
                return new QuestionData("hacker", "ajdrkiefhbcg", R.drawable.level2_1, R.drawable.level2_2, R.drawable.level2_3, R.drawable.level2_4);
            case 6:
                return new QuestionData("mouse", "famobiuedscg", R.drawable.level7_1, R.drawable.level7_2, R.drawable.level7_3, R.drawable.level7_4);
            case 7:
                return new QuestionData("cactus", "tecusfcdaibg", R.drawable.level5_1, R.drawable.level5_2, R.drawable.level5_3, R.drawable.level5_4);
            case 8:
                return new QuestionData("android", "cofdidrebagn", R.drawable.level4_1, R.drawable.level4_2, R.drawable.level4_3, R.drawable.level4_4);
            default:
                return null;
        }
    }
}
