

import java.rmi.*;


public interface InterfazRemota extends Remote {

    /**
     * Método que añade un hola al nombre que se le pase por argumentos
     * @param name nombre en formato string
     * @return Cadena modificada
     * @throws java.rmi.RemoteException excepciones remotas que pudieran surgir
     */
    public String sayHello(String name) throws java.rmi.RemoteException;

}