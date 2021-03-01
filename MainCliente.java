import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;

public class MainCliente {

    public static void main(String[] args) {
        try {
            String hostName;
            InputStreamReader is = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(is);
            System.out.println("Introduce el nombre de host de RMIRegistry (localhost por defecto):");
            hostName = br.readLine();
            System.out.println("Introduce el número de puerto de RMIRegistry (1099 por defecto):");
            String portNum = br.readLine();
            String registryURL = "rmi://" + hostName + ":" + portNum + "/hello";
            InterfazRemota h = (InterfazRemota) Naming.lookup(registryURL);
            System.out.println("Chequeo completado");
            System.out.println("Comprobación: " + h.sayHello("Pepe"));
            while (true) {
                System.out.print("Introduce el numero de puntos a calcular: ");
                long numPuntos = Long.parseLong(br.readLine());
                long puntosValidos = h.puntosQueCumplenDesigualdad(numPuntos);
                System.out.println("De los " + numPuntos + " puntos, " + puntosValidos + "han cumplido la regla");
                System.out.println("Aproximación de PI -> " + (4.0*puntosValidos/numPuntos));
            }
        } catch (Exception x) {
            System.out.println("Excepción en MainCliente: " + x);
        }
    }

}
