package local.com.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import local.com.agenda.model.Contacto;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> agenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agenda = new ArrayList<Contacto>();
    }

    public void agregar(View view) {
        Intent intent = new Intent(this, AgregarActivity.class);
        intent.putExtra("agenda", agenda);
        this.startActivityForResult(intent, 1);
    }

    public void buscar(View view) {
        Intent intent = new Intent(this, BuscarActivity.class);
        intent.putExtra("agenda", agenda);
        this.startActivity(intent);
    }

    public void listado(View view) {
        Intent intent = new Intent(this, ListViewActivity.class);
        intent.putExtra("agenda", agenda);
        this.startActivity(intent);
    }
/*

    @Override
    public void onActivityResult(int cod, int result, Intent data) {
        super.onActivityResult(cod, result, data);

        switch (result) {
            case RESULT_OK:
                agenda = (ArrayList<Contacto>) data.getSerializableExtra("miagenda");
                break;
            case RESULT_CANCELED:
                return;

        }
*//*


    }
*/
    public void insertar(View view){
        Intent intent = new Intent(this, AgregarActivity.class);
        this.startActivity(intent);
    }
}
