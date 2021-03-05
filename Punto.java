
import java.util.Random;

public class Punto {

    private final double x;
    private final double y;

    public Punto(Random generator) {
        this.x = generator.nextDouble();
        this.y = generator.nextDouble();
    }

    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }

}
