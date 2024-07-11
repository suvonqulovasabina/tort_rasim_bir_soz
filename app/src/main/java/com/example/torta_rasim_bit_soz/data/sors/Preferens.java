package com.example.torta_rasim_bit_soz.data.sors;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.List;

public class Preferens {
    private static Preferens preferens;
    private static SharedPreferences preferences;
  private   Preferens(Context context){
        preferences=context.getSharedPreferences("book",Context.MODE_PRIVATE);
    }
    public void init(Context context){
      preferens=new Preferens(context);
    }
    public static Preferens getPreferens(){
    return preferens;
    }
    public void seveLastLevel(String letter){
      preferences.edit().putString("variant",letter).apply();
    }
    public String getLetter(){
    return preferences.getString("variant","");
    }
    public void Setmasiv(int a){

    }
}
