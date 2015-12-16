package sgomez.ejemplos.proyectopmul02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import sgomez.ejemplos.proyectopmul02.model.Camarero;
import sgomez.ejemplos.proyectopmul02.model.adapters.CamareroAdapter;

public class ViewCamarerosActivity extends AppCompatActivity {
    private ListView camarerosListView;
    private ArrayList<Camarero> camareros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_camareros);

        camarerosListView = new ListView(this);
        camarerosListView = (ListView) findViewById(R.id.listViewViewCamareros);
    }

    @Override
    protected void onResume() {
        camareros = MainActivity.getCamareroRepository().getCamareros();
        camarerosListView.setAdapter(new CamareroAdapter(this, R.layout.view_item_subitem, camareros));
        super.onResume();
    }
}

