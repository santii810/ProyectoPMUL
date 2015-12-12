package sgomez.ejemplos.proyectopmul02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import sgomez.ejemplos.proyectopmul02.model.Cocina;
import sgomez.ejemplos.proyectopmul02.model.adapters.cocinaAdapter;

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
        cocinasListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent
                            , View view, int position, long id) {
                        Cocina cocina = cocinas.get(position);
                        Intent intent = new Intent(getBaseContext(),
                                ViewCocinaDataActivity.class);
                        intent.putExtra("id", cocina.getIdCocina());
                        startActivity(intent);
                    }
                });
    }

    @Override
    protected void onResume() {
        cocinas = MainActivity.getCocinaRepository().getCocinas();
        cocinasListView.setAdapter(new cocinaAdapter(this, R.layout.view_item_subitem, cocinas));
        super.onResume();
    
    }
}
