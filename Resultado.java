public class Resultado {
    private long num;

    public Resultado(){
        this.num = 0L;
    }

    public synchronized void encontrado(){
        this.num += 1;
    }

    public long getNum() {
        return num;
    }
}
