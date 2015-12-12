package sgomez.ejemplos.proyectopmul02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddExtra2Activity extends AppCompatActivity {
    EditText cobrado;
    EditText propina;
    EditText duracion;
    EditText notas;
    Spinner pagoAsociado;
    private final int RESULT_FINALIZAR = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_extra2);

        cobrado = (EditText) findViewById(R.id.editTextAddExtraCobrado);
        duracion = (EditText) findViewById(R.id.editTextAddExtraDuracion);
        propina = (EditText) findViewById(R.id.editTextAddExtraPropina);
        notas = (EditText) findViewById(R.id.editTextAddExtraNotas);
        pagoAsociado = (Spinner) findViewById(R.id.spinnerAddExtraPagoAsociado);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // rellenar spinner pago asociado


    }

    public void buttonAddExtra2FinalizarOnClick(View view) {
        backData(RESULT_FINALIZAR);
    }

    public void buttonAddExtra2NextOnClick(View view) {
        backData(RESULT_OK);
    }

    private void backData(int result) {
        Intent backData = new Intent();
        try {
            backData.putExtra("cobrado", Integer.parseInt(cobrado.getText().toString()));
            backData.putExtra("duracion", Double.parseDouble(duracion.getText().toString()));
            backData.putExtra("propina", Double.parseDouble(propina.getText().toString()));
            backData.putExtra("notas", notas.getText().toString());
            setResult(result, backData);
            finish();
        } catch (Exception e) {
            Toast.makeText(this, "Los datos introducidos son incorrectos", Toast.LENGTH_LONG).show();
        }
    }


}
