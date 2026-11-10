import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CineTest {

    Cine cine = new Cine("CINEMA UQ");

    @Test
    void noDebeRegistrarPeliculasConCodigoDuplicado() {

        cine.registrarPelicula(
                "9001", "Princesa Sofìa", "Ciencia ficcion",
                180, Clasificacion.TODOS, EstadoPelicula.DISPONIBLE
        );

        assertThrows(IllegalArgumentException.class, () -> {
            cine.registrarPelicula(
                    "9001", "Titanic", "Romance",
                    195, Clasificacion.TODOS, EstadoPelicula.DISPONIBLE
            );
        });

    }

    //no debe haber salas con mismo còdigo


    @Test
    void noDebeRegistrarSalasConCodigoDuplicado() {

        cine.registrarSala(
                "8001", "Sala 1", 50, EstadoSala.DISPONIBLE
        );

        assertThrows(IllegalArgumentException.class, () -> {
            cine.registrarSala(
                    "8001", "Sala 2", 40, EstadoSala.DISPONIBLE
            );
        });

    }

    // no debe registrar un cleinte con el mismo código
    @Test
    void noDebeRegistrarClientesConIdentificacionDuplicada() {

        cine.registrarCliente(
                "Mariam", "123", TipoCliente.GENERAL
        );

        assertThrows(IllegalArgumentException.class, () -> {
            cine.registrarCliente(
                    "Navier", "123", TipoCliente.ESTUDIANTE
            );
        });
    }




    //no debe cancelar un venta que ya este cancelada
    @Test
    void noDebeCancelarUnaVentaYaCancelada() {

        cine.registrarPelicula(
                "9001", "Titanic", "Romance",
                180, Clasificacion.TODOS, EstadoPelicula.DISPONIBLE
        );

        cine.registrarSala(
                "8001", "Sala 1", 56, EstadoSala.DISPONIBLE
        );

        cine.programarFuncion(
                "5001", "9001", "8001",
                LocalDate.now(), "18:00", 20000
        );

        Cliente cliente = new Cliente(
                "Miriam", "123", TipoCliente.GENERAL
        );

        cine.registrarVentaEntrada(
                "V001", "5001", "A1", cliente
        );

        cine.cancelarVenta("V001");

        assertThrows(IllegalArgumentException.class, () -> {
            cine.cancelarVenta("V001");
        });
    }


    //cancelar una venta inexistente

    @Test
    void noDebeCancelarVentaInexistente() {
        assertThrows(IllegalArgumentException.class, () -> {
            cine.cancelarVenta("V001");
        });

    }

    // NO DEBE VENDER ENTRADA FUNCION INEXISTENTE

    @Test
    void noDebeVenderEntradaParaFuncionInexistente() {
        Cliente cliente = new Cliente(
                "123", "Miriam", TipoCliente.GENERAL
        );


        assertThrows(IllegalArgumentException.class, () -> {
            cine.registrarVentaEntrada(
                    "V001", "5001", "A1", cliente);
        });

    }

    @Test

    void noDebeProgramarFuncionesConCodigoDuplicado() {

        cine.registrarPelicula(
                "9001", "Titanic", "Romance", 180, Clasificacion.TODOS, EstadoPelicula.DISPONIBLE
        );

        cine.registrarSala(
                "8001", "Sala 1", 50, EstadoSala.DISPONIBLE
        );

        cine.programarFuncion(
                "5001", "9001", "8001", LocalDate.now(), "18:00", 20000
        );
    }

    // no debe programar funcion si la pelicula    no existe
    @Test
    void noDebeProgramarFuncionConPeliculaInexistente() {

        cine.registrarSala(
                "7071", "Sala 1", 50, EstadoSala.DISPONIBLE
        );

        assertThrows(IllegalArgumentException.class, () -> {
            cine.programarFuncion(
                    "5001", "9001", "8001",
                    LocalDate.of(2026, 12, 2), "10:00 AM", 5000
            );
        });
    }

}




