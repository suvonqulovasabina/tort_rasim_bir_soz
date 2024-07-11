package com.example.torta_rasim_bit_soz.prezonter.Scrin;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.DialogFragment;
import com.example.torta_rasim_bit_soz.R;

public class MyDialog extends DialogFragment {
    private SelectEventListener listener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_title3,container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AppCompatButton button=view.findViewById(R.id.dialogButton);

        button.setOnClickListener(v -> {
           listener.clickFinish();
            dismiss();
        });

    }
    @Override
    public void onStart() {
        super.onStart();
        this.getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }
    public void setEventListener(SelectEventListener listener) {
        this.listener = listener;
    }
}
