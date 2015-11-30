package sgomez.ejemplos.proyectopmul02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddLocalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_local);
    }

    public void buttonAddLocalOnClick(View view) {
        Intent backData = new Intent();
        backData.putExtra("nombreLocal", ((EditText) findViewById(R.id.editTextLocalName)).getText().toString());
        backData.putExtra("direccionLocal", ((EditText) findViewById(R.id.editTextLocalAddress)).getText().toString());
        setResult(RESULT_OK, backData);
    }
}
