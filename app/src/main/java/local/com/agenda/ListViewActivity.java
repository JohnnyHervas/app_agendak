package local.com.agenda;
/*


import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import local.com.agenda.model.Contacto;

public class ListViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final ArrayList<Contacto> miagenda;
        ListView ListViewListado;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_listview);
        Intent intent = this.getIntent();
        miagenda = (ArrayList<Contacto>) intent.getSerializableExtra("agenda");
        ListViewListado = this.findViewById(R.id.listViewListado);
        ArrayAdapter<Contacto> arContacto=new ArrayAdapter<Contacto>(this, android.R.layout.simple_list_item_1, miagenda);
        ListViewListado.setAdapter(arContacto);
        ListViewListado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contacto c = miagenda.get(position);
                String textomensaje = "Nombre: " + c.getNombre() + "\nE-Mail: " + c.getEmail() + "\nEdad: " + c.getEdad();
                Toast.makeText(ListViewActivity.this, textomensaje, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void salir(View view) {
        this.finish();
    }
}
*/


import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


import local.com.agenda.model.UtilsContacto;

public class ListViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final ListView lstContactos;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_listview);
        //creamos UtilsContacto y recupera la agenda
        UtilsContacto gestion = new UtilsContacto(this);
        Cursor cur = gestion.recuperarContactos();
        //recupera ListView
        lstContactos = (ListView) this.findViewById(R.id.listViewListado);
        String[] columns = new String[]{"nombre", "email", "edad"};
        //crea adaptador y lo asigna a la lista
        final SimpleCursorAdapter sc = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                cur,
                columns,
                new int[]{android.R.id.text1},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lstContactos.setAdapter(sc);
        gestion.close();
        //lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener(){
        //@Override
        //public void onItemClick (AdapterView < ? > parent, View view,int position, long id){


   // }
 //   });
}}


              /*   Contacto c = miagenda.get(position);
                String textomensaje = "Nombre: " + c.getNombre() + "\nE-Mail: " + c.getEmail() + "\nEdad: " + c.getEdad();
                 Toast.makeText(ListViewActivity.this, textomensaje, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void salir(View v){
        this.finish();
    }
*/