package sgomez.ejemplos.proyectopmul02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import sgomez.ejemplos.proyectopmul02.model.Extra;
import sgomez.ejemplos.proyectopmul02.model.adapters.ExtraAdapter;

public class ViewExtrasActivity extends AppCompatActivity {
    private ListView extrasListView;
    private ArrayList<Extra> extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_extras);

        extrasListView = (ListView) findViewById(R.id.listViewViewExtras);
    }


    @Override
    protected void onResume() {
        extras = MainActivity.getExtraRepository().getExtras();
        extrasListView.setAdapter(new ExtraAdapter(this, R.layout.view_item_subitem, extras));
        super.onResume();
    }
}
