package sgomez.ejemplos.proyectopmul02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import sgomez.ejemplos.proyectopmul02.model.Local;

public class AddDataActivity extends AppCompatActivity {
    public final static int ADDEXTRA_REQUEST_CODE = 1;
    public final static int ADDLOCAL_REQUEST_CODE = 2;
    public final static int ADDCAMARERO_REQUEST_CODE = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
    }

    /*
        public void buttonAddExtraOnClick(View view) {
            Intent intent = new Intent(this, AddExtra1Activity.class);
            startActivityForResult(intent, ADDEXTRA_REQUEST_CODE);
        }
    */
    public void butttonAddLocalOnClick(View view) {
        Intent intent = new Intent(this, AddLocalActivity.class);
        startActivityForResult(intent, ADDLOCAL_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADDLOCAL_REQUEST_CODE) {

            if (resultCode == RESULT_OK) {
                String nombreLocal = data.getStringExtra("nombreLocal");
                String direccionLocal = data.getStringExtra("direccionLocal");

            }
        }
        switch (requestCode) {

            case ADDEXTRA_REQUEST_CODE:
                if (resultCode == RESULT_OK) {


                }
                break;
            case ADDLOCAL_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    String nombreLocal = data.getStringExtra("nombreLocal");
                    String direccionLocal = data.getStringExtra("direccionLocal");
                    MainActivity.getLocalRepository().addLocal(new Local(nombreLocal, direccionLocal));
                }
                break;
            case ADDCAMARERO_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    String nombreCamarero = data.getStringExtra("nombreCamarero");

                }
                break;
        }
    }


}
