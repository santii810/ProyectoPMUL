package sgomez.ejemplos.proyectopmul02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import sgomez.ejemplos.proyectopmul02.model.Local;

public class ViewLocalDataActivity extends AppCompatActivity {
    EditText nombreLocal;
    EditText direccionLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_local_data);
        nombreLocal = (EditText) findViewById(R.id.editTextDetallesNombreLocal);
        direccionLocal = (EditText) findViewById(R.id.editTextDetallesDireccionLocal);

        Local local = MainActivity.getLocalRepository().getLocal(getIntent().getStringExtra("id"));
        nombreLocal.setText(local.getNombre());
        direccionLocal.setText(MainActivity.getLocalRepository().getLocal(getIntent().getStringExtra("id")).getDireccion());
    }
}
