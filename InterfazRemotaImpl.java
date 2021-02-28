

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

}