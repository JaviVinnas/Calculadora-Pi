import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
    public long puntosQueCumplenDesigualdad(long numPuntos) {
        long ptosValidos = 0;
        for (long i = 0; i < numPuntos; i += 1) {
            Punto punto = new Punto();
            //verificamos la desigualdad
            if (punto.getX()*punto.getX() + punto.getY()*punto.getY() <= 1.0) {
                ptosValidos+=1;
            }

        }
        return ptosValidos;
    }

}