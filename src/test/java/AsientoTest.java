import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsientoTest {

    Asiento asiento = new Asiento ("A1","D",28,EstadoAsiento.DISPONIBLE);

    //Pruebas
    @Test
    void debeocuparAsiento() {
        asiento.ocupar();

        assertEquals(EstadoAsiento.OCUPADO, asiento.getEstadoAsiento());
    }

    @Test
    void DebeliberarAsientoOcupado() {
        asiento.ocupar();
        asiento.liberar();

        assertEquals(EstadoAsiento.DISPONIBLE,asiento.getEstadoAsiento());
    }

    @Test
    void NoDebePermitirOcuparAsientoOcupado() {
        asiento.ocupar();

        assertThrows(IllegalArgumentException.class, () -> {
            asiento.ocupar();
        });
    }
}