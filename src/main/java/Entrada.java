import java.time.LocalDateTime;

public class Entrada {
    //atributos
    private String codigo;
    private Funcion funcion;
    private Cliente cliente;
    private Asiento asiento;
    private LocalDateTime fechaHoraEntrada;
    private double valorFinal;
    private TipoCliente tipoEntrada;

    //constructor
    public Entrada(String codigo, Funcion funcion, Cliente cliente, Asiento asiento, LocalDateTime fechaHoraEntrada, double valorFinal, TipoCliente tipoEntrada) {
        this.codigo = codigo;
        this.funcion = funcion;
        this.cliente = cliente;
        this.asiento = asiento;
        this.fechaHoraEntrada = fechaHoraEntrada;
        this.valorFinal = valorFinal;
        this.tipoEntrada = tipoEntrada;
    }

    //get y set

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public LocalDateTime getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }

    public void setFechaHoraEntrada(LocalDateTime fechaHoraEntrada) {
        this.fechaHoraEntrada = fechaHoraEntrada;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public TipoCliente getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(TipoCliente tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    //toString

    @Override
    public String toString() {
        return "Entrada{" +
                "codigo='" + codigo + '\'' +
                ", funcion=" + funcion +
                ", cliente=" + cliente +
                ", asiento=" + asiento +
                ", fechaHoraEntrada=" + fechaHoraEntrada +
                ", valorFinal=" + valorFinal +
                ", tipoEntrada=" + tipoEntrada +
                '}';
    }
}
