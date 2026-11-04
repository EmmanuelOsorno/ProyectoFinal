import java.time.LocalDate;
import java.time.LocalDateTime;

public class Venta {
    //atributos
    private String código;
    private Cliente cliente;
    private Funcion funcion;
    private Asiento asiento;
    //LocalDateTime para guardar fecha y hora
    private LocalDateTime fechaHora;
    private double valorPagado;
    private EstadoVenta estadoVenta;

    //constructor
    public Venta(String código, Cliente cliente, Funcion funcion, Asiento asiento, LocalDateTime fechaHora, double valorPagado, EstadoVenta estadoVenta) {
        this.código = código;
        this.cliente = cliente;
        this.funcion = funcion;
        this.asiento = asiento;
        //LocalDateTime.now agregara la fcha y hora al momento de registrar l aventa
        this.fechaHora = LocalDateTime.now();
        this.valorPagado = valorPagado;
        this.estadoVenta = estadoVenta;
    }

    //get y set
    public String getCódigo() {
        return código;
    }

    public void setCódigo(String código) {
        this.código = código;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(double valorPagado) {
        this.valorPagado = valorPagado;
    }

    public EstadoVenta getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(EstadoVenta estadoVenta) {
        this.estadoVenta = estadoVenta;
    }
}
