public class CalculoPi {

    private final InterfazRemota interfazRemota;

    public CalculoPi(InterfazRemota interfazRemota) {
        this.interfazRemota = interfazRemota;
    }

    /**
     * Calcula el número de puntos que cumplen la desigualdad creando los hilos en
     * el cliente
     * 
     * @param numPuntos puntos que queremos verificar
     * @param numHilos  numero de hilos en el cliente
     * @return puntos de los totales que cumplen la desigualdad
     */
    public long calculoPuntos(long numPuntos, int numHilos) {
        // creo el array de hilos
        Thread[] hilos = new Thread[numHilos];
        Resultado resultado = new Resultado();
        for (int i = 0; i < numHilos; i += 1) {
            long ptosPorHilo = numPuntos / numHilos;
            //al último se le añade el resto
            if (i == numHilos - 1) {
                ptosPorHilo += numPuntos % numHilos;
            }
            hilos[i] = new Thread(new CalculoPuntos(resultado, ptosPorHilo, this.interfazRemota));
            hilos[i].start();
        }
        try {
            for (int i = 0; i < numHilos; i += 1) {
                hilos[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return resultado.getNum();

    }
    
}
