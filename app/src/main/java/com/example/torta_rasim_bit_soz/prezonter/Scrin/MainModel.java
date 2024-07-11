package com.example.torta_rasim_bit_soz.prezonter.Scrin;

import com.example.torta_rasim_bit_soz.data.model.QuastionData;
import com.example.torta_rasim_bit_soz.domin.Appcontroler;

public class MainModel implements MainCantract.Model{
    Appcontroler appcontroler=Appcontroler.getInstens();
    @Override
    public QuastionData getQuestion(int index) {
        return appcontroler.getQuastion(index);
    }
    @Override
    public int getQuestion() {
        return appcontroler.getQuestion();
    }
}
