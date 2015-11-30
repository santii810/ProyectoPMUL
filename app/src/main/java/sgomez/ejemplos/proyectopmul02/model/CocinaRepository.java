package sgomez.ejemplos.proyectopmul02.model;

import java.util.ArrayList;

/**
 * Created by sgomez on 29/11/2015.
 */
public interface CocinaRepository {
    ArrayList<Cocina> getCocinas();

    void addCocina(Cocina cocina);

    void deleteCocina(int idCocina);

    Cocina getCocina(int idCocina);
}
