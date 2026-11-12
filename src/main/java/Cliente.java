public class Cliente {
    //atributos
    private String nombre;
    private String identificacion;
    private TipoCliente tipoCliente;

    //constructor
    public Cliente(String nombre, String identificacion, TipoCliente tipoCliente) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.tipoCliente = tipoCliente;
    }

    //get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "Cliente: " +
                "\nNombre= " + nombre +
                "\nIdentificacion= " + identificacion +
                "\nTipoCliente= " + tipoCliente;
    }
}
