package com.androiddesdecero.realmandroid.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androiddesdecero.realmandroid.R;
import com.androiddesdecero.realmandroid.crud.CRUDProfesor;
import com.androiddesdecero.realmandroid.model.Profesor;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private EditText nombreEt, emailEt;
    private Button saveBt, leerTodoBt, leerByName, leerById, actualizarById, borrarPorId, borrarTodo, goToCurso;
    private Profesor profesor;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        realm = Realm.getDefaultInstance();
        configView();
    }

    private void configView(){
        profesor = new Profesor();
        nombreEt = findViewById(R.id.mainActivityEtNombre);
        emailEt = findViewById(R.id.mainActivityEtEmail);
        saveBt = findViewById(R.id.mainActivityBtSave);
        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profesor.setName(nombreEt.getText().toString());
                profesor.setEmail(emailEt.getText().toString());
                CRUDProfesor.addProfesor(profesor);
            }
        });
        leerTodoBt = findViewById(R.id.mainActivityBtReadAll);
        leerTodoBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CRUDProfesor.getAllProfesor();
            }
        });
        leerByName = findViewById(R.id.mainActivityBtReadByName);
        leerByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CRUDProfesor.getProfesorByName(nombreEt.getText().toString());
            }
        });
        leerById = findViewById(R.id.mainActivityBtReadById);
        leerById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CRUDProfesor.getProfesorById(Integer.parseInt(nombreEt.getText().toString()));
            }
        });
        actualizarById = findViewById(R.id.mainActivityBtUpdateById);
        actualizarById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CRUDProfesor.updateProfesorById(1);
            }
        });

        borrarPorId = findViewById(R.id.mainActivityBtDeleteById);
        borrarPorId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CRUDProfesor.deleteProfesorById(1);
            }
        });



        borrarTodo = findViewById(R.id.mainActivityBtDeleteAll);
        borrarTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CRUDProfesor.deleteAllProfesor();
            }
        });
        goToCurso = findViewById(R.id.mainActivityBtCursoActivity);
        goToCurso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), CursoActivity.class));
            }
        });
    }
}
