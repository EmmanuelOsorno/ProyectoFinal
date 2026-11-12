import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeliculaTest {

    Pelicula pelicula= new Pelicula("1090","Barbie","Infantil",120,Clasificacion.TODOS,EstadoPelicula.DISPONIBLE);

    //PARA QUE SE CREE CORRECTAMENTE

    @Test
    void DebeCrearCorrectamente() {
        assertNotNull(pelicula);
    }
}