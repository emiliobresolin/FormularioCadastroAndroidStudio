package com.example.formulariocadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText name, age;
    private RadioButton masc, fem;
    private TextView resultName, resultAge, resultGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editName);
        age = findViewById(R.id.editAge);
        masc = findViewById(R.id.radioButtonMasc);
        fem = findViewById(R.id.radioButtonFem);
        resultName = findViewById(R.id.resultName);
        resultAge = findViewById(R.id.resultAge);
        resultGender = findViewById(R.id.resultGender);
        Button btCadastrar = findViewById(R.id.bt_Cadastrar);
        btCadastrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String editName = name.getText().toString();
                String editAge = age.getText().toString();
                if (editName.isEmpty() || editAge.isEmpty())
                {
                    Snackbar.make(v, "preencha o nome e a idade", Snackbar.LENGTH_SHORT).show();
                }
                else{
                    RadioButtonSelect(v);
                }
            }
        });
    }
    private  void RadioButtonSelect(View view){
        String editName = name.getText().toString();
        String editAge = age.getText().toString();
        if(fem.isChecked()){
            resultName.setText(editName);
            resultAge.setText(editAge);
            resultGender.setText("Sexo: Feminino");
        }
        else if(masc.isChecked()){
            resultName.setText(editName);
            resultAge.setText(editAge);
            resultGender.setText("Sexo: Masculino");
        }
        else{
            Snackbar.make(view, "Selecione o Sexo", Snackbar.LENGTH_SHORT).show();
        }
    }
}