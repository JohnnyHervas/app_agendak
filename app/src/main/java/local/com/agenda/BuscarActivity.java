package local.com.agenda;

/*
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import local.com.agenda.model.Contacto;

public class BuscarActivity extends Activity {

    ArrayList<Contacto> miagenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_buscar);
        Intent intent = this.getIntent();

        miagenda = (ArrayList<Contacto>) intent.getSerializableExtra("agenda");
    }

    public void buscar(View view) {
        String email = ((EditText) this.findViewById(R.id.editTextBuscar)).getText().toString();
        //creamos un objeto contacto para guardar el contacto recuperado
        Contacto c = null; //inicializamos el contacto en null
        //Buscamos coincidencias de email con los datos guardados en miagenda
        for (Contacto con : miagenda) {
            //Si encuentra coincidencia, pasamos al obeto c el valor de con
            if (con.getEmail().equals(email)) {
                c = con;
                break;
            }
        }
        mostrardato(c);
    }

    public void salir(View view) {
        this.finish();

    }

    private void mostrardato(Contacto c) {
        //evaluamos el valor de c para ver si es nulo o si ha encontrado coincidencia
        if (c == null) {
            AlertDialog.Builder cuadro = new AlertDialog.Builder(this);
            cuadro.setMessage("No se ha encontrado el contacto. ¿Desea realizar otra búsqueda?");
            //Si la respuesta es No, salimos de la aplicación
            cuadro.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    //Abandonamos la activity
                    BuscarActivity.this.finish();
                }
            });
            //no se define escuchador para el botón de afirmación

            cuadro.setPositiveButton(android.R.string.yes, null);
            cuadro.show();

        } else {
            String datos = "Nombre: " + c.getNombre() + "\nE-Mail: " + c.getEmail() + "\nEdad: " + c.getEdad();
            Toast.makeText(this, datos, Toast.LENGTH_LONG).show();
        }
    }
}
*/

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import local.com.agenda.model.Contacto;
import local.com.agenda.model.UtilsContacto;

public class BuscarActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_buscar);
    }
    public void buscar(View v){
        String email=((EditText)this.findViewById(R.id.editTextBuscar)).getText().toString();
        //guardamos aquí el contacto recuperado
        Contacto c=null;
        //creamos GestionContacto y buscamos
        UtilsContacto gestion=new UtilsContacto(this);
        c=gestion.buscarPorEmail(email);
        mostrarDato(c);
        //cerramos la base de datos
        gestion.close();
    }
    public void salir(View v){

        this.finish();
    }

    private void mostrarDato(Contacto c){
        if(c==null){
            AlertDialog.Builder cuadro=new AlertDialog.Builder(this);
            cuadro.setMessage("No se ha encontrado el contacto, ¿Desea realizar otra búsqueda?");
            //en caso de que diga que no, salimos de la actividad
            cuadro.setNegativeButton(android.R.string.no,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Abandona la actividad
                            BuscarActivity.this.finish();
                        }
                    });
            //no se define ningún escuchador para el botón de afirmación
            cuadro.setPositiveButton(android.R.string.yes,null);
            cuadro.show();

        }
        else{
            String datos="Nombre: "+c.getNombre()+"\n Email:"+c.getEmail()+"\n Edad:"+c.getEdad();
            Toast.makeText(this,datos,Toast.LENGTH_LONG).show();

        }
    }

}
