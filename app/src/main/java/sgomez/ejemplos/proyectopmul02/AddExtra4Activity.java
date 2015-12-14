package sgomez.ejemplos.proyectopmul02;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import sgomez.ejemplos.proyectopmul02.model.Camarero;

public class AddExtra4Activity extends AppCompatActivity {
    private ArrayList<Camarero> camareros;
    private ListView camarerosListView;
    private TextView textViewContadorCamareros;
    private ArrayList<Camarero> camarerosPresentes;
    private int cont = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_extra4);
        camarerosPresentes = new ArrayList<>();
        camareros = MainActivity.getCamareroRepository().getCamareros();

        textViewContadorCamareros = (TextView) findViewById(R.id.textViewContadorCamareros);

        camarerosListView = (ListView) findViewById(R.id.listViewAddExtra4Camareros);
        camarerosListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent
                            , View view, int position, long id) {
                        if (camarerosListView.isItemChecked(position)) {
                            camarerosListView.setItemChecked(position, false);
                            view.setBackgroundColor(Color.GRAY);
                        } else {
                            camarerosListView.setItemChecked(position, true);
                            view.setBackgroundColor(Color.GREEN);
                        }
                        if (!camarerosPresentes.contains(camareros.get(position))) {
                            camarerosPresentes.add(camareros.get(position));
                            textViewContadorCamareros.setText(Integer.toString(++cont));
                        }
                    }
                });
    }

    @Override
    protected void onResume() {
        camareros = MainActivity.getCamareroRepository().getCamareros();
        camarerosListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, camareros));
        super.onResume();
    }

    public void buttonAddExtra4FinalizarOnClick(View view) {
        String id = getIntent().getStringExtra("id");
        MainActivity.getExtraRepository().addCamareros(camarerosPresentes, id);
        finish();
    }
}
