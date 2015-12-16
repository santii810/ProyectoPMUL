package sgomez.ejemplos.proyectopmul02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;

import sgomez.ejemplos.proyectopmul02.model.Cocina;

public class AddExtra3Activity extends AppCompatActivity {
    private final int RESULT_FINALIZAR = 1;
    Spinner spinnerCocina;
    Spinner spinnerFestividad;
    RadioButton radioButtonNoche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_extra3);
        spinnerCocina = (Spinner) findViewById(R.id.spinnerCocina);
        spinnerCocina = (Spinner) findViewById(R.id.spinnerFestividad);
        spinnerFestividad = (Spinner) findViewById(R.id.spinnerFestividad);
        radioButtonNoche = (RadioButton) findViewById(R.id.radioButtonNoche);
    }


    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<Cocina> cocinas = MainActivity.getCocinaRepository().getCocinas();
        ArrayAdapter<String> adapterCocina = new ArrayAdapter(this, android.R.layout.simple_spinner_item, cocinas);
        spinnerCocina.setAdapter(adapterCocina);

        //Festividades
        ArrayList<String> festividades = new ArrayList<>();
        festividades.add("Boda");
        festividades.add("Comunion");
        festividades.add("Carta");
        festividades.add("Bautizo");
        festividades.add("Boda de plata");
        festividades.add("Boda de oro");
        festividades.add("Fiesta");

        ArrayAdapter<String> adapterFestividades = new ArrayAdapter(this, android.R.layout.simple_spinner_item, festividades);
        spinnerFestividad.setAdapter(adapterFestividades);

    }

    public void buttonAddExtra3FinalizarOnClick(View view) {
        backData(RESULT_FINALIZAR);
    }

    public void buttonAddExtra3NextOnClick(View view) {
        backData(RESULT_OK);
    }


    private void backData(int result) {
        Intent backData = new Intent();
        try {
            backData.putExtra("cocina", ((Cocina) spinnerCocina.getSelectedItem()).getIdCocina());
            backData.putExtra("festividad", spinnerFestividad.getSelectedItem().toString());
            //Quiero que por defecto sea dia, por eso no compruebo 2 veces
            if (radioButtonNoche.isSelected()) {
                backData.putExtra("momentoDia", "Noche");
            } else {
                backData.putExtra("momentoDia", "Dia");
            }

        } catch (Exception e) {

        } finally {
            // Estos campos no son obligatorios por lo que permito que adelante sin complimentarlos
            setResult(result, backData);
            finish();
        }
    }
}
