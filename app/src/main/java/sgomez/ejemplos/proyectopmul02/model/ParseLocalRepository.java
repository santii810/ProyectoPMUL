package sgomez.ejemplos.proyectopmul02.model;


import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import sgomez.ejemplos.proyectopmul02.MainActivity;


public class ParseLocalRepository implements LocalRepository {
    private final String DBNAME = "Local";
    private final String TABLEID = "objectId";
    private final String TABLENOMBRE = "nombreLocal";
    private final String TABLEDIRECCION = "direccionLocal";
    private final String TABLEINSERCION = "insertadoPor";

    public ParseLocalRepository() {}

    @Override
    public ArrayList<Local> getLocales() {
        ArrayList<Local> locales = new ArrayList<>();
        ParseQuery<ParseObject> query = ParseQuery.getQuery(DBNAME);
        try {
            List<ParseObject> result = query.find();
            for (ParseObject object : result) {
                locales.add(rellenaLocal(object));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return locales;
    }

    @Override
    public ArrayList<String> getLocalNames() {
        ArrayList<String> nombreLocales = new ArrayList<>();
        for (Local local : this.getLocales()) {
            nombreLocales.add(local.getNombre());
        }
        return nombreLocales;
    }


    @Override
    public void addLocal(Local local) {
        ParseObject parseLocal = new ParseObject(DBNAME);
        parseLocal.put(TABLENOMBRE, local.getNombre());
        parseLocal.put(TABLEDIRECCION, local.getDireccion());
        parseLocal.put(TABLEINSERCION, MainActivity.getUser().getId());

        parseLocal.saveInBackground();
    }

    @Override
    public void deleteLocal(String idLocal) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery(DBNAME);
        try {
            query.whereEqualTo(TABLEID, idLocal);
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
        Local local = new Local();
        ParseQuery<ParseObject> query = ParseQuery.getQuery(DBNAME);
        try {
            query.whereEqualTo(TABLEID, idLocal);
            List<ParseObject> result = query.find();

            if (result.size() > 0) {
                local = rellenaLocal(result.get(0));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return local;
    }

    private Local rellenaLocal(ParseObject result) {
        Local local = new Local();
        local.setIdLocal(result.getObjectId());
        local.setNombre(result.getString(TABLENOMBRE));
        local.setDireccion(result.getString(TABLEDIRECCION));
        return local;
    }
}

