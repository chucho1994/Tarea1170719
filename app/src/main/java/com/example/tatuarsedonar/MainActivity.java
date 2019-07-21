package com.example.tatuarsedonar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText nombre_edit, apellido_edit, edad_edit;
    RadioButton hombre_button, mujer_button;
    RadioGroup radio_gropu1;
    CheckBox cb1deportes, cb2educacion, cb3videojuegos, cb4arte, cb5libros, cb6belleza;
    ToggleButton tb1tatuarse, tb2donar;
    Switch sw1aceptarTerminos, sw2estadistica;

    int contador = 1;//Nos servira para movernos entre metodo registrar y borrar dependiendo las
    //condiciones se empiesa en uno por que si damos en borrar mientras llenamos campos  se borra y
    //no tiene que ser asi se llenan todos los campos se da en registrar y luego ya se puede  borrar



    @Override//se ejecuta cada ves que ingresemos un dato nuevo
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nombre_edit = (EditText) findViewById(R.id.nombre);
        apellido_edit = (EditText) findViewById(R.id.apellido);
        edad_edit = (EditText) findViewById(R.id.edad);

        hombre_button = (RadioButton) findViewById(R.id.hombre);
        mujer_button = (RadioButton) findViewById(R.id.mujer);
        radio_gropu1=(RadioGroup)findViewById(R.id.groupA) ;

        cb1deportes = (CheckBox) findViewById(R.id.deportes);
        cb2educacion = (CheckBox) findViewById(R.id.educacion);

        cb3videojuegos = (CheckBox) findViewById(R.id.video_juegos);
        cb4arte = (CheckBox) findViewById(R.id.arte);

        cb5libros = (CheckBox) findViewById(R.id.libros);
        cb6belleza = (CheckBox) findViewById(R.id.belleza);


        tb1tatuarse = (ToggleButton) findViewById(R.id.tatuajes);
        tb2donar = (ToggleButton) findViewById(R.id.donar);

        sw1aceptarTerminos = (Switch) findViewById(R.id.terminos);
        sw2estadistica = (Switch) findViewById(R.id.permitir);


    }


    public void resgistrar(View view) {

        String nombreG = " ", apellidoG = " ", edadG = " ";//cada vez que adopte un string nuevo
        //se borre el pasado

//

        nombreG = nombre_edit.getText().toString();//recuperando toda la cadena editText y parseando a string
        apellidoG = apellido_edit.getText().toString();
        edadG = edad_edit.getText().toString();



        contador = 0;//va a empesar a sumarse dependiendo a los metodos que se cumpalan y se ira sumando
        //pero cuando no entre a ni un metodo ocea que todos los campos se llenaron de nuestra app
        //se quedara en cero la variable y se ejecutara lo de la condicion que hay en borrar

            //    \/si lo que recibe nombreG es vacio entra
        if (nombreG.isEmpty()) {
            Toast.makeText(this, "Te falta rellenar el campo Nombre ", Toast.LENGTH_SHORT).show();
            contador++;
        }

        if (apellidoG.isEmpty()) {
            Toast.makeText(this, "Te falta rellenar el campo Apellido ", Toast.LENGTH_SHORT).show();
            contador++;
        }

        if (edadG.isEmpty()) {
            Toast.makeText(this, "Te falta rellenar el campo Edad ", Toast.LENGTH_SHORT).show();
            contador++;
        }
            // \/si lo que tiene hombre_button es false entra
        if ((!hombre_button.isChecked()) && (!mujer_button.isChecked())) {
            Toast.makeText(this, "Te falta marcar campo genero ", Toast.LENGTH_SHORT).show();
            contador++;
        }


        if ((!cb1deportes.isChecked()) && (!cb2educacion.isChecked()) && (!cb3videojuegos.isChecked()) && (!cb4arte.isChecked()) && (!cb5libros.isChecked()) && (!cb6belleza.isChecked())) {
            Toast.makeText(this, "Te falta marcar algun interes", Toast.LENGTH_SHORT).show();
            contador++;
        }


        if (!sw1aceptarTerminos.isChecked()) {
            Toast.makeText(this, "Te falta ACEPTAR terminos y condiciones ", Toast.LENGTH_SHORT).show();
            contador++;
        }

        if (!sw2estadistica.isChecked()) {
            Toast.makeText(this, "Te falta ACEPTAR fines estadisticos ", Toast.LENGTH_SHORT).show();
            contador++;
        }





    }
   // al mandar onclik al boton
    public void borrar(View borrar) {



            //si ya no entro en niuna condicion de registro la variable sera 0 y entra al if y
        //reinicia todo
        if (contador == 0) {
            //             \/metodo que nos permite poner campos de editText a esado inicial
            nombre_edit.setText("");
            edad_edit.setText("");
            apellido_edit.setText("");

             //           \/metodo que nos permite borrar los radioBotton dentro de radio group
            radio_gropu1.clearCheck();


             //                                         \/metodo que nos permite pasar a false un radioBotton
       //   if (hombre_button.isChecked())hombre_button.setChecked(false);

         //   if(mujer_button.isChecked())mujer_button.setChecked(false);




            cb1deportes.setChecked(false);
            cb2educacion.setChecked(false);
            cb3videojuegos.setChecked(false);
            cb4arte.setChecked(false);
            cb5libros.setChecked(false);
            cb6belleza.setChecked(false);
            tb1tatuarse.setChecked(false);
            tb2donar.setChecked(false);
            sw1aceptarTerminos.setChecked(false);


        }
        contador++;//para que cuando le demos en borrar no se borre sin aber pasado por registro de que todos los campos
        //Teerminado



    }


}
