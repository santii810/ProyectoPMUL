package sgomez.ejemplos.proyectopmul02.model;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import sgomez.ejemplos.proyectopmul02.MainActivity;

/**
 * Created by dam209 on 01/12/2015.
 */
public class ParseCocinaRepository implements CocinaRepository {

    private final String DBNAME = "Cocina";
    private final String TABLEID = "objectId";
    private final String TABLENOMBRE = "nombreCocina";
    private final String TABLEACTIVO = "activo";
    private final String TABLEINSERCION = "insertadoPor";


    public ParseCocinaRepository() {

    }

    @Override
    public ArrayList<Cocina> getCocinas() {
        ArrayList<Cocina> cocinas = new ArrayList<>();
        ParseQuery<ParseObject> query = ParseQuery.getQuery(DBNAME);
        try {
            List<ParseObject> result = query.find();
            for (ParseObject object : result) {
                cocinas.add(rellenaCocina(object));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cocinas;
    }

    @Override
    public void addCocina(Cocina cocina) {
        ParseObject parseCocina = new ParseObject(DBNAME);
        parseCocina.put(TABLENOMBRE, cocina.getNombre());
        parseCocina.put(TABLEACTIVO, cocina.isActivo());
        parseCocina.put(TABLEINSERCION, MainActivity.getUser().getId());
        parseCocina.saveInBackground();
    }

    @Override
    public void deleteCocina(String idCocina) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery(DBNAME);
        try {
            query.whereEqualTo(TABLEID, idCocina);
            List<ParseObject> result = query.find();

            if (result.size() > 0) {
                result.get(0).delete();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cocina getCocina(String idCocina) {

        Cocina cocina = new Cocina();
        ParseQuery<ParseObject> query = ParseQuery.getQuery(DBNAME);
        try {
            query.whereEqualTo(TABLEID, idCocina);
            List<ParseObject> result = query.find();

            if (result.size() > 0) {
                cocina = rellenaCocina(result.get(0));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return cocina;
    }

    private Cocina rellenaCocina(ParseObject result) {
        Cocina cocina = new Cocina();
        cocina.setIdCocina(result.getObjectId());
        cocina.setNombre(result.getString(TABLENOMBRE));
        cocina.setActivo(result.getBoolean(TABLEACTIVO));
        return cocina;
    }
}
