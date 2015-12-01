package sgomez.ejemplos.proyectopmul02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class AddCamareroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_camarero);
    }

    public void buttonAddCamareroOnClick(View view) {
        Intent backData = new Intent();
        backData.putExtra("nombreCamarero", ((EditText) findViewById(R.id.editTextCamareroName)).getText().toString());
        //string switch = ((Switch) findViewById(R.id.switchCamareroActivo).);
        //backData.putExtra("activo", true );
        setResult(RESULT_OK, backData);
    }
}
