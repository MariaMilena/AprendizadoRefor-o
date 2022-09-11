public class Cell {
    public int r;
    public int valor;
    public double valorUp;
    public double valorDown;
    public double valorLeft;
    public double valorRight;

    public Cell(int r, int valor, double valorUp, double valorDown, double valorLeft, double valorRight) {
        this.r = r;
        this.valor = valor;
        this.valorUp = valorUp;
        this.valorDown = valorDown;
        this.valorLeft = valorLeft;
        this.valorRight = valorRight;
    }
}
