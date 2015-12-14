package sgomez.ejemplos.proyectopmul02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.sql.Date;

import sgomez.ejemplos.proyectopmul02.model.Camarero;
import sgomez.ejemplos.proyectopmul02.model.Cocina;
import sgomez.ejemplos.proyectopmul02.model.Extra;
import sgomez.ejemplos.proyectopmul02.model.Local;

public class AddDataActivity extends AppCompatActivity {
    public final static int ADDEXTRA1_REQUEST_CODE = 1;
    public final static int ADDEXTRA2_REQUEST_CODE = 2;
    public final static int ADDEXTRA3_REQUEST_CODE = 3;

    public final static int ADDLOCAL_REQUEST_CODE = 5;
    public final static int ADDCAMARERO_REQUEST_CODE = 6;
    public final static int ADDCOCINA_REQUEST_CODE = 7;

    public final static int RESULT_FINISH = 1;

    private Extra extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        extra = new Extra();
    }


    public void buttonAddExtraOnClick(View view) {
        Intent intent = new Intent(this, AddExtra1Activity.class);
        startActivityForResult(intent, ADDEXTRA1_REQUEST_CODE);
    }

    public void butttonAddLocalOnClick(View view) {
        Intent intent = new Intent(this, AddLocalActivity.class);
        startActivityForResult(intent, ADDLOCAL_REQUEST_CODE);
    }


    public void buttonAddCamareroOnClick(View view) {
        Intent intent = new Intent(this, AddCamareroActivity.class);
        startActivityForResult(intent, ADDCAMARERO_REQUEST_CODE);
    }


    public void buttonAddCocinaOnClick(View view) {
        Intent intent = new Intent(this, AddCocinaActivity.class);
        startActivityForResult(intent, ADDCOCINA_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case ADDEXTRA1_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                   extra.setLocal(MainActivity.getLocalRepository().getLocal(data.getStringExtra("idLocal")));
                    extra.setFechaExtra(new Date(data.getIntExtra("año", 0), data.getIntExtra("mes", 0), data.getIntExtra("dia", 0)));
                    Log.e("DATOS_EXTRA", extra.getFechaExtra().toString() + " _ " + extra.getLocal().getNombre());

                    Intent intent = new Intent(this, AddExtra2Activity.class);
                    startActivityForResult(intent, ADDEXTRA2_REQUEST_CODE);
                }
                break;
            case ADDEXTRA2_REQUEST_CODE:
                if (resultCode == RESULT_OK || resultCode == RESULT_FINISH) {
                    extra.setCobrado(data.getIntExtra("cobrado", 0));
                    extra.setDuracion(data.getDoubleExtra("duracon", 0));
                    extra.setPropina(data.getDoubleExtra("propina", 0));
                    extra.setNotas(data.getStringExtra("notas"));
                    extra.setPagoAsociado(data.getDoubleExtra("pagoAsociado",0));
                    if (resultCode == RESULT_OK) {
                        Intent intent = new Intent(this, AddExtra3Activity.class);
                        startActivityForResult(intent, ADDEXTRA3_REQUEST_CODE);
                    } else if (resultCode == RESULT_FINISH) {
                        MainActivity.getExtraRepository().addExtra(extra);
                    }
                }
                break;
            case ADDEXTRA3_REQUEST_CODE:
                if (resultCode == RESULT_OK || resultCode == RESULT_FINISH) {
                    extra.setCocina(data.getStringExtra("cocina"));
                    extra.setFestividad(data.getStringExtra("festividad"));
                    extra.setMomentoDia(data.getStringExtra("momentoDia"));
                    if (resultCode == RESULT_OK) {
                        String id = MainActivity.getExtraRepository().addExtraCamarero(extra);
                        Intent intent = new Intent(this, AddExtra4Activity.class);
                        intent.putExtra("id", id);
                        startActivity(intent);
                    } else if (resultCode == RESULT_FINISH) {
                        MainActivity.getExtraRepository().addExtra(extra);
                    }
                }
                break;

            case ADDLOCAL_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    String nombreLocal = data.getStringExtra("nombreLocal");
                    String direccionLocal = data.getStringExtra("direccionLocal");
                    MainActivity.getLocalRepository().addLocal(new Local(nombreLocal, direccionLocal));
                }
                break;
            case ADDCAMARERO_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    String nombreCamarero = data.getStringExtra("nombreCamarero");
                    boolean activo = data.getBooleanExtra("activo", true);
                    MainActivity.getCamareroRepository().addCamarero(new Camarero(nombreCamarero, activo));
                    Toast.makeText(this, "Camarero añadido correctamente", Toast.LENGTH_SHORT);
                }
                break;
            case ADDCOCINA_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    String nombreCocina = data.getStringExtra("nombreCocina");
                    boolean activo = data.getBooleanExtra("activa", true);
                    MainActivity.getCocinaRepository().addCocina(new Cocina(nombreCocina, activo));
                    Toast.makeText(this, "Cocina añadida correctamente", Toast.LENGTH_SHORT);

                }
                break;
        }
    }

}
