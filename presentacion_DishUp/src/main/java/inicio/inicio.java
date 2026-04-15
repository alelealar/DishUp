package inicio;

import coordinador.CoordinadorInterfaces;
import pantallas.FrmPantallaComandas;

/**
 *
 * @author DishUp
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
        coordinador.CoordinadorInterfaces coordinador = new CoordinadorInterfaces();
        FrmPantallaComandas frm = new FrmPantallaComandas(coordinador);
        frm.setVisible(true);
    }

}