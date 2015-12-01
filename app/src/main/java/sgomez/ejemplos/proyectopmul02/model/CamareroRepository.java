package sgomez.ejemplos.proyectopmul02.model;

import java.util.ArrayList;

/**
 * Created by sgomez on 29/11/2015.
 */
public interface CamareroRepository {
    ArrayList<Camarero> getCamareros();

    void addCamarero(Camarero camarero);

    void deleteCamarero(String idCamarero);

    void deleteCamareros(ArrayList<Camarero> camareros);

    Camarero getCamarero(String idCamarero);
}
