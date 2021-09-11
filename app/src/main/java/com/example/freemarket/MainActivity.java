package com.example.freemarket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox checkBoxRetiro = findViewById(R.id.checkBoxRetiro);
        Switch switchDescuento = findViewById(R.id.switchDescuento);
        SeekBar seekBarDescuento = findViewById(R.id.seekBarDescuento);
        TextView textViewDireccionRetiro = findViewById(R.id.textViewDireccion);
        EditText editTextDireccionRetiro = findViewById((R.id.editTextDireccion));
        CheckBox checkBoxTyC = findViewById(R.id.checkBoxTyC);
        Button buttonPublicar = findViewById(R.id.buttonPublicar);

        editTextDireccionRetiro.setVisibility(View.GONE);
        textViewDireccionRetiro.setVisibility(View.GONE);
        checkBoxRetiro.setOnClickListener(e->{
            if(checkBoxRetiro.isChecked()){
                editTextDireccionRetiro.setVisibility(View.VISIBLE);
                textViewDireccionRetiro.setVisibility(View.VISIBLE);
            }else{
                editTextDireccionRetiro.setVisibility(View.GONE);
                textViewDireccionRetiro.setVisibility(View.GONE);
            }
        });

        seekBarDescuento.setVisibility(View.GONE);
        switchDescuento.setOnClickListener(e->{
            if(switchDescuento.isChecked()) seekBarDescuento.setVisibility(View.VISIBLE);
            else seekBarDescuento.setVisibility(View.GONE);
        });

        buttonPublicar.setEnabled(false);
        checkBoxTyC.setOnClickListener(e->{
            if(checkBoxTyC.isChecked()) buttonPublicar.setEnabled(true);
            else buttonPublicar.setEnabled(false);
        });


    }
}