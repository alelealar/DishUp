/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author DishUp
 */
public class InfraestructuraException extends Exception {

    public InfraestructuraException(String message) {
        super(message);
    }

    public InfraestructuraException(String message, Throwable cause) {
        super(message, cause);
    }
}
