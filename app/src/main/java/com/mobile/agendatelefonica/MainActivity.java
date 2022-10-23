package com.mobile.agendatelefonica;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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

        DB.abrirBanco(this); //inicio do programa
        DB.abrirOuCriarTabela(this); //chama o abrir ou criar tabela
        DB.fecharDB();
    }
    //inserção dos dados
    public void inserirRegistro(View v){
        String st_nome, st_fone;
        st_nome = et_nome.getText().toString();
        st_fone = et_telefone.getText().toString();

        //validação de campo vazio
        if(st_nome == "" || st_fone == "" ){
            Msg.mostrar ("Os campos devem ser preenchidos!",this);
            return;

    }
        DB.inserirRegistro(st_nome,st_fone,this);
       //após fechar limpar os campos
        et_nome.setText(null);
        et_telefone.setText(null);
    }

    //função do botão consultar da abertura do activity main, usando como parametro uma View
    public void abrir_tela_consulta(View v){

        //para criar a tela
        Intent it_tela_consulta=new Intent(this, TelaConsulta.class);

        //inicia uma activity que faz relação com o onClick da actvity_main
        startActivity(it_tela_consulta);
    }

    //função do botão fechar da activity_main, usando como parametro uma View
    public void fechar_tela(View v){
        this.finish();
    }
}