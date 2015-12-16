package sgomez.ejemplos.proyectopmul02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

public class AddCamareroActivity extends AppCompatActivity {
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_camarero);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButtonCamarero);
    }

    public void buttonAddCamareroOnClick(View view) {
        Intent backData = new Intent();
        String nombreCamarero = ((EditText) findViewById(R.id.editTextCamareroName)).getText().toString();
        boolean estado = toggleButton.isChecked();
        backData.putExtra("nombreCamarero", nombreCamarero);
        backData.putExtra("activo", estado);
        setResult(RESULT_OK, backData);
        finish();
    }
}
