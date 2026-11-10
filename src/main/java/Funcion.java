import java.time.LocalDate;

public class Funcion {
    //atributos
    private String código;
    private Pelicula pelicula;
    private Sala sala;
    private LocalDate fecha;
    private String hora;
    private double valorBase;
    private EstadoFuncion estadoFuncion;

    //constructor
    public Funcion(String código, Pelicula pelicula, Sala sala, LocalDate fecha, String hora, double valorBase, EstadoFuncion estadoFuncion) {
        this.código = código;
        this.pelicula = pelicula;
        this.sala = sala;
        this.fecha = fecha;
        this.hora = hora;
        this.valorBase = valorBase;
        this.estadoFuncion = estadoFuncion;


        //que no sea nula la sala
        if (sala == null) {
            throw new IllegalArgumentException("La sala no puede ser nula");
        }
        // Validar que la sala esté disponible
        if (estadoFuncion == EstadoFuncion.PROGRAMADA &&
                sala.getEstadoSala() == EstadoSala.FUERA_DE_SERVICIO) {

            throw new IllegalArgumentException(
                    "No se puede programar una función en una sala fuera de servicio"
            );
        }


    }

    //get y set
    public String getCódigo() {
        return código;
    }

    public void setCódigo(String código) {
        this.código = código;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public EstadoFuncion getEstadoFuncion() {
        return estadoFuncion;
    }

    public void setEstadoFuncion(EstadoFuncion estadoFuncion) {
        this.estadoFuncion = estadoFuncion;
    }

    @Override
    public String toString() {
        return "Funcion: " +
                "\nCódigo= " + código +
                "\nPelicula= " + pelicula +
                "\nSala= " + sala +
                "\nFecha= " + fecha +
                "\nHora= " + hora +
                "\nValorBase= " + valorBase +
                "\nEstadoFuncion= " + estadoFuncion;
    }
}
