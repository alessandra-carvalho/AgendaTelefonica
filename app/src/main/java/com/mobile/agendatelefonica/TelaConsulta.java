package com.mobile.agendatelefonica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class TelaConsulta extends AppCompatActivity {

    //criando as variaveis 2 editText e 3 botões
    EditText et_nome,et_telefone;
    Button btn_anterior,btn_proximo,btn_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_consulta);

        //relação c/ os botões da activity_tela_consulta
        et_nome = (EditText) findViewById(R.id.et_nome_consulta);
        et_telefone = (EditText) findViewById(R.id.et_telefone);
        btn_anterior = (Button) findViewById(R.id.btn_anterior);
        btn_proximo = (Button) findViewById(R.id.btn_proximo);
        btn_voltar = (Button) findViewById(R.id.btn_voltar_consulta);
    }
}