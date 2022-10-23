package com.mobile.agendatelefonica;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DB {
    //criando o database
    static SQLiteDatabase db=null;
    static Cursor cursor;


    public static void abrirBanco(Activity act){
        try{
            ContextWrapper cw= new ContextWrapper(act);
            db=cw.openOrCreateDatabase("bancoAgenda",MODE_PRIVATE, null);
        }catch (Exception ex){
            Msg.mostrar("Erro ao abrir bd",act);
        }
    }
    public static void fecharDB(){
        db.close();
    }

    public static void abrirOuCriarTabela(Activity act){
        //caso a tabela não exista, vai criar
        try{
            db.execSQL("CREATE TABLE if not exists contatos (id integer PRIMARY KEY, nome TEXT, fone TEXT)");
        }
        //caso apresente erro
        catch (Exception ex){
            Msg.mostrar("Erro na criação da tabela!", act);
        }
    }
    public static void inserirRegistro(String nome, String fone, Activity act){
        abrirBanco(act);
        //não estando vazio irá continuar inserindo os dados no BD conforme os campos abaixo
        try{
            db.execSQL("INSERT INTO contatos (nome,fone) VALUES ('"+nome+"', '"+fone+"')");

        }catch (Exception ex){
            Msg.mostrar("Erro ao inserir registro!",act);
        }
        finally {
            Msg.mostrar("Registro realizado com sucesso",act);
        }
        fecharDB();
    }
    public static Cursor buscarDados(Activity act) {
        abrirBanco(act);
        //cursor que permite a navegação
        cursor = db.query("contatos",
                new String[]{"nome", "fone"},
                null,
                null,
                null,
                null,
                null,
                null
        );
        cursor.moveToFirst();
        return cursor;
    }
}
