package com.example.torta_rasim_bit_soz.domin;

import com.example.torta_rasim_bit_soz.R;
import com.example.torta_rasim_bit_soz.data.model.QuastionData;

import java.util.ArrayList;
import java.util.List;

public class Appcontroler {
    private static Appcontroler appcontroler;
    List<QuastionData> quastionData = new ArrayList<>();
    private Appcontroler() {
        setVariant();
    }

    public static Appcontroler getInstens() {
        if (appcontroler == null) {
            appcontroler = new Appcontroler();
        }
        return appcontroler;
    }
    public QuastionData getQuastion(int index) {
        return quastionData.get(index);
    }
    public int getQuestion(){
        return quastionData.size();
    }
    private void setVariant() {
        quastionData.add(new QuastionData("MIAOVRIKLEUA", "MEVALAR", R.drawable.img_19,R.drawable.img_19,R.drawable.img_19,R.drawable.img_19));
        quastionData.add(new QuastionData("OHMAEYRVYNIO", "HAYVON", R.drawable.img_1,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4));
       quastionData.add(new QuastionData("OMKLEYUIMAYT", "OLMA", R.drawable.meva1,R.drawable.meva3,R.drawable.meva1,R.drawable.meva3));
    }
}
