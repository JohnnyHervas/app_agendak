package local.com.agenda;



import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import local.com.agenda.model.Contacto;
import local.com.agenda.model.UtilsContacto;
import local.com.agenda.utils.Utilidades;

import static java.lang.Integer.*;

public class AgregarActivity extends Activity {
    ArrayList<Contacto> miagenda;
    Utilidades u = new Utilidades();
    //Resources rs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_agregar);
        // Intent intent = this.getIntent();

        //  miagenda = (ArrayList<Contacto>) intent.getSerializableExtra("agenda");
    }

    public void guardar(View view) {

        String nombre = ((EditText) this.findViewById(R.id.editTextNombre)).getText().toString();
        String email = ((EditText) this.findViewById(R.id.editTextEmail)).getText().toString();
        String edad = ((EditText) this.findViewById(R.id.editTextEdad)).getText().toString();

        //Insertar un contacto en la BD

        if ((nombre.equals("")) || (email.equals("")) || (edad.equals(""))) {
            u.mostrarmensaje(this, (R.string.campos_vacios));
        } else {

            // Intent intent = this.getIntent();
            Contacto c = new Contacto(nombre, email, edad);
            UtilsContacto gestion = new UtilsContacto(this);
            gestion.insertarContacto(c);
            // this.setResult(AgregarActivity.RESULT_OK, intent);
            gestion.close();
            this.finish();
        }
    }
}



/*
        boolean auxnombre = false;
        boolean auxmail = false;
        boolean auxedad = false;if (nombre.equals("")) {
            auxnombre = true;
        } else if (email.equals("")) {
            auxmail = true;
        } else if (edad.equals("")) {
            auxedad = true;

        }
        if ((auxedad == true) || (auxmail == true) || (auxnombre == true)) {

            Toast.makeText(this, "Debe rellenar todos los campos", Toast.LENGTH_LONG).show();

        } else {

            miagenda.add(c);
            Intent intent = new Intent();
            intent.putExtra("miagenda", miagenda);
            Toast.makeText(this, "Contacto guardado", Toast.LENGTH_LONG).show();
            this.setResult(AgregarActivity.RESULT_OK, intent);
            this.finish();
        }

*//*

    }
*/
/*

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import local.com.agenda.model.Contacto;
import local.com.agenda.model.BDcontactos;

public class AgregarActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_agregar);
    }
    public void guardar(View v){
        //recogemos los datos introducidos
        String nombre=((EditText)this.findViewById(R.id.editTextNombre)).getText().toString();
        String email=((EditText)this.findViewById(R.id.editTextEmail)).getText().toString();
        String edad=((EditText) this.findViewById(R.id.editTextEdad)).getText().toString();
        //creamos objeto contacto
        Contacto c=new Contacto(nombre, email, edad);
        //creamos un DBContactos y añadimos
        //el nuevo contacto
        BDcontactos gestion=new BDcontactos(this);
        gestion.guardarContacto(c);
        //cerramos la base de datos
        gestion.close();
        //finalizamos la actividad
        this.finish();

    }

}

*/
