public class Asiento {
    //atributos
    private String código;
    private String fila;
    private int número;
    private EstadoAsiento estadoAsiento;

    //constructor
    public Asiento(String código, String fila, int número, EstadoAsiento estadoAsiento) {
        this.código = código;
        this.fila = fila;
        this.número = número;
        this.estadoAsiento = estadoAsiento;
    }

    //get y set
    public String getCódigo() {
        return código;
    }

    public void setCódigo(String código) {
        this.código = código;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getNúmero() {
        return número;
    }

    public void setNúmero(int número) {
        this.número = número;
    }

    public EstadoAsiento getEstadoAsiento() {
        return estadoAsiento;
    }

    public void setEstadoAsiento(EstadoAsiento estadoAsiento) {
        this.estadoAsiento = estadoAsiento;
    }

    //toString

    @Override
    public String toString() {
        return "Asiento " + código +
                "\nFila: " + fila +
                "\nNúmero: " + número +
                "\nEstado del asiento: " + estadoAsiento+"\n";
    }
}
