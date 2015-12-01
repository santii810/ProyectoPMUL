package model;

import android.content.Context;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import sgomez.ejemplos.proyectopmul02.MainActivity;

/**
 * Created by dam209 on 01/12/2015.
 */
public class ParseCamareroRepository implements CamareroRepository {
    public ParseCamareroRepository(Context context) {
        // Enable Local Datastore.
        Parse.enableLocalDatastore(context);
        Parse.initialize(context, MainActivity.getAPLICATIONID(), MainActivity.getCLIENTKEY());

    }

    @Override
    public ArrayList<Camarero> getCamareros() {
        ArrayList<Camarero> camareros = new ArrayList<>();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Camarero");
        try {
            List<ParseObject> result = query.find();
            for (ParseObject object : result) {
                Camarero camarero = new Camarero();
                camarero.setIdCamarero(object.getObjectId());
                camarero.setNombre(object.getString("nombreCamarero"));
                camareros.add(camarero);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return camareros;
    }

    @Override
    public void addCamarero(Camarero camarero) {
        ParseObject parseLocal = new ParseObject("Camarero");
        parseLocal.put("nombreCamarero", camarero.getNombre());
        parseLocal.saveInBackground();
    }

    @Override
    public void deleteCamarero(String idCamarero) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Camarero");
        try {
            query.whereEqualTo("objectId", idCamarero);
            List<ParseObject> result = query.find();

            if (result.size() > 0) {
                result.get(0).delete();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCamareros(ArrayList<Camarero> camareros) {

    }

    @Override
    public Camarero getCamarero(String idCamarero) {
        return null;
    }
}
