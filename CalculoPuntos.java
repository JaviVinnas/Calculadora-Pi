import java.rmi.RemoteException;

public class CalculoPuntos implements Runnable {

    private final Resultado resultado;
    private final long numPuntosACalcular;
    private final InterfazRemota interfazRemota;

    public CalculoPuntos(Resultado resultado, long numPuntosACalcular, InterfazRemota interfazRemota) {
        this.resultado = resultado;
        this.numPuntosACalcular = numPuntosACalcular;
        this.interfazRemota = interfazRemota;
    }

    @Override
    public void run() {
        try{
            this.resultado.add(interfazRemota.puntosQueCumplenDesigualdad(numPuntosACalcular));
        } catch (RemoteException exception) {
            exception.printStackTrace();
        }
    }
}
