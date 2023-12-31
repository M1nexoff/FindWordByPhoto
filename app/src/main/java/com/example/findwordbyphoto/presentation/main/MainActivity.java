package com.example.findwordbyphoto.presentation.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.findwordbyphoto.R;
import com.example.findwordbyphoto.presentation.Finish;
import com.example.findwordbyphoto.presentation.dialog.*;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private List<ImageView> images;
    private List<Button> answers = new ArrayList<>();
    private List<Button> variants = new ArrayList<>();
    private TextView level;
    private MainContract.Presenter presenter;
    private ImageView backButton;
    private ImageView resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        String s = getIntent().getStringExtra("game");
        presenter = new MainPresenter(this);
        presenter.setQuestion(s);
    }

    private void initialize() {
        level = findViewById(R.id.level);
        backButton = findViewById(R.id.back);
        resetButton = findViewById(R.id.restart);

        backButton.setOnClickListener(v->presenter.menu());
        resetButton.setOnClickListener(v->presenter.restart());

        images = new ArrayList<>();
        images.add(findViewById(R.id.imgQuestion1));
        images.add(findViewById(R.id.imgQuestion2));
        images.add(findViewById(R.id.imgQuestion3));
        images.add(findViewById(R.id.imgQuestion4));

        answers.addAll(findButtons(R.id.linerAnswers, 0, this::clickAnswer));
        variants.addAll(findButtons(R.id.linerVariant1, 0, this::clickVariant));
        variants.addAll(findButtons(R.id.linerVariant2, variants.size(), this::clickVariant));
    }

    private void clickAnswer(View view) {
        presenter.clickAnswer((Integer) view.getTag());
    }

    private void clickVariant(View view) {
        presenter.clickVariant((Integer) view.getTag());
    }

    private List<Button> findButtons(int linerId, int position, View.OnClickListener listener) {
        List<Button> buttons = new ArrayList<>();
        LinearLayout layout = findViewById(linerId);
        for (int i = 0; i < layout.getChildCount(); i++) {
            Button button = (Button) layout.getChildAt(i);
            button.setTag(i + position);
            button.setOnClickListener(listener);
            buttons.add(button);
        }
        return buttons;
    }

    @Override
    public void showDialogNext() {
        MyDialog dialog = new MyDialog();
            dialog.setSelectListener(new SelectListener() {
                @Override
                public void next() {
                    presenter.nextLevel();
                }

                @Override
                public void menu() {
                    presenter.menu();
                }
            });
            dialog.setCancelable(false);
            dialog.show(getSupportFragmentManager(), "test");
    }

    @Override
    public void setImages(List<Integer> images) {
        for (int i = 0; i < images.size(); i++) {
            this.images.get(i).setImageResource(images.get(i));
        }
    }

    @Override
    public void clearAnswer() {
        for (int i = 0; i < answers.size(); i++) {
            answers.get(i).setVisibility(View.VISIBLE);
            answers.get(i).setText("");
        }
    }

    @Override
    public void setLevel(int level) {
        this.level.setText(String.valueOf(level));

    }

    @Override
    public void setVariants(String variants) {
        for (int i = 0; i < this.variants.size(); i++) {
            this.variants.get(i).setVisibility(View.VISIBLE);
            this.variants.get(i).setText(String.valueOf(variants.charAt(i)));
        }
    }

    @Override
    public void setVisibleVariant(int index) {
        variants.get(index).setVisibility(View.VISIBLE);
    }

    @Override
    public void setInvisibleVariant(int index) {
        variants.get(index).setVisibility(View.INVISIBLE);
    }

    @Override
    public void setAnswer(int index, String answer) {
        answers.get(index).setText(answer);
    }

    @Override
    public void deleteAnswer(int index) {
        if (index >= 0 && index < answers.size()) {
            answers.get(index).setVisibility(View.GONE);
        }
    }

    @Override
    public void showResult(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void exit() {
        finish();
    }

    @Override
    protected void onStop() {
        presenter.save();
        super.onStop();
    }
    @Override
    public void startFinish() {
        Intent intent = new Intent(MainActivity.this, Finish.class);
        startActivity(intent);
        finish();
    }
}
