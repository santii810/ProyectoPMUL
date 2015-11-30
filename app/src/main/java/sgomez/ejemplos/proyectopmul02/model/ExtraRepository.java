package sgomez.ejemplos.proyectopmul02.model;

import java.util.ArrayList;

/**
 * Created by sgomez on 28/11/2015.
 */
public interface ExtraRepository {
    ArrayList<Extra> getExtras();
    void addExtra(Extra extra);
    void deleteExtra(int extraId);
    Extra getExtra(int extraId);
}
