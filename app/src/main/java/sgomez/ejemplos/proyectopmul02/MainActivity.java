package sgomez.ejemplos.proyectopmul02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import sgomez.ejemplos.proyectopmul02.model.LocalRepository;
import sgomez.ejemplos.proyectopmul02.model.ParseLocalRepository;

public class MainActivity extends AppCompatActivity {
    private static LocalRepository localRepository;

    public static LocalRepository getLocalRepository() {
        return localRepository;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localRepository = new ParseLocalRepository(this);

    }

    public void buttonAddDataOnClick(View view) {
        Intent intent = new Intent(this, AddDataActivity.class);
        startActivity(intent);
    }

}
