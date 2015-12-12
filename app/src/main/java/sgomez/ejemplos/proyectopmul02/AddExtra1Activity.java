package sgomez.ejemplos.proyectopmul02;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;

import java.util.ArrayList;

import sgomez.ejemplos.proyectopmul02.model.Local;

public class AddExtra1Activity extends AppCompatActivity {
    private Spinner spinnerLocales;
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_extra1);
        spinnerLocales = ((Spinner) findViewById(R.id.spinnerLocales));
        datePicker = (DatePicker) findViewById(R.id.addExtraDatePicker);

    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Local> locales = MainActivity.getLocalRepository().getLocales();
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, locales);

    }

    public void buttonAddExtra1NextOnClick(View view) {
        Intent backData = new Intent();
//        backData.putExtra("idLocal", ((Local) spinnerLocales.getSelectedItem()).getIdLocal());
        backData.putExtra("año", datePicker.getYear()-1900);
        backData.putExtra("mes", datePicker.getMonth());
        backData.putExtra("dia", datePicker.getDayOfMonth());
        setResult(Activity.RESULT_OK, backData);
        finish();


    }
}
