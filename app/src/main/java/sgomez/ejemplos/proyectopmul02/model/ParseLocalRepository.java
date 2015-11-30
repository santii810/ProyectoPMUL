package sgomez.ejemplos.proyectopmul02.model;

import android.content.Context;

import com.parse.Parse;
import com.parse.ParseObject;

import java.util.ArrayList;

/**
 * Created by dam209 on 30/11/2015.
 */
public class ParseLocalRepository implements LocalRepository {
    public ParseLocalRepository(Context context) {
        // Enable Local Datastore.
        Parse.enableLocalDatastore(context);
        Parse.initialize(context, "8H90I8DD1HC7bC1DSTZ0A3Hx8R9IvjpfYfnMFAaD", "jgFlObtthO7RJEqIFa7oeM87prVKyleiNche125E");




    }

    @Override
    public ArrayList<Local> getLocales() {
        return null;
    }

    @Override
    public void addLocal(Local local) {
        ParseObject parseLocal = new ParseObject("Local");
        parseLocal.put("nombreLocal", local.getNombre());
        parseLocal.put("direccionLocal",local.getDireccion());
        parseLocal.saveInBackground();
    }

    @Override
    public void deleteLocal(int idLocal) {

    }

    @Override
    public Local getLocal(int idLocal) {
        return null;
    }
}

