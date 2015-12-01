package sgomez.ejemplos.proyectopmul02;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import sgomez.ejemplos.proyectopmul02.model.Local;

public class ViewLocalesActivity extends AppCompatActivity {
    private ListView localesListView;
    private ArrayList<Local> locales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_locales);

        localesListView = (ListView) findViewById(R.id.listViewLocales);
        localesListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent
                            , View view, int position, long id) {
                        Local local = locales.get(position);

                        Intent intent = new Intent(getBaseContext(),
                                ViewLocalDataActivity.class);
                        intent.putExtra("id", local.getIdLocal());

                        startActivity(intent);
                    }
                });
    }
    @Override
    protected void onResume() {
        super.onResume();

        locales = MainActivity.getLocalRepository().getLocales();
        ArrayAdapter<Local> adapter = new ArrayAdapter<Local>(this,
                android.R.layout.simple_list_item_1, locales);
        localesListView.setAdapter(adapter);
    }

}
