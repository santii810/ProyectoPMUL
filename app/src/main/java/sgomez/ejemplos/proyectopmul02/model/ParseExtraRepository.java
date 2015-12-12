package sgomez.ejemplos.proyectopmul02.model;

import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dam209 on 01/12/2015.
 */
public class ParseExtraRepository implements ExtraRepository {

    private final String DBNAME = "Extra";
    private final String TABLE_ID_EXTRA = "objectId";
    private final String TABLE_ID_USUARIO = "usuarioId";
    private final String TABLE_ID_LOCAL = "localId";
    private final String TABLE_FECHA = "fechaExtra";
    private final String TABLE_MOMENTO_DIA = "momentoDia";
    private final String TABLE_COBRADO = "cobrado";
    private final String TABLE_PROPINA = "propina";
    private final String TABLE_PAGO_ASOCIADO = "pagoAsociado";
    private final String TABLE_FESTIVIDAD = "festividadId";
    private final String TABLE_ID_COCINA = "cocinaId";
    private final String TABLE_NOTAS = "notas";
    private final String TABLE_DURACION = "duracion";


    public ParseExtraRepository() {

    }

    @Override
    public ArrayList<Extra> getExtras() {
        ArrayList<Extra> extras = new ArrayList<>();
        ParseQuery<ParseObject> query = ParseQuery.getQuery(DBNAME);
        try {
            List<ParseObject> result = query.find();
            for (ParseObject object : result) {
                extras.add(rellenaExtra(object));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return extras;
    }

    @Override
    public void addExtra(Extra extra) {
        ParseObject parseLocal = new ParseObject(DBNAME);
//        parseLocal.put(TABLE_ID_USUARIO, extra.getIdUsuario());
        parseLocal.put(TABLE_COBRADO, extra.getCobrado());
        parseLocal.put(TABLE_DURACION, extra.getDuracion());
        parseLocal.put(TABLE_PAGO_ASOCIADO, extra.getPagoAsociado());
        parseLocal.put(TABLE_FECHA, extra.getFechaExtra());
        parseLocal.put(TABLE_PROPINA, extra.getPropina());
//        parseLocal.put(TABLE_ID_LOCAL, extra.getLocal());
//        parseLocal.put(TABLE_FESTIVIDAD, extra.getFestividad());
//        parseLocal.put(TABLE_ID_COCINA, extra.getCocina());
        parseLocal.put(TABLE_NOTAS, extra.getNotas());
//        parseLocal.put(TABLE_MOMENTO_DIA, extra.getMomentoDia());


        try {
            parseLocal.save();
        } catch (ParseException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void deleteExtra(String extraId) {

    }

    @Override
    public Extra getExtra(String extraId) {
        return null;
    }

    private Extra rellenaExtra(ParseObject result) {
        Extra extra = new Extra();
        extra.setIdExtra(result.getObjectId());
        extra.setNotas(result.getString(TABLE_NOTAS));
        extra.setPropina(result.getDouble(TABLE_PROPINA));
        extra.setDuracion(result.getDouble(TABLE_DURACION));
        extra.setCobrado(result.getInt(TABLE_COBRADO));
        extra.setCocina(result.getString(TABLE_ID_COCINA));
        extra.setFechaExtra(result.getDate(TABLE_FECHA));
        extra.setFestividad(result.getString(TABLE_FESTIVIDAD));
        extra.setIdLocal(result.getString(TABLE_ID_LOCAL));
        extra.setMomentoDia(result.getString(TABLE_MOMENTO_DIA));
        extra.setPagoAsociado(result.getDouble(TABLE_PAGO_ASOCIADO));

        return extra;
    }
}
