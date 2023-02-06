package com.example.sqlitedemostracao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {


    //variavel com nome DB
    private  static final String DB_NAME = "testeDB";
//nome da tabela
    private static final String TABLE_NAME = "Alunos";
    //Coluna
    private static final String ID = "id";
    private static final String NOME="nome";
    private static final String CURSO="curso";

    //Versao da base de dados, versao nao costante. 54 aconselhado a investigar!
    private static final int DB_VERSION = 1;


    private static final String CREATE_DB = "CREATE TABLE " + TABLE_NAME +"("+ ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NOME + " TEXT NOT NULL, "+ CURSO + " TEXT);";



    public DBHandler(@Nullable Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);

        onCreate(db);

    }

    public  void gravarAluno(String nome, String curso){

        SQLiteDatabase db= this.getWritableDatabase();

        ContentValues valores = new ContentValues();
         valores.put(NOME, nome);
         valores.put(CURSO, curso);

         db.insert(TABLE_NAME, null,valores);
         //fechar a conexao
         db.close();


    }
}
