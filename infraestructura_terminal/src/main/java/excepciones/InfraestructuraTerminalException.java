/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author valeria
 */
public class InfraestructuraTerminalException extends Exception {
    public InfraestructuraTerminalException(String message) {
        super(message);
    }

    public InfraestructuraTerminalException(String message, Throwable cause) {
        super(message, cause);
    }
}
