/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author valeria
 */
public class DetallePagoCodi extends DetallePago {
    private String referencia;
    private String folio;

    public DetallePagoCodi() {
    }

    public DetallePagoCodi(String referencia, String folio) {
        this.referencia = referencia;
        this.folio = folio;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }
}
