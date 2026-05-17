/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package pantallas.AdministrarMesas;

import coordinador.CoordinadorInterfaces;

/**
 *
 * @author Alejandra Leal Armenta, 262719
 */
public class mainPrueba_cuALE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        coordinador.CoordinadorInterfaces coordinador = new CoordinadorInterfaces();
        FrmPantallaMesas frm = new FrmPantallaMesas(coordinador);
        frm.setVisible(true);
    }

}
