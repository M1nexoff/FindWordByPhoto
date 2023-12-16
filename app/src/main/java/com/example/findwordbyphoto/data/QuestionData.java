package com.example.findwordbyphoto.data;

import java.util.ArrayList;
import java.util.List;

public class QuestionData {
    private String answer;
    private String variant;
    private int image1;
    private int image2;
    private int image3;
    private int image4;

    public QuestionData(String answer, String variant, int image1, int image2, int image3, int image4) {
        this.answer = answer;
        this.variant = variant;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
    }

    public String getAnswer() {
        return answer;
    }

    public String getVariant() {
        return variant;
    }

    public List<Integer> getImages() {
        List<Integer> images = new ArrayList<>();
        images.add(image1);
        images.add(image2);
        images.add(image3);
        images.add(image4);
        return images;
    }
}
