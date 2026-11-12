public class Asiento {
    //atributos
    private String códigoAsiento;
    private String fila;
    private int número;
    private EstadoAsiento estadoAsiento;

    //constructor
    public Asiento(String códigoAsiento, String fila, int número, EstadoAsiento estadoAsiento) {
        this.códigoAsiento = códigoAsiento;
        this.fila = fila;
        this.número = número;
        this.estadoAsiento = estadoAsiento;


    }

    //get y set


    public String getCódigoAsiento() {
        return códigoAsiento;
    }

    public void setCódigoAsiento(String códigoAsiento) {
        this.códigoAsiento = códigoAsiento;
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


    //Metodos para cambiar de estado
    //ocupar

    public void ocupar() {

        if (estadoAsiento == EstadoAsiento.OCUPADO) {
            throw new IllegalArgumentException("El asiento ya está ocupado");
        }

        estadoAsiento = EstadoAsiento.OCUPADO;
    }

    //liberar()

    public void liberar() {

        estadoAsiento = EstadoAsiento.DISPONIBLE;
    }



    @Override
    public String toString() {
        return "Asiento: " +
                "\nCódigoAsiento= " + códigoAsiento + '\'' +
                "\nFila= " + fila + '\'' +
                "\nNúmero= " + número +
                "\nEstadoAsiento=  " + estadoAsiento;
    }


}
