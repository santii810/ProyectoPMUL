package sgomez.ejemplos.proyectopmul02.model;

import java.util.ArrayList;

/**
 * Created by sgomez on 29/11/2015.
 */
public interface LocalRepository {
    ArrayList<Local> getLocales();

    ArrayList<String> getLocalNames();

    void addLocal(Local local);

    void deleteLocal(String idLocal);

    Local getLocal(String idLocal);
}
