import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion {


        //menu (provicional)
        static  void main() {
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("=====CINEMAUQ=====");
                System.out.println();

                System.out.println("===PELICULA===");
                System.out.println("1. Registrar Película");
                System.out.println("2. Consultar Peliculas");
                System.out.println("3. Actualizar Pelicula");
                System.out.println("4. Desabilitar Pelicula");

                System.out.println(". Registrar Sala");
                System.out.println(". Ver Películas registradas");
                System.out.println("0. Salir");
                System.out.print("Elija una opción: ");
                opcion=scanner.nextInt();

                switch (opcion){
                    case 1:
                        System.out.println("=====Registrar Pelicula=====");
                        System.out.println("Codigo de la pelicula: ");
                        String codigoP=scanner.nextLine();
                        scanner.nextLine();
                        System.out.println("Nombre de la pelicula: ");
                        String nombreP=scanner.nextLine();
                        System.out.println("Genero de la pelicula: ");
                        String generoP=scanner.nextLine();
                        System.out.println("Duracion de la pelicula (minutos): ");
                        int duracionP=scanner.nextInt();
                        System.out.println("1. Todos\n2. Mayores de 7 años\n3. Mayores de 12 años\n4. Mayores de 15 años\n5. Mayores de 18 años\nClasificacio de la pelicula: ");
                        int clasificacionP=scanner.nextInt();
                        //la iniciamos como para todos
                        Clasificacion clasificacion=Clasificacion.TODOS;
                        switch (clasificacionP){
                            case 1: clasificacion=Clasificacion.TODOS;
                            break;
                            case 2:clasificacion=Clasificacion.MAYORES_7;
                            break;
                            case 3: clasificacion=Clasificacion.MAYORES_12;
                            break;
                            case 4:clasificacion=Clasificacion.MAYORES_15;
                            break;
                            case 5:clasificacion=Clasificacion.MAYORES_18;
                            break;
                        }
                        System.out.println("1. Disponible\n2. No disponible\nEstado de la pelicula: ");
                        int estadoP=scanner.nextInt();
                        //la iniciamos como disponible
                        EstadoPelicula estadoPelicula=EstadoPelicula.DISPONIBLE;
                        switch (estadoP){
                            case 1:estadoPelicula=EstadoPelicula.DISPONIBLE;
                            break;
                            case 2:estadoPelicula=EstadoPelicula.NO_DISPONIBLE;
                            break;
                        }
                        Pelicula pelicula=new Pelicula(codigoP,nombreP,generoP,duracionP,clasificacion,estadoPelicula);

                    case 2:

                }
            }while (opcion!=0);
            scanner.close();

        }

}
