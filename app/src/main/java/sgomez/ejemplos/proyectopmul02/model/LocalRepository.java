package sgomez.ejemplos.proyectopmul02.model;

import java.util.ArrayList;

/**
 * Created by sgomez on 29/11/2015.
 */
public interface LocalRepository {
    ArrayList<Local> getLocales();
    void addLocal(Local local);
    void deleteLocal(int idLocal);
    Local getLocal(int idLocal);
}
