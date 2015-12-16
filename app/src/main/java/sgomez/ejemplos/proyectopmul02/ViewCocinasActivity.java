package sgomez.ejemplos.proyectopmul02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import sgomez.ejemplos.proyectopmul02.model.Cocina;
import sgomez.ejemplos.proyectopmul02.model.adapters.CocinaAdapter;

public class ViewCocinasActivity extends AppCompatActivity {
    private ListView cocinasListView;
    private ArrayList<Cocina> cocinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cocinas);


        setContentView(R.layout.activity_view_cocinas);
        cocinasListView = new ListView(this);
        cocinasListView = (ListView) findViewById(R.id.listViewCocinas);

    }

    @Override
    protected void onResume() {
        cocinas = MainActivity.getCocinaRepository().getCocinas();
        cocinasListView.setAdapter(new CocinaAdapter(this, R.layout.view_item_subitem, cocinas));
        super.onResume();

    }
}
