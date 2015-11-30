package sgomez.ejemplos.proyectopmul02.model;

import android.content.Context;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

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

        ArrayList<Local> locales = new ArrayList<>();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Local");
        try {
            List<ParseObject> result = query.find();
            for (ParseObject object : result) {
                Local local = new Local();
                local.setIdLocal(object.getObjectId());
                local.setNombre(object.getString("nombreLocal"));
                local.setDireccion(object.getString("direccionLocal"));
                locales.add(local);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return locales;
    }

    @Override
    public void addLocal(Local local) {
        ParseObject parseLocal = new ParseObject("Local");
        parseLocal.put("nombreLocal", local.getNombre());
        parseLocal.put("direccionLocal", local.getDireccion());
        parseLocal.saveInBackground();
    }

    @Override
    public void deleteLocal(String idLocal) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Local");
        try {
            query.whereEqualTo("objectId", idLocal);
            List<ParseObject> result = query.find();

            if (result.size() > 0) {
                result.get(0).delete();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Local getLocal(String idLocal) {
        return null;
    }
}

