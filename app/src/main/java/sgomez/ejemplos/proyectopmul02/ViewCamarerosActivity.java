package sgomez.ejemplos.proyectopmul02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        camarerosListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent
                            , View view, int position, long id) {
                        Camarero camarero = camareros.get(position);
                        Intent intent = new Intent(getBaseContext(),
                                ViewCamareroDataActivity.class);
                        intent.putExtra("id", camarero.getIdCamarero());
                        startActivity(intent);
                    }
                });
    }

    @Override
    protected void onResume() {
        camareros = MainActivity.getCamareroRepository().getCamareros();
        camarerosListView.setAdapter(new CamareroAdapter(this, R.layout.view_item_subitem, camareros));
        super.onResume();
    }
    }

