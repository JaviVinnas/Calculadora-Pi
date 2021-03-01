public class Calculo implements Runnable {

    private Resultado numPuntosValidos;
    private final long numPuntosACalcular;

    public Calculo(Resultado numPuntosValidos, long numPuntosACalcular) {
        this.numPuntosValidos = numPuntosValidos;
        this.numPuntosACalcular = numPuntosACalcular;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.numPuntosACalcular; i += 1) {
            Punto punto = new Punto();
            // verificamos la desigualdad
            if (punto.getX() * punto.getX() + punto.getY() * punto.getY() <= 1.0) {
                numPuntosValidos.encontrado();
            }
        }
    }
}
