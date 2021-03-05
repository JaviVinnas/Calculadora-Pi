import java.util.Random;
import java.util.Date;

public class Calculo implements Runnable {

    private final Resultado numPuntosValidos;
    private final long numPuntosACalcular;
    private final Random generator;

    public Calculo(Resultado numPuntosValidos, long numPuntosACalcular) {
        this.numPuntosValidos = numPuntosValidos;
        this.numPuntosACalcular = numPuntosACalcular;
        this.generator = new Random(new Date().getTime());
    }

    @Override
    public void run() {
        for (int i = 0; i < this.numPuntosACalcular; i += 1) {
            Punto punto = new Punto(this.generator);
            // verificamos la desigualdad
            if (punto.getX() * punto.getX() + punto.getY() * punto.getY() <= 1.0) {
                this.numPuntosValidos.encontrado();
            }
        }
    }
}
