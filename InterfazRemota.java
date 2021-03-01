
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
     * calcula el porcentaje de puntos que caen en una circunferencia de radio 1
     * 
     * @param numPuntos número de puntos a evaluar
     * @return cantidad de puntos de los generados que caen en una circunferencia de
     *         radio 1
     */
    public long puntosQueCumplenDesigualdad(long numPuntos) throws java.rmi.RemoteException;

}