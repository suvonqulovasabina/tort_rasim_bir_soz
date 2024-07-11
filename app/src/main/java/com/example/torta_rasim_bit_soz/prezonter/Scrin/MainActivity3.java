package com.example.torta_rasim_bit_soz.prezonter.Scrin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;

import com.example.torta_rasim_bit_soz.R;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_title3);
        AppCompatButton button=findViewById(R.id.dialogButton);
        button.setOnClickListener(v -> {
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        });
    }
}