/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package inicio;

import coordinador.CoordinadorInterfaces;
import pantallas.FrmPantallaComandas;

/**
 *
 * @author DishUp
 */
public class inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        coordinador.CoordinadorInterfaces coordinador = new CoordinadorInterfaces();
        FrmPantallaComandas frm = new FrmPantallaComandas(coordinador);
        frm.setVisible(true);
    }

}
