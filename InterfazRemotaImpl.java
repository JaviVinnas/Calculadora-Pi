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
    public long puntosQueCumplenDesigualdad(long numPuntos, int numHilos) throws RemoteException {
        Thread[] hilos = new Thread[numHilos];

        Resultado resultado = new Resultado();

        for (int i = 0; i < numHilos; i+=1){
            hilos[i] = new Thread(new Calculo(resultado, numPuntos/numHilos));
            hilos[i].start();
        }

        try {
            for (int i = 0; i < numHilos; i += 1) {
                hilos[i].join();
            }
        }catch (InterruptedException ignore){}

        return resultado.getNum();
    }

}