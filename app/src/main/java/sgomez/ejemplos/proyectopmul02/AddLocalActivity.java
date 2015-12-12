package sgomez.ejemplos.proyectopmul02;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddLocalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_local);

        Button boton = (Button) findViewById(R.id.buttonAddLocal);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombreLocal = ((EditText) findViewById(R.id.editTextLocalName)).getText().toString();
                String direccionLocal = ((EditText) findViewById(R.id.editTextLocalAddress)).getText().toString();

                Intent backData = new Intent();
                backData.putExtra("nombreLocal", nombreLocal);
                backData.putExtra("direccionLocal", direccionLocal);
                setResult(Activity.RESULT_OK, backData);
                finish();
            }
        });
    }

    public void buttonAddLocalCancelOnClick(View view) {
        finish();
    }
}
