package com.mobile.agendatelefonica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //criando as variaveis 2 editText e 3 botões
    EditText et_nome,et_telefone;
    Button btn_gravar,btn_consultar,btn_fechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //relação com telas pelo id criado na activity
        et_nome = findViewById(R.id.et_nome);
        et_telefone = findViewById(R.id.et_telefone);
        btn_gravar = (Button) findViewById(R.id.btn_gravar);
        btn_consultar = (Button) findViewById(R.id.btn_consultar);
        btn_fechar = (Button) findViewById(R.id.btn_fechar);
    }
    //função do botão consultar da abertura do activity main, usando como parametro uma View
    public void abrir_tela_consulta(View v){

        //para criar a tela
        Intent it_tela_consulta=new Intent(this, TelaConsulta.class);

        //inicia uma activity
        startActivity(it_tela_consulta);


    }


}