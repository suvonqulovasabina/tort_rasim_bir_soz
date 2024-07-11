package com.example.torta_rasim_bit_soz.prezonter.Scrin;

import com.example.torta_rasim_bit_soz.data.model.QuastionData;

public interface MainCantract {
    interface Model{
        QuastionData getQuestion(int index);
        int getQuestion();
    }
    interface View{

        void setVariant(QuastionData quastionData);

        void visebleVariant(int index);
        void visebleVariant();
        void InvesibleVariant(int index);
        void addAnswer(int index,String letter);
        void creadAnswer(int index);
        void creadAnswer();
        void removeAnswer();
        void removeVariant();
        void onClick();
        void GANAnswer(int index);
       boolean dialogOnclick();


        void creadAnswer(int index,String lettor);
    }
    interface Presenter{
        void onclickVariant(int index);
        void onclickAnswer(int index);
        void addGame();
    }
}
