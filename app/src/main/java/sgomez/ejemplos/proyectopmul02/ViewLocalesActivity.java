package sgomez.ejemplos.proyectopmul02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import sgomez.ejemplos.proyectopmul02.model.Local;
import sgomez.ejemplos.proyectopmul02.model.adapters.LocalAdapter;

public class ViewLocalesActivity extends AppCompatActivity {
    private ListView localesListView;
    private ArrayList<Local> locales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        locales = new ArrayList<>();
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_view_locales);
        localesListView = new ListView(this);
        localesListView = (ListView) findViewById(R.id.listViewViewLocales);

    }

    @Override
    protected void onResume() {
        locales = MainActivity.getLocalRepository().getLocales();
        localesListView.setAdapter(new LocalAdapter(this, R.layout.view_item_subitem, locales));
        super.onResume();
    }

}
