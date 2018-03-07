package local.com.agenda.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import local.com.agenda.constants.Constantes;

public class UtilsContacto {
    //Atributos
    private  SQLiteDatabase db=null;
    private DatabaseHelper dbhelper=null;
    //Contexto
    Context context;

    public UtilsContacto(Context contexto){

        this.context=contexto;
        //crea una instancia del helper
        dbhelper=new DatabaseHelper(context);
        //crea un objeto SQLiteDatabase para operar
        //contra la base de datos
        db=dbhelper.getWritableDatabase();
    }
    public void close(){
        dbhelper.close();
    }
    public long insertarContacto(Contacto c ){
        //Usamos un objeto tipo ContentValues para guardar todas las keys de cada campo en contacto
        //e insertarlo en la tablas
        ContentValues initialValues=new ContentValues();
        initialValues.put("nombre", c.getNombre());
        initialValues.put("email", c.getEmail());
        initialValues.put("edad", c.getEdad());

        return db.insert(Constantes.CONTACTOS_TABLA, null, initialValues);
    }
    public  Cursor recuperarContactos(){
        return db.query (Constantes.CONTACTOS_TABLA, new String[]{Constantes.CAMPO_ID,Constantes.CAMPO_NOMBRE,Constantes.CAMPO_EMAIL,Constantes.CAMPO_EDAD},null, null, null,null,null);

    }

    public Contacto buscarPorEmail(String email){
        Contacto con=null;
        Cursor c=db.query(Constantes.CONTACTOS_TABLA, new String[]{Constantes.CAMPO_ID,Constantes.CAMPO_NOMBRE,Constantes.CAMPO_EMAIL,Constantes.CAMPO_EDAD},Constantes.CAMPO_EMAIL + "=?", new String[]{email}, null,null,null);
        if(c.moveToNext()){
            con=new Contacto(c.getString(1),c.getString(2),c.getString(3));
        }
        return con;
    }

}

