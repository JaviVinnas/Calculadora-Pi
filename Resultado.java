public class Resultado {
    private long num;

    public Resultado(){
        this.num = 0L;
    }

    public synchronized void add(long ptosValidos){
        this.num += ptosValidos;
    }

    public long getNum() {
        return num;
    }
}
