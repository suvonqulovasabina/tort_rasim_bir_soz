package com.example.torta_rasim_bit_soz.prezonter.Scrin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.torta_rasim_bit_soz.R;
import com.example.torta_rasim_bit_soz.data.model.QuastionData;
import com.example.torta_rasim_bit_soz.data.sors.Preferens;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainCantract.View {
    ImageView imageView;
    List<Button> variantButton = new ArrayList<>(12);
    List<Button> answerButton = new ArrayList<>(8);
    MainCantract.Presenter presenter;
    Preferens preferens;
    int b=0;
    private SharedPreferences preferences;
    List<ImageView> imageViews = new ArrayList<>(4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences=this.getSharedPreferences("Play", Context.MODE_PRIVATE);
        setContentView(R.layout.mayoyn);
        preferens = Preferens.getPreferens();
        quastion();
        init();
        init1();
        presenter = new MainPresenter(this);
    }

    private void init() {
        LinearLayout layout = findViewById(R.id.meva1);
        for (int i = 0; i < layout.getChildCount(); i++) {
            Button button = (Button) layout.getChildAt(i);
            int index = i;
            button.setOnClickListener(v -> {
                presenter.onclickAnswer(index);
            });
            answerButton.add(button);
        }
    }

    private void quastion() {
        imageViews.add(findViewById(R.id.btMeva1));
        imageViews.add(findViewById(R.id.btmeva2));
        imageViews.add(findViewById(R.id.btmeva3));
        imageViews.add(findViewById(R.id.btMeva4));
    }
    public void init1() {
        LinearLayout layout1 = findViewById(R.id.meva2);
        for (int i = 0; i < layout1.getChildCount(); i++) {
            int index = i;
            Button button = (Button) layout1.getChildAt(i);
            button.setOnClickListener(v -> {
                presenter.onclickVariant(index);
            });
            variantButton.add(button);
        }
        LinearLayout layout2 = findViewById(R.id.meva3);
        for (int i = 0; i < layout2.getChildCount(); i++) {
            Button button = (Button) layout2.getChildAt(i);
            int index = i + layout1.getChildCount();
            button.setOnClickListener(v -> {
                presenter.onclickVariant(index);
            });
            variantButton.add(button);
        }
    }

    @Override
    protected void onStart() {

        super.onStart();
    }

    @Override
    protected void onPause() {
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i < variantButton.size(); i++) {
            builder.append(variantButton.get(i));
        }
        preferences.edit().putString("saveNumber", builder.toString()).apply();
        for (int i = 0; i < 4; i++) {

        }
        super.onPause();
    }

    @Override
    public void InvesibleVariant(int index) {
        variantButton.get(index).setVisibility(View.INVISIBLE);
    }
    @Override
    public void setVariant(QuastionData quastionData) {
        char[] val = quastionData.getVariant().toCharArray();
        for (int i = 0; i < variantButton.size(); i++) {
            variantButton.get(i).setText(String.valueOf(val[i]));
        }
        for (int i = quastionData.getAnswer().length(); i < 8; i++) {
            answerButton.get(i).setVisibility(View.GONE);
        }
        imageViews.get(0).setImageResource(quastionData.getImage());
        imageViews.get(1).setImageResource(quastionData.getImage1());
        imageViews.get(2).setImageResource(quastionData.getImage2());
        imageViews.get(3).setImageResource(quastionData.getImage3());
    }

    @Override
    public void visebleVariant(int index) {
        variantButton.get(index).setVisibility(View.VISIBLE);
    }
    @Override
    public void visebleVariant() {
        for (int i = 0; i < 12; i++) {
            variantButton.get(i).setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void addAnswer(int index, String letter) {
        answerButton.get(index).setText(letter);
    }

    @Override
    public void creadAnswer(int indesx) {
        answerButton.get(indesx).setText("");
    }

    @Override
    public void creadAnswer() {
        for (int i = 0; i < 8; i++) {
            answerButton.get(i).setText("");
        }
    }
    @Override
    public void removeAnswer() {
        variantButton.clear();
    }
    @Override
    public void removeVariant() {
    }

    @Override
    public void onClick() {
        click();
    }
    @Override
    public void GANAnswer(int index) {
        answerButton.get(index).setVisibility(View.GONE);
    }

    @Override
    public boolean dialogOnclick() {
        int a=0;
        MyDialog dialog=new MyDialog();

        dialog.setEventListener(new SelectEventListener() {
            @Override
            public void clickFinish() {
                presenter.addGame();
              b=2;
            }

        });

        dialog.show(getSupportFragmentManager(),"");
        return b == 2;

    }

    @Override
    public void creadAnswer(int index, String lettor) {
    }
    public void click() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        StringBuilder s = new StringBuilder();
//        for (int i = 0; i < variantButton.size(); i++) {
//            s.append(variantButton.get(i)).append("#");
//        }
//        preferens.seveLastLevel(s.toString());
//    }


}