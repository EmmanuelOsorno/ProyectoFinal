public enum TipoCliente {

    GENERAL(30000),
    ESTUDIANTE(25000),
    NIÑO(15000),
    ADULTO_MAYOR(15000);

    private final double valor;

    TipoCliente(double valor){
        this.valor=valor;
    }

    public double getValor() {
        return valor;
    }
}
