package sgomez.ejemplos.proyectopmul02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.parse.Parse;

import sgomez.ejemplos.proyectopmul02.model.CamareroRepository;
import sgomez.ejemplos.proyectopmul02.model.CocinaRepository;
import sgomez.ejemplos.proyectopmul02.model.ExtraRepository;
import sgomez.ejemplos.proyectopmul02.model.LocalRepository;
import sgomez.ejemplos.proyectopmul02.model.ParseCamareroRepository;
import sgomez.ejemplos.proyectopmul02.model.ParseCocinaRepository;
import sgomez.ejemplos.proyectopmul02.model.ParseExtraRepository;
import sgomez.ejemplos.proyectopmul02.model.ParseLocalRepository;

public class MainActivity extends AppCompatActivity {
    private static CamareroRepository camareroRepository;
    private static CocinaRepository cocinaRepository;
    private static LocalRepository localRepository;
    private static ExtraRepository extraRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.initialize(this, getResources().getString(R.string.parseId), getResources().getString(R.string.parseKey));
        localRepository = new ParseLocalRepository();
        camareroRepository = new ParseCamareroRepository();
        cocinaRepository = new ParseCocinaRepository();
        extraRepository = new ParseExtraRepository();

    }

    public void buttonAddDataOnClick(View view) {
        Intent intent = new Intent(this, AddDataActivity.class);
        startActivity(intent);
    }

    public void buttonViewDataOnClick(View view) {
        Intent intent = new Intent(this, ViewDataActivity.class);
        startActivity(intent);
    }


    public static CamareroRepository getCamareroRepository() {
        return camareroRepository;
    }

    public static LocalRepository getLocalRepository() {
        return localRepository;
    }

    public static CocinaRepository getCocinaRepository() {
        return cocinaRepository;
    }

    public static ExtraRepository getExtraRepository() {
        return extraRepository;
    }
}
