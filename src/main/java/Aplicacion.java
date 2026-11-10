import java.time.LocalDate;
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

                System.out.println("---------PELICULA------");
                System.out.println("1. Registrar Película");
                System.out.println("2. Consultar Peliculas");
                System.out.println("3. Actualizar Pelicula");
                System.out.println("4. Desabilitar Pelicula");
                System.out.println("-----SALA-----");
                System.out.println("5. Registrar Sala");
                System.out.println("6. Consultar Salas");
                System.out.println("7. Mostrar asientos de la sala");
                System.out.println("8. Actualizar Sala");
                System.out.println("9. Desabilitar Sala");
                System.out.println("------Clientes-------");
                System.out.println("10. Registrar cliente");
                System.out.println("11. Consultar cliente");
                System.out.println("-------Función-----");
                System.out.println("12. Programar función");
                System.out.println("13. Consultar función");
                System.out.println("14. Consultar función por fecha");
                System.out.println("15. Consultar asientos ocupados por funcion");
                System.out.println("----------venta---------");
                System.out.println("16. Registrar venta de una entrada");
                System.out.println("17. Consultar venta");
                System.out.println("18. Cancelar venta");
                System.out.println("--------------Reportes------------");
                System.out.println("19. Total de ventas de entradas");
                System.out.println("20. Total de  ingresos");
                System.out.println("21. Pelicula con mayor entradas");
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
                        System.out.println("=====Registrar Sala=====");
                        //limpiar buffer del menu
                        scanner.nextLine();
                        System.out.println("Codigo de la sala: ");
                        String codigoS=scanner.nextLine();
                        System.out.println("Nombre de la sala: ");
                        String nombreS=scanner.nextLine();
                        System.out.println("Capacidad de personas de la sala: ");
                        int capacidadS=scanner.nextInt();
                        System.out.println("1. Disponible\n2. Fuera de servicio\nEstado de la sala: ");
                        int estadoS=scanner.nextInt();
                        //la iniciamos como disponible
                        EstadoSala estadoSala =EstadoSala.DISPONIBLE;
                        switch (estadoS){
                            case 1:estadoSala=EstadoSala.DISPONIBLE;
                                break;
                            case 2:estadoSala=EstadoSala.FUERA_DE_SERVICIO;
                                break;
                        }
                        //los asientos se crean automaticamente al registrar la sala

                        cine.registrarSala(codigoS,nombreS,capacidadS,estadoSala);
                        System.out.println("Sala registrada crrectamente");
                        break;

                    case 6:
                        System.out.println("=====Salas=====");
                        for(Sala ListaSalas: cine.getListaSalas()){
                            System.out.println(ListaSalas);
                        }
                        break;

                    case 7:
                        System.out.println("=====Asientos de Sala=====");
                        //limpiar buffer del menu
                        scanner.nextLine();
                        System.out.println("Codigo de la sala: ");
                        String codigoParaAsientos=scanner.nextLine();

                        cine.mostrarAsientos(codigoParaAsientos);
                        break;

                    case 8:
                        System.out.println("=====Actualizar Sala=====");
                        //limpiar buffer
                        scanner.nextLine();
                        System.out.println("Codigo de la sala a actualizar: ");
                        String codigoActualizarS=scanner.nextLine();

                        System.out.println("Nuevo nombre: ");
                        String nombreSalaA=scanner.nextLine();
                        System.out.println("Nueva capacidad: ");
                        int capacidadSalaA=scanner.nextInt();
                        System.out.println("\1. Disponible\n2. Fuera de servicio\nNuevo estado de la sala: ");
                        int estadoSalaA=scanner.nextInt();
                        EstadoSala estadoSalaActualizar=EstadoSala.DISPONIBLE;
                        switch (estadoSalaA){
                            case 1:estadoSalaActualizar=EstadoSala.DISPONIBLE;
                            break;
                            case 2:estadoSalaActualizar=EstadoSala.FUERA_DE_SERVICIO;
                            break;
                        }

                        Sala salaActualizada=new Sala(codigoActualizarS,nombreSalaA,capacidadSalaA,estadoSalaActualizar);
                        if(cine.actualizarSala(codigoActualizarS,salaActualizada)){
                            System.out.println("Sala actualizada correctamente");
                        }else{
                            System.out.println("Sala no encontrada");
                        }
                        break;

                    case 9:
                        System.out.println("=====Desabilitar Sala=====");
                        //limpiar buffer
                        scanner.nextLine();
                        System.out.println("Codigo de la sala a desabilitar: ");
                        String codigoSalaDesabilitar=scanner.nextLine();

                        if(cine.desabilitarSala(codigoSalaDesabilitar)){
                            System.out.println("Sala desabilitada correctamente");
                        }else{
                            System.out.println("Sala no enontrada");
                        }
                        break;


                    case 10:

                        scanner.nextLine();

                        System.out.println(" Ingrese el nombre del cliente: ");
                        String nombreCliente = scanner.nextLine();

                        System.out.println("Ingrese el documento del cliente:");
                        String identificacion = scanner.nextLine();

                        System.out.println("Seleccione el tipo de cliente: ");
                        System.out.println("1. GENERAL");
                        System.out.println("2. ESTUDIANTE");
                        System.out.println("3. NIÑO");
                        System.out.println("4. ADULTO MAYOR");

                        int tipoC = scanner.nextInt();
                        TipoCliente tipoCliente = null;

                        switch (tipoC) {
                            case 1:
                                tipoCliente = TipoCliente.GENERAL;
                                break;
                            case 2:
                                tipoCliente = TipoCliente.ESTUDIANTE;
                                break;
                            case 3:
                                tipoCliente = TipoCliente.NIÑO;
                                break;
                            case 4:
                                tipoCliente = TipoCliente.ADULTO_MAYOR;
                                break;
                            default:
                                System.out.println("El Tipo de cliente no  es válido");
                        }
                        //Se usa try y catch para poder incluir las excepciones en la clase cine.

                        if (tipoCliente != null) {
                            try {
                                cine.registrarCliente(nombreCliente, identificacion, tipoCliente);
                                System.out.println("Cliente  fue registrado correctamente");
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;


                    case 11:
                        cine.consultarClientes();
                        break;

                    case 12:
                        scanner.nextLine();

                        System.out.println("Ingrese el código de la función:");
                        String codigoFuncion = scanner.nextLine();

                        System.out.println("Ingrese el código de la película:");
                        String codigoPelicula = scanner.nextLine();

                        System.out.println("Ingrese el código de la sala:");
                        String codigoSala = scanner.nextLine();

                        System.out.println("Ingrese la fecha (AAAA-MM-DD):");
                        LocalDate fecha = LocalDate.parse(scanner.nextLine());

                        System.out.println("Ingrese la hora (HH:MM):");
                        String hora = scanner.nextLine();

                        System.out.println("Ingrese el valor base de la función:");
                        double valorBase = scanner.nextDouble();

                        try {
                            cine.programarFuncion(
                                    codigoFuncion,
                                    codigoPelicula,
                                    codigoSala,
                                    fecha,
                                    hora,
                                    valorBase
                            );

                            System.out.println("Función programada correctamente");

                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 13:
                        cine.consultarFunciones();
                        break;

                    case 14:
                        scanner.nextLine();

                        System.out.println("Ingrese la fecha (AAAA-MM-DD):");
                        LocalDate fechaConsulta = LocalDate.parse(scanner.nextLine());

                        cine.consultarFuncionesPorFecha(fechaConsulta);

                        break;

                    case 15:
                        scanner.nextLine();

                        System.out.println("Ingrese el código de la función:");
                        String codigoConsulta = scanner.nextLine();

                        try {
                            cine.consultarOcupacionFuncion(codigoConsulta);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }

                        break;

                    case 16:
                        scanner.nextLine();

                        System.out.println("Ingrese el código de la entrada:");
                        String codigoEntrada = scanner.nextLine();

                        System.out.println("Ingrese el código de la función:");
                        String codigoFuncionVenta = scanner.nextLine();

                        System.out.println("Ingrese el código del asiento:");
                        String codigoAsiento = scanner.nextLine();

                        System.out.println("Ingrese la identificación del cliente:");
                        String identificacionCliente = scanner.nextLine();

                        Cliente clienteEncontrado = null;

                        for (Cliente cliente : cine.getListaClientes()) {
                            if (cliente.getIdentificacion().equalsIgnoreCase(identificacionCliente)) {
                                clienteEncontrado = cliente;
                                break;
                            }
                        }

                        if (clienteEncontrado == null) {
                            System.out.println("No existe un cliente con esa identificación");
                        } else {
                            try {
                                cine.registrarVentaEntrada(codigoEntrada, codigoFuncionVenta, codigoAsiento, clienteEncontrado
                                );
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        break;

                    case 17:
                        cine.consultarVentas();
                        break;
                    case 18:
                        scanner.nextLine();

                        System.out.println("Ingrese el código de la venta que desea cancelar:");
                        String codigoVenta = scanner.nextLine();

                        try {
                            cine.cancelarVenta(codigoVenta);
                            System.out.println("Venta cancelada correctamente");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }

                        break;





                }
            }while (opcion!=0);
            scanner.close();

        }

}
