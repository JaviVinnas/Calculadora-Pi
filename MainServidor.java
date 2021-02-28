

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.Naming;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class MainServidor {

    public static void main(String[] args) {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String portNum, registryURL;

        try{
            System.out.println("Introduce el número de puerto:");
            portNum = (br.readLine()).trim();
            int RMIPortNum = Integer.parseInt(portNum);
            startRegistry(RMIPortNum);
            //en este punto podemos asegurar que tenemos un registro creado en ese puerto
            InterfazRemota exportedObj = new InterfazRemotaImpl();
            //ruta donde se mete el objeto
            registryURL = "rmi://localhost:" + portNum + "/hello";
            Naming.rebind(registryURL, exportedObj);
            System.out.println("Servidor registrado. El RMI registry ahora mismo contiene:");
            listRegistry(registryURL);
            System.out.println("Servidor en localhost:" + RMIPortNum + " listo");
        } catch (Exception re) {
            System.out.println("Exception in HelloServer.main: " + re);
        }

    }

    /**
     * Empieza un RMI registry en el localhost en un determinado
     * 
     * @param RMIPortNum puerto donde estará el RMI registry
     * @throws RemoteException excepción que se lanzará cuando no se encuentre el
     *                         RMI registry
     */
    private static void startRegistry(int RMIPortNum) throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(RMIPortNum);
            //comprobamos si existiera el RMI registry (lanzaría una excepción si no)
            registry.list(); 
        } catch (RemoteException e) {
            // No hay un RMI registry en el puerto especificado
            System.out.println("No hay un RMI registry en el puerto " + RMIPortNum);
            //creamos el RMI registry e informamos al usuario
            Registry registry = LocateRegistry.createRegistry(RMIPortNum);
            System.out.println("RMI" + registry + " registry created at port " + RMIPortNum);
        }
    }


    /**
     * Lista los nombres de un RMI registry
     * @param registryURL URL del registro
     * @throws RemoteException Excepcion remota
     * @throws MalformedURLException Si la url está pocha
     */
    private static void listRegistry(String registryURL) throws RemoteException, MalformedURLException {
        System.out.println("Registry " + registryURL + " contains: ");
        String[] names = Naming.list(registryURL);
        for (int i = 0; i < names.length; i++)
            System.out.println(names[i]);
    }

}
