package com.example.torta_rasim_bit_soz.prezonter.Scrin;

import android.icu.text.Normalizer2;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.torta_rasim_bit_soz.data.model.QuastionData;
import com.example.torta_rasim_bit_soz.data.sors.Preferens;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Map;

public class MainPresenter implements MainCantract.Presenter {
    private MainCantract.View view;
    private MainCantract.Model model;
    private int index = 0;
    List<Integer> integers = new ArrayList<>();
    List<String> list1 = new ArrayList<>();

    public MainPresenter(MainCantract.View view) {
        this.view = view;
        model = new MainModel();
        setQuestion();
    }

    private void setQuestion() {
        if (this.index < model.getQuestion()) {

            QuastionData quastionData = model.getQuestion(index);
            view.setVariant(quastionData);
            for (int i = 0; i < 8; i++) {
                if (i >= quastionData.getAnswer().length()) {
                    view.GANAnswer(i);
                } else {
                    list1.add(null);
                }
            }
            view.visebleVariant();
            view.creadAnswer();
        } else {
            view.onClick();
        }
    }



    @Override
    public void onclickVariant(int index) {
        int answerIndex = list1.indexOf(null);
        if (answerIndex == -1) return;
        QuastionData quastionData = model.getQuestion(this.index);
        String s = quastionData.getVariant();
        list1.set(answerIndex, String.valueOf(quastionData.getVariant().charAt(index)));
        integers.add(answerIndex,index);
        view.addAnswer(answerIndex, String.valueOf(quastionData.getVariant().charAt(index)));
        view.InvesibleVariant(index);
        if (count()) {
        view.dialogOnclick();
        }
    }



    @Override
    public void onclickAnswer(int index) {
        int y=list1.indexOf(null);
        if (list1.get(index)==null) return;
        view.creadAnswer(index);
        if (integers.get(index)!=null) {
            view.visebleVariant(integers.get(index));

        }
        list1.set(index,null);
    }



    @Override
    public void addGame() {
            if (this.index < model.getQuestion()) {
                this.index++;
                view.removeVariant();
                list1.clear();
                integers.clear();
                view.creadAnswer();
                setQuestion();
            } else {
                view.onClick();

            }
    }
    public boolean count() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < list1.size(); i++) {
            s.append(list1.get(i));
        }
        return s.toString().equals(model.getQuestion(this.index).getAnswer()) && s.length() == model.getQuestion(index).getAnswer().length();
    }

}