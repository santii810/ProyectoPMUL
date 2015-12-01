package sgomez.ejemplos.proyectopmul02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import model.LocalRepository;
import model.ParseLocalRepository;

public class MainActivity extends AppCompatActivity {
    private static LocalRepository localRepository;
    private static final String APLICATIONID = "8H90I8DD1HC7bC1DSTZ0A3Hx8R9IvjpfYfnMFAaD";
    private static final String CLIENTKEY = "jgFlObtthO7RJEqIFa7oeM87prVKyleiNche125E";

    public static String getAPLICATIONID() {
        return APLICATIONID;
    }

    public static String getCLIENTKEY() {
        return CLIENTKEY;
    }

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

    public void buttonViewDataOnClick(View view) {
        Intent intent = new Intent(this, ViewDataActivity.class);
    }
}
