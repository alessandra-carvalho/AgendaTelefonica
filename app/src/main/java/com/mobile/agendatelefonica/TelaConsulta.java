package com.mobile.agendatelefonica;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaConsulta extends AppCompatActivity {

    //criando as variaveis 2 editText e 3 botões
    EditText et_nome,et_telefone;
    Button btn_anterior,btn_proximo,btn_voltar;

    SQLiteDatabase db = null;
    Cursor cursor;

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

        //associação do cursor na classe DB
        cursor = DB.buscarDados(this);
        //verificando se tem registros
        if (cursor.getCount() != 0) {
           // cursor.moveToFirst();
            mostrarDados();
        } else {
            Msg.mostrar("Nenhum registro localizado!",this);
        }
    }
    private void buscarDados() {
    }

    //função do botão voltar da activity_tela_consulta, usando como parametro uma View
    public void fechar_tela(View v){
        this.finish();
    }

    //fecha o DB
    public void fecharDB(){
        db.close();
    }
    //para navegar p/ prox tela
    public void proximoRegistro(View v){
            try{
                cursor.moveToNext();
                mostrarDados();
            }catch (Exception ex){
                if(cursor.isAfterLast()){
                    Msg.mostrar("Não existem mais registros!", this);
                }else{
                    Msg.mostrar("Erro de navegação!", this);
                }
            }
    }
    //para tela anterior/voltar
    public void registroAnterior(View v){
        try{
            cursor.moveToPrevious();
            mostrarDados();
        }catch (Exception ex){
            if(cursor.isBeforeFirst()){
                Msg.mostrar("Não existem mais registros!", this);
            }else{
                Msg.mostrar("Erro de navegação!",this);
            }
        }
    }
    //função que mostra os dados na tela
    @SuppressLint("Range")
    public void mostrarDados(){
        et_nome.setText(cursor.getString(cursor.getColumnIndex("nome")));
        et_telefone.setText(cursor.getString(cursor.getColumnIndex("fone")));
    }
        //outra tentativa de mostrar os dados cadastrados na tela que não estão funcionando
//    public void mostrarDados(){
//        et_nome.setText(cursor.getString(1));
//        et_telefone.setText(cursor.getString(2));
//    }
}