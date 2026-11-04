import java.util.ArrayList;

public class Sala {
    //atributos
    private String código;
    private String nombre;
    private int capacidad;
    private EstadoSala estadoSala;
    private ArrayList<Asiento>ListaAsientos;

    //constructor
    public Sala(String código, String nombre, int capacidad, EstadoSala estadoSala ) {
        this.código = código;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estadoSala = estadoSala;

        this.ListaAsientos = new ArrayList<>();
    }

    //get y set
    public String getCódigo() {
        return código;
    }

    public void setCódigo(String código) {
        this.código = código;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public EstadoSala getEstadoSala() {
        return estadoSala;
    }

    public void setEstadoSala(EstadoSala estadoSala) {
        this.estadoSala = estadoSala;
    }

    public ArrayList<Asiento> getListaAsientos() {
        return ListaAsientos;
    }

    public void setListaAsientos(ArrayList<Asiento> listaAsientos) {
        ListaAsientos = listaAsientos;
    }

    //toString

    @Override
    public String toString() {
        return "Sala{" +
                "código='" + código + '\'' +
                ", nombre='" + nombre + '\'' +
                ", capacidad=" + capacidad +
                ", estadoSala=" + estadoSala +
                ", ListaAsientos=" + ListaAsientos +
                '}';
    }
}
