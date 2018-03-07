package local.com.agenda.utils;


import android.content.Context;
import android.widget.Toast;

public class Utilidades {

    // Mostrar un menaje para el usuario.
    // context representa el contexto donde se mostrará el mensaje.
    // mensaje es el mensaje al usuario.
    public void mostrarmensaje(Context context, int mensaje){
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();

    }
}
