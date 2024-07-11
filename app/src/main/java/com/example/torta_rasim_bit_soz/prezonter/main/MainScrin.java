package com.example.torta_rasim_bit_soz.prezonter.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.torta_rasim_bit_soz.R;
import com.example.torta_rasim_bit_soz.prezonter.Scrin.MainActivity;

public class MainScrin extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bir_soz_1);
        findViewById(R.id.buton).setOnClickListener(v -> {
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        });
    }
}