package local.com.agenda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import local.com.agenda.model.Contacto;

public class ListadoActivity extends Activity {
    ArrayList<Contacto> miagenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_listado);
        Intent intent = this.getIntent();
        //Recuperamos la agenda
        miagenda = (ArrayList<Contacto>) intent.getSerializableExtra("agenda");
        String datos = "";
        TextView textViewListado = (TextView) this.findViewById(R.id.textViewListado);
        //Recorremos la agenda formando una cadena con cada uno de los contactos para mostrarlos
        // por pantalla.
        for (Contacto c : miagenda) {
            datos += "Nombre: " + c.getNombre() + "\nE-Mail: " + c.getEmail() + "\nEdad: " + c.getEdad() + "\n\n";
            //Mostramos los datos en el TextView
            textViewListado.setText(datos);
        }
    }

    public void salir(View view) {
        this.finish();
    }
}

