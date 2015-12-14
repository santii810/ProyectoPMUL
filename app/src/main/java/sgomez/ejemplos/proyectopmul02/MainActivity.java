package sgomez.ejemplos.proyectopmul02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
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

    private TextView info;
    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        user = new Usuario("485094501692517");


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
        info = (TextView) findViewById(R.id.textViewFacebookInfo);
        loginButton = (LoginButton) findViewById(R.id.login_button);

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                user = new Usuario(loginResult.getAccessToken().getUserId());
                info.setText(loginResult.getAccessToken().getUserId() + " " + user.getId());

                AccessToken accessToken = loginResult.getAccessToken();
                profile = Profile.getCurrentProfile();


            }


            @Override
            public void onCancel() {
                info.setText("Inicio de sesion cancelado.");
            }

            @Override
            public void onError(FacebookException e) {
                info.setText("Inicio de sesion fallido");
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

    public void buttonPerfilOnClick(View view) {
    }
}
