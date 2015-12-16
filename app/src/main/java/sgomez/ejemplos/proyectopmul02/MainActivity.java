package sgomez.ejemplos.proyectopmul02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.parse.Parse;

import sgomez.ejemplos.proyectopmul02.model.CamareroRepository;
import sgomez.ejemplos.proyectopmul02.model.CocinaRepository;
import sgomez.ejemplos.proyectopmul02.model.ExtraRepository;
import sgomez.ejemplos.proyectopmul02.model.LocalRepository;
import sgomez.ejemplos.proyectopmul02.model.ParseCamareroRepository;
import sgomez.ejemplos.proyectopmul02.model.ParseCocinaRepository;
import sgomez.ejemplos.proyectopmul02.model.ParseExtraRepository;
import sgomez.ejemplos.proyectopmul02.model.ParseLocalRepository;
import sgomez.ejemplos.proyectopmul02.model.Usuario;

public class MainActivity extends AppCompatActivity {
    private static CamareroRepository camareroRepository;
    private static CocinaRepository cocinaRepository;
    private static LocalRepository localRepository;
    private static ExtraRepository extraRepository;
    private static Usuario user;
    private static Profile profile;


    private LoginButton loginButton;
    private CallbackManager callbackManager;

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

    public static Usuario getUser() {
        return user;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Iniciar Parse
        Parse.initialize(this, getResources().getString(R.string.parseId), getResources().getString(R.string.parseKey));
        localRepository = new ParseLocalRepository();
        camareroRepository = new ParseCamareroRepository();
        cocinaRepository = new ParseCocinaRepository();
        extraRepository = new ParseExtraRepository();

        //iniciar Facebook
        FacebookSdk.sdkInitialize(getApplicationContext());

        // Hay que cargar la api de facebook antes de ejecutar el setContextView para que importe el boton estilo facebook
        setContentView(R.layout.activity_main);

        callbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton) findViewById(R.id.login_button);

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                user = new Usuario(loginResult.getAccessToken().getUserId());


                AccessToken accessToken = loginResult.getAccessToken();
                profile = Profile.getCurrentProfile();


            }


            @Override
            public void onCancel() {
                Toast.makeText(getBaseContext(), "Inicio de sesion cancelado", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(getBaseContext(), "Inicio de sesion fallido", Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void buttonAddDataOnClick(View view) {
        try {
            //intento obtener el id del usuario
            String a = user.getId();

            Intent intent = new Intent(this, AddDataActivity.class);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "Debes iniciar sesion", Toast.LENGTH_SHORT).show();
        }
    }

    public void buttonViewDataOnClick(View view) {
        try {
            //intento obtener el id del usuario
            String a = user.getId();

            Intent intent = new Intent(this, ViewDataActivity.class);
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "Debes iniciar sesion", Toast.LENGTH_SHORT).show();
        }

    }

    public void buttonPerfilOnClick(View view) {
    }
}
