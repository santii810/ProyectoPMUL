package sgomez.ejemplos.proyectopmul02.model;

import java.util.ArrayList;

/**
 * Created by sgomez on 28/11/2015.
 */
public interface FestividadRepository {
    ArrayList<Festividad> getFestividades();
    void addFestividad(Festividad festividad);
    void deleteFestividad(int idFestividad);
    Festividad getFestividad(int idFestividad);
}
