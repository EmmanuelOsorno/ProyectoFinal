import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class FuncionTest {

    Pelicula pelicula= new Pelicula("1090","Barbie","Infantil",120,Clasificacion.TODOS,EstadoPelicula.DISPONIBLE);
    Sala sala= new Sala("789"," Sala 2",80,EstadoSala.DISPONIBLE);
    Funcion funcion= new Funcion("5007",pelicula ,sala, LocalDate.of(2026, 12, 2),"10:00 AM",5000,EstadoFuncion.PROGRAMADA);

    @Test
    void debeCrearFuncionCorrectamente() {
        assertNotNull(funcion);
    }

    
    
    //no se debe crear una funcion si no hay sala

    @Test
    void noDebeCrearFuncionSinSala() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Funcion(
                    "5007", pelicula,null,
                    LocalDate.of(2026, 12, 2),
                    "10:00 AM", 5000,
                    EstadoFuncion.PROGRAMADA
            );
        });

    }
    
    //no se debe programar si la sala esta fuera de servicio


    @Test
    void noDebeProgramarFuncionEnSalaFueraDeServicio() {
        Sala salaFueraServicio = new Sala(
                "789"," Sala 2",80, EstadoSala.FUERA_DE_SERVICIO
        );

        assertThrows(IllegalArgumentException.class, () -> {
            new Funcion(
                    "5007", pelicula, salaFueraServicio,
                    LocalDate.of(2026, 12, 2),
                    "10:00 PM", 5000,
                    EstadoFuncion.PROGRAMADA
            );
        });

    }




}