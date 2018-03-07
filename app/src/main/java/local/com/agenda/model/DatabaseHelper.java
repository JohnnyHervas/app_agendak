package local.com.agenda.model;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import local.com.agenda.constants.Constantes;

public class DatabaseHelper extends SQLiteOpenHelper {
    //Constantes para crear y eliminar la tabla
    private static final String CREATE_TABLE_CONTACTO = "CREATE TABLE " + Constantes.CONTACTOS_TABLA +
            " (" + Constantes.CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Constantes.CAMPO_NOMBRE +
            " TEXT NOT NULL, " + Constantes.CAMPO_EMAIL + " TEXT NOT NULL, " + Constantes.CAMPO_EDAD +
            " INTEGER NOT NULL)";
    private static final String DELETE_TABLE_CONTACTO = "DROP TABLE IF EXISTS " + Constantes.CONTACTOS_TABLA;


    public DatabaseHelper(Context context) {
        super(context, Constantes.DATABASE_NAME, null, Constantes.DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //llamamos al metodo create para crear la tabla
        createTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        deleteTable(db);
        createTable(db);


    }

    //Usamos un metodo para crear nuestra tabla
    private void createTable(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CONTACTO);
    }

    //Usamos un método para eliminar nuestra tabla
    private void deleteTable(SQLiteDatabase db) {
        db.execSQL(DELETE_TABLE_CONTACTO);
    }
}
/*

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="Contactos";
    private static final int DATABASE_VERSION=1;

    //sql de creación de tabla
    private static final String DATABASE_CREATE_CONTACTOS=
            "create table contactos (_id integer primary key autoincrement, "+
                    "nombre text not null, email text not null, edad integer not null)";
    //sql eliminación de tabla
    private static final String DATABASE_DELETE_CONTACTOS=
            "drop table if exists contactos";
    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    //Se llama al crear la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        createTables(db);

    }
    //este método es llamado si a la hora de crear el DataBaseHelper
    //se pasa una versión superior a la ya existente
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //reconstruimos la tabla
        deleteTables(db);
        createTables(db);

    }

    private void createTables(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_CONTACTOS);

    }

    private void deleteTables(SQLiteDatabase db) {
        db.execSQL(DATABASE_DELETE_CONTACTOS);

    }
}
*/
