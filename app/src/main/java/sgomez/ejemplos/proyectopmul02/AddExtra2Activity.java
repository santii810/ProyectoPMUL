package sgomez.ejemplos.proyectopmul02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import sgomez.ejemplos.proyectopmul02.model.PagoAsoc;

public class AddExtra2Activity extends AppCompatActivity {
    private final int RESULT_FINALIZAR = 1;
    EditText cobrado;
    EditText propina;
    EditText duracion;
    EditText notas;
    Spinner pagoAsociado;

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
        ArrayList<PagoAsoc> pagos = new ArrayList<>();
        pagos.add(new PagoAsoc("Extra", 5.0));
        pagos.add(new PagoAsoc("Media", 2.5));
        pagos.add(new PagoAsoc("Nada", 0.0));

        ArrayAdapter<String> adapterPago = new ArrayAdapter(this, android.R.layout.simple_spinner_item, pagos);
        pagoAsociado.setAdapter(adapterPago);
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
            backData.putExtra("pagoAsociado", ((PagoAsoc) pagoAsociado.getSelectedItem()).getCantidad());
        } catch (Exception e) {
        }
        try {
            backData.putExtra("cobrado", Integer.parseInt(cobrado.getText().toString()));
        } catch (Exception e) {
        }
        try {
            backData.putExtra("duracion", Double.parseDouble(duracion.getText().toString()));
        } catch (Exception e) {
        }
        try {
            backData.putExtra("propina", Double.parseDouble(propina.getText().toString()));
        } catch (Exception e) {
        }
        backData.putExtra("notas", notas.getText().toString());
        setResult(result, backData);
        finish();
    }
}
