package sgomez.ejemplos.proyectopmul02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

public class AddCocinaActivity extends AppCompatActivity {
    ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cocina);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButtonCocina);
    }

    public void buttonAddCocinaOnClick(View view) {
        Intent backData = new Intent();
        String nombreCocina = ((EditText) findViewById(R.id.editTextCocinaName)).getText().toString();
        boolean estado = toggleButton.isChecked();
        backData.putExtra("nombreCocina", nombreCocina);
        backData.putExtra("activa", estado);
        setResult(RESULT_OK, backData);
        finish();
    }
}
