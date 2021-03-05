import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;
import java.util.Date;

public class InterfazRemotaImpl extends UnicastRemoteObject implements InterfazRemota {

    
    private static final long serialVersionUID = 1L;

    public InterfazRemotaImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        return "Hola, " + name;
    }

    

    @Override
    public long puntosQueCumplenDesigualdad(long numPuntos) throws RemoteException {
        long puntosAceptados = 0L;
        Random generator = new Random(new Date().getTime());
        for (int i = 0; i < numPuntos; i += 1) {
            Punto punto = new Punto(generator);
            if (punto.getX() * punto.getX() + punto.getY() * punto.getY() <= 1.0) {
                puntosAceptados += 1;
            }
        }
        return puntosAceptados;
    }

}