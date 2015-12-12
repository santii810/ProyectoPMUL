package sgomez.ejemplos.proyectopmul02;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import sgomez.ejemplos.proyectopmul02.model.Local;

public class ViewDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
    }

    public void buttonViewLocalesOnClick(View view) {
        Intent intent = new Intent(this, ViewLocalesActivity.class);
        startActivity(intent);
    }

    public void buttonViewCamarerosOnClick(View view) {
        Intent intent = new Intent(this, ViewCamarerosActivity.class);
        startActivity(intent);
    }

    public void buttonViewCocinasOnClick(View view) {
        Intent intent = new Intent(this, ViewCocinasActivity.class);
        startActivity(intent);
    }
}
