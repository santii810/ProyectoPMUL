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
public class ParseCamareroRepository implements CamareroRepository {

    private final String DBNAME = "Camarero";
    private final String TABLEID = "objectId";
    private final String TABLENOMBRE = "nombreCamarero";
    private final String TABLEACTIVO = "activo";
    private final String TABLEINSERCION = "insertadoPor";


    public ParseCamareroRepository() {

    }

    @Override
    public ArrayList<Camarero> getCamareros() {
        ArrayList<Camarero> camareros = new ArrayList<>();
        ParseQuery<ParseObject> query = ParseQuery.getQuery(DBNAME);
        try {
            List<ParseObject> result = query.find();
            for (ParseObject object : result) {
                camareros.add(rellenaCamarero(object));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return camareros;
    }

    @Override
    public void addCamarero(Camarero camarero) {
        ParseObject parseCamarero = new ParseObject(DBNAME);
        parseCamarero.put(TABLENOMBRE, camarero.getNombre());
        parseCamarero.put(TABLEACTIVO, camarero.isActivo());
        parseCamarero.put(TABLEINSERCION, MainActivity.getUser().getId());

        parseCamarero.saveInBackground();
    }

    @Override
    public void deleteCamarero(String idCamarero) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery(DBNAME);
        try {
            query.whereEqualTo(TABLEID, idCamarero);
            List<ParseObject> result = query.find();

            if (result.size() > 0) {
                result.get(0).delete();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Camarero getCamarero(String idCamarero) {

        Camarero camarero = new Camarero();
        ParseQuery<ParseObject> query = ParseQuery.getQuery(DBNAME);
        try {
            query.whereEqualTo(TABLEID, idCamarero);
            List<ParseObject> result = query.find();

            if (result.size() > 0) {
                camarero = rellenaCamarero(result.get(0));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return camarero;
    }

    private Camarero rellenaCamarero(ParseObject result) {
        Camarero camarero = new Camarero();
        camarero.setIdCamarero(result.getObjectId());
        camarero.setNombre(result.getString(TABLENOMBRE));
        camarero.setActivo(result.getBoolean(TABLEACTIVO));
        return camarero;
    }
}
