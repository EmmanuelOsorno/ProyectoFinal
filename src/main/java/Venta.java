import java.time.LocalDate;
import java.time.LocalDateTime;

public class Venta {
    //atributos
    private String codigo;
    private Cliente cliente;
    private Funcion funcion;
    private Asiento asiento;
    //LocalDateTime para guardar fecha y hora
    private LocalDateTime fechaHora;
    private double valorPagado;
    private EstadoVenta estadoVenta;
    private TipoCliente tipoCliente;

    //constructor
    public Venta(String codigo, Cliente cliente, Funcion funcion, Asiento asiento, LocalDateTime fechaHora,double valorPagado, EstadoVenta estadoVenta, TipoCliente tipoCliente) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.funcion = funcion;
        this.asiento = asiento;
        //LocalDateTime.now agregara la fcha y hora al momento de registrar la venta
        this.fechaHora = LocalDateTime.now();
        this.valorPagado = valorPagado;
        this.estadoVenta = estadoVenta;
        this.tipoCliente = tipoCliente;
    }


    //get y set


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }


    //get y set

    @Override
    public String toString() {
        return "Venta: " +
                "Código="  + codigo +
                "\nCliente=" + cliente +
                "\nFuncion=" + funcion +
                "\nAsiento="  + asiento +
                "\nFechaHora=" + fechaHora +
                "\nValorPagado= " + valorPagado +
                "\nEstadoVenta= " + estadoVenta +
                "\n TipoCliente= " + tipoCliente ;
    }

    //calcular valor pagado
    public double calcularValorPagado() {
        return funcion.getValorBase() + tipoCliente.getValor();
    }


}
