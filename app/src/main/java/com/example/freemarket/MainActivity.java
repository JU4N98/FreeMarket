package com.example.freemarket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

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
        EditText editTextEmail = findViewById(R.id.editTextTextEmailAddress);
        EditText editTextTitulo = findViewById(R.id.tituloEditText);
        EditText editTextPrecio = findViewById(R.id.editTextPrecio);

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


        buttonPublicar.setOnClickListener(e->{
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(this, validarCampos(editTextDireccionRetiro, editTextTitulo, editTextPrecio, checkBoxRetiro,
            switchDescuento, seekBarDescuento, editTextEmail), duration);
            toast.show();
        });


    }


    private CharSequence validarCampos(EditText retiro, EditText titulo, EditText precio, CheckBox retiroCheck,
                                        Switch switchDescuento, SeekBar seekDescuento, EditText email){
        // Regex
        Pattern patternEmail = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
        Pattern patternCampos = Pattern.compile("^[a-zA-Z0-9.,\n ]*$");


        // Campos obligatorios
        if(titulo.getText().length() ==0 || precio.getText().length() == 0 || (retiroCheck.isChecked() && retiro.getText().length() == 0))
            return "ERROR: Debe completar los campos marcados con *";

        // Descuento mayor a 0
        if(switchDescuento.isChecked() && seekDescuento.getProgress()<=0)
            return "ERROR: No puede ofrecer un descuento de 0%, suba el descuento o desmarque la opcion";

        // Precio mayor a 0
        if(Float.parseFloat(String.valueOf(precio.getText())) <= 0)
            return "ERROR: El precio debe ser mayor a cero";

        // Email con Regex
        if(!patternEmail.matcher(email.getText()).matches())
            return "ERROR: El email ingresado no es valido";

        // Campos Regex
        if(!patternCampos.matcher(titulo.getText()).matches() || !patternCampos.matcher(precio.getText()).matches()
            || (retiroCheck.isChecked() && !patternCampos.matcher(retiro.getText()).matches()))
            return "ERROR: Uno o mas campos invalidos. Verifique que solo contengan letras, numeros, puntos, comas o saltos de linea";




        return "Éxito";
    }
}