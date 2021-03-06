package sgomez.ejemplos.proyectopmul02.model;

import java.util.ArrayList;

/**
 * Created by sgomez on 28/11/2015.
 */
public interface ExtraRepository {
    ArrayList<Extra> getExtras();

    void addExtra(Extra extra);

    String addExtraCamarero(Extra extra);

    void deleteExtra(String extraId);

    Extra getExtra(String extraId);

    void addCamareros(ArrayList<Camarero> camareros, String idExtra);
}
