import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion {


        //menu (provicional)
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            Cine cine=new Cine("CinemaUQ");
            int opcion;

            do {
                System.out.println("=====CINEMAUQ=====");
                System.out.println();

                System.out.println("-----PELICULA-----");
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
                        //limpiar buffer del menu
                        scanner.nextLine();
                        System.out.println("Codigo de la pelicula: ");
                        String codigoP=scanner.nextLine();
                        System.out.println("Nombre de la pelicula: ");
                        String nombreP=scanner.nextLine();
                        System.out.println("Genero de la pelicula: ");
                        String generoP=scanner.nextLine();
                        System.out.println("Duracion de la pelicula (minutos): ");
                        double duracionP=scanner.nextDouble();
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
                        cine.registrarPelicula(codigoP,nombreP,generoP,duracionP,clasificacion,estadoPelicula);
                        System.out.println("Pelicula registrada correctamente");
                        break;

                    case 2:
                        System.out.println("=====Peliculas=====");
                        for(Pelicula ListaPeliculas: cine.getListaPeliculas()){
                            System.out.println(ListaPeliculas);
                        }
                        break;

                    case 3:
                        System.out.println("=====Actualizar Pelicula=====");
                        //limpiar buffer
                        scanner.nextLine();
                        System.out.println("Codigo de la pelicula a actualizar: ");
                        String codigoActualizar=scanner.nextLine();

                        System.out.println("Nuevo nombre: ");
                        String nombreA=scanner.nextLine();
                        System.out.println("Nuevo genero: ");
                        String generoA=scanner.nextLine();
                        System.out.println("Nueva duracion: ");
                        double duracionA=scanner.nextDouble();
                        System.out.println("Nueva clasificacion: ");
                        System.out.println("1. Todos\n2. Mayores de 7 años\n3. Mayores de 12 años\n4. Mayores de 15 años\n5. Mayores de 18 años\nNuevo estado: ");
                        int clasificacionActualizada=scanner.nextInt();
                        //la iniciamos como para todos
                        Clasificacion clasificacion1=Clasificacion.TODOS;
                        switch (clasificacionActualizada){
                            case 1: clasificacion1=Clasificacion.TODOS;
                                break;
                            case 2:clasificacion1=Clasificacion.MAYORES_7;
                                break;
                            case 3: clasificacion1=Clasificacion.MAYORES_12;
                                break;
                            case 4:clasificacion1=Clasificacion.MAYORES_15;
                                break;
                            case 5:clasificacion1=Clasificacion.MAYORES_18;
                                break;
                        }
                        System.out.println("1. Disponible\n2. No disponible\nNuevo estado: ");
                        int estadoActualizado=scanner.nextInt();
                        //la iniciamos como disponible
                        EstadoPelicula estadoPelicula1=EstadoPelicula.DISPONIBLE;
                        switch (estadoActualizado){
                            case 1:estadoPelicula1=EstadoPelicula.DISPONIBLE;
                                break;
                            case 2:estadoPelicula1=EstadoPelicula.NO_DISPONIBLE;
                                break;
                        }

                        Pelicula peliculaActualizada=new Pelicula(codigoActualizar,nombreA,generoA,duracionA,clasificacion1,estadoPelicula1);
                        if(cine.actualizarPelicula(codigoActualizar,peliculaActualizada)){
                            System.out.println("Pelicula actualizada correctamente");
                        }else{
                            System.out.println("Pelicula no encontrada");
                        }
                        break;

                    case 4:
                        System.out.println("=====Desabilitar Pelicula=====");
                        //limpiar buffer
                        scanner.nextLine();
                        System.out.println("Codigo de la pelicula a desabilitar: ");
                        String codigoDesabilitar=scanner.nextLine();

                        if(cine.desabilitarPelicula(codigoDesabilitar)){
                            System.out.println("Pelicula desabilitada correctamente");
                        }else{
                            System.out.println("Pelicula no encontrada");
                        }
                        break;

                    case 5:


                }
            }while (opcion!=0);
            scanner.close();

        }

}
