
import java.rmi.*;

public interface InterfazRemota extends Remote {

    /**
     * Método que añade un hola al nombre que se le pase por argumentos
     * 
     * @param name nombre en formato string
     * @return Cadena modificada
     * @throws java.rmi.RemoteException excepciones remotas que pudieran surgir
     */
    public String sayHello(String name) throws java.rmi.RemoteException;


    /**
     * devuelve el número de puntos que cumplen la desigualdad de los generados
     * @param numPuntos cantidad de puntos a verificar
     * @return los puntos que cumplen la desigualdad
     * @throws java.rmi.RemoteException excepción remota
     */
    public long puntosQueCumplenDesigualdad(long numPuntos) throws java.rmi.RemoteException;

}