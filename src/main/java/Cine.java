import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Cine {
    //atributo
    private String nombre;

    //listas para los componentes
    private ArrayList<Pelicula> ListaPeliculas;
    private ArrayList<Sala> ListaSalas;
    private ArrayList<Cliente> ListaClientes;
    private ArrayList<Funcion> ListaFunciones;
    private ArrayList<Venta> ListaVentas;

    //constructor
    public Cine(String nombre) {
        this.nombre=nombre;

        this.ListaPeliculas = new ArrayList<>();
        this.ListaSalas = new ArrayList<>();
        this.ListaClientes = new ArrayList<>();
        this.ListaFunciones = new ArrayList<>();
        this.ListaVentas = new ArrayList<>();
    }

    //get y set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Pelicula> getListaPeliculas() {
        return ListaPeliculas;
    }

    public void setListaPeliculas(ArrayList<Pelicula> listaPeliculas) {
        ListaPeliculas = listaPeliculas;
    }

    public ArrayList<Sala> getListaSalas() {
        return ListaSalas;
    }

    public void setListaSalas(ArrayList<Sala> listaSalas) {
        ListaSalas = listaSalas;
    }

    public ArrayList<Cliente> getListaClientes() {
        return ListaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        ListaClientes = listaClientes;
    }

    public ArrayList<Funcion> getListaFunciones() {
        return ListaFunciones;
    }

    public void setListaFunciones(ArrayList<Funcion> listaFunciones) {
        ListaFunciones = listaFunciones;
    }

    public ArrayList<Venta> getListaVentas() {
        return ListaVentas;
    }

    public void setListaVentas(ArrayList<Venta> listaVentas) {
        ListaVentas = listaVentas;
    }


    //==================METODOS=======================

    //METODOS PELICULA
    public void registrarPelicula(String codigo, String nombre, String genero, double duracion, Clasificacion clasificacion, EstadoPelicula estadoPelicula) {
        //se verifica que no haya otra pelicula con ese mismo còdigo"


        for (Pelicula pelicula : ListaPeliculas) {
            if (pelicula.getCodigo().equalsIgnoreCase(codigo)) {
                throw new IllegalArgumentException(
                        "¡Ya existe una pelicula con ese codigo!"
                );
            }
        }

        Pelicula nuevaPelicula = new Pelicula(
                codigo, nombre, genero, duracion, clasificacion, estadoPelicula
        );

        ListaPeliculas.add(nuevaPelicula);
    }

    //consultar

    public void consultarPeliculas() {
        //si no hay peliculas
        if (ListaPeliculas.size() == 0) {
            System.out.println(" ¡No hay peliculas registradas!");
            return;
        }
        for (int a = 0; a < ListaPeliculas.size(); a++) {
            Pelicula pelicula = ListaPeliculas.get(a);
            System.out.println(pelicula.toString());
        }
    }




    public boolean actualizarPelicula(String codigo, Pelicula Actualizada) {
        boolean actualizado = false;
        for (Pelicula pelicula : ListaPeliculas) {
            if (pelicula.getCodigo().equalsIgnoreCase(codigo)) {
                pelicula.setNombre(Actualizada.getNombre());
                pelicula.setGenero(Actualizada.getGenero());
                pelicula.setDuracion(Actualizada.getDuracion());
                pelicula.setClasificacion(Actualizada.getClasificacion());
                pelicula.setEstadoPelicula(Actualizada.getEstadoPelicula());
                actualizado = true;
                break;
            }
        }
        return actualizado;
    }

    //desabilitar pelicula, es decir, cambiar su estado a NO_DISPONIBLE
    public boolean desabilitarPelicula(String codigo) {
        boolean desabilitada = false;
        for (Pelicula pelicula : ListaPeliculas) {
            if (pelicula.getCodigo().equalsIgnoreCase(codigo)) {
                pelicula.setEstadoPelicula(EstadoPelicula.NO_DISPONIBLE);
                desabilitada = true;
                break;
            }
        }
        return desabilitada;
    }

    //METODOS SALA
    public void registrarSala(String codigo, String nombre, int capacidad, EstadoSala estadoSala) {

        //verificar que no haya otra sala con ese mismo còdigo

        for (Sala sala : ListaSalas) {
            if (sala.getCódigo().equalsIgnoreCase(codigo)) {
                throw new IllegalArgumentException(
                        "¡Ya existe una sala con ese codigo!"
                );
            }
        }

        Sala nuevaSala = new Sala(codigo, nombre, capacidad, estadoSala);

        //generar los asientos al registrar la sala
        //poner una cantidad predeterminada de asientos en la fila
        int asientosFila = 10;
        int cantidadFilas = (int) Math.ceil((double) capacidad / asientosFila);// se calcula cuantas filas de asientos se necesita segun la capacidad de la sala
        int Asientos = 0;
        for (int a = 0; a < cantidadFilas; a++) {
            char letra = (char) ('A' + a);
            String fila = String.valueOf(letra);

            for (int numero = 1; numero <= asientosFila && Asientos < capacidad; numero++) {
                String codigoAsiento = fila + numero;
                Asiento nuevoAsiento = new Asiento(codigoAsiento, fila, numero, EstadoAsiento.DISPONIBLE);
                nuevaSala.getListaAsientos().add(nuevoAsiento);
                Asientos++;
            }
        }
        ListaSalas.add(nuevaSala);
    }
    //consultar salas

    public void consultarSalas() {
        //si no hay salas
        if (ListaSalas.size() == 0) {
            System.out.println("¡No hay salas registradas!");
            return;
        }
        for (int a = 0; a < ListaSalas.size(); a++) {
            Sala sala = ListaSalas.get(a);
            System.out.println(sala.toString());
        }
    }

    //mostrar los asientos de la sala
    public void mostrarAsientos(String  codigo){
        Sala asientosSala=null;

        //buscar la sala
        for(Sala sala:ListaSalas){
            if(sala.getCódigo().equalsIgnoreCase(codigo)){
                asientosSala=sala;
                break;
            }
        }
        //si la sala no existe
        if(asientosSala==null){
            System.out.println("Esta sala no existe");
            return;
        }
        System.out.println("Asientos: "+asientosSala.getNombre());
        String fila="";

        for(Asiento asiento:asientosSala.getListaAsientos()){
            //para ordenar como salen los asientos
            if(!asiento.getFila().equals(fila)){
                if(!fila.isEmpty()){
                    System.out.println();
                }
                fila=asiento.getFila();
                System.out.println("Fila: "+fila+":");
            }
            System.out.println(asiento.getCódigoAsiento( )+ ":" + asiento.getEstadoAsiento());
        }
    }

    public boolean actualizarSala(String codigo, Sala informacionActualizada) {
        boolean actualizada = false;
        for (Sala sala : ListaSalas) {
            if (sala.getCódigo().equalsIgnoreCase(codigo)) {
                sala.setNombre(informacionActualizada.getNombre());
                sala.setCapacidad(informacionActualizada.getCapacidad());
                sala.setEstadoSala(informacionActualizada.getEstadoSala());

                //eliminar los asientos antiguos
                sala.getListaAsientos().clear();
                //actualizar los asientos

                //usamos el mismo metodo que esta en registrarSala
                int asientosFila = 10;
                int cantidadFilas = (int) Math.ceil((double) informacionActualizada.getCapacidad() / asientosFila);
                int contarAsientos = 0;

                for (int a = 0; a < cantidadFilas; a++) {
                    char letra = (char) ('A' + a);
                    String fila = String.valueOf(letra);

                    for (int numero = 1; numero <= asientosFila && contarAsientos < informacionActualizada.getCapacidad(); numero++) {
                        String codigoAsiento = fila + numero;
                        Asiento nuevoAsiento = new Asiento(codigoAsiento, fila, numero, EstadoAsiento.DISPONIBLE);
                        sala.getListaAsientos().add(nuevoAsiento);

                        contarAsientos++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    //desabilitar sala, poner en FUERA_DE_SERVICIO
    public boolean desabilitarSala(String codigo) {
        boolean desabilitada = false;
        for (Sala sala : ListaSalas) {
            if (sala.getCódigo().equalsIgnoreCase(codigo)) {
                sala.setEstadoSala(EstadoSala.FUERA_DE_SERVICIO);
                desabilitada = true;
                break;
            }
        }
        return desabilitada;
    }
    // Registrar cliente
    public void registrarCliente(String nombre, String identificacion, TipoCliente tipoCliente) {

        // Verificar que no exista un cliente con la misma identificación
        for (Cliente cliente : ListaClientes) {
            if (cliente.getIdentificacion().equalsIgnoreCase(identificacion)) {
                throw new IllegalArgumentException(
                        "¡Ya existe un cliente con esa identificación!"
                );
            }
        }

        // Crear el cliente
        Cliente nuevoCliente = new Cliente(nombre, identificacion, tipoCliente);

        // Agregarlo a la lista
        ListaClientes.add(nuevoCliente);
    }

    //Consultar Cliente
    public void consultarClientes() {

        // Verificar si hay clientes registrados
        if (ListaClientes.isEmpty()) {
            System.out.println("¡No hay clientes registrados!");
            return;
        }

        // Recorrer y mostrar los clientes
        for (Cliente cliente : ListaClientes) {
            System.out.println(cliente.toString());
        }
    }


    //============Funciones=============

    //programar funcion
    public void programarFuncion(String codigo, String codigoPelicula, String codigoSala, LocalDate fecha, String hora, double valorBase) {

        // Verificar que no exista una función con el mismo código
        for (Funcion funcion : ListaFunciones) {
            if (funcion.getCódigo().equalsIgnoreCase(codigo)) {
                throw new IllegalArgumentException(
                        "¡Ya existe una función con este código!"
                );
            }
        }

        // Buscar la película
        Pelicula peliculaEncontrada = null;

        for (Pelicula pelicula : ListaPeliculas) {
            if (pelicula.getCodigo().equalsIgnoreCase(codigoPelicula)) {
                peliculaEncontrada = pelicula;
                break;
            }
        }

        if (peliculaEncontrada == null) {
            throw new IllegalArgumentException("¡No existe esta película!");
        }

        // Buscar la sala
        Sala salaEncontrada = null;

        for (Sala sala : ListaSalas) {
            if (sala.getCódigo().equalsIgnoreCase(codigoSala)) {
                salaEncontrada = sala;
                break;
            }
        }

        if (salaEncontrada == null) {
            throw new IllegalArgumentException("¡No existe esta sala!");
        }

        // Crear y registrar la función
        Funcion nuevaFuncion = new Funcion(codigo, peliculaEncontrada, salaEncontrada, fecha, hora, valorBase, EstadoFuncion.PROGRAMADA);

        ListaFunciones.add(nuevaFuncion);
    }


    //consultar funcion

    public void consultarFunciones() {

        // Verificar si hay funciones registradas
        if (ListaFunciones.isEmpty()) {
            System.out.println(" ¡No hay funciones programadas! ");
            return;
        }

        // Recorrer y mostrar las funciones
        for (Funcion funcion : ListaFunciones) {
            System.out.println(funcion.toString());
        }
    }

    //consultar funciones por fecha

    public void consultarFuncionesPorFecha(LocalDate fecha) {

        boolean encontrada = false;

        // Recorrer las funciones
        for (Funcion funcion : ListaFunciones) {

            if (funcion.getFecha().equals(fecha)) {
                System.out.println(funcion.toString());
                encontrada = true;
            }
        }

        // Si no hay funciones para esa fecha
        if (!encontrada) {
            System.out.println(" ¡No hay funciones programadas para la fecha ingresada! ");
        }
    }

    //consultar ocupacion de funcion

    public void consultarOcupacionFuncion(String codigo) {

        // Buscar la función
        Funcion funcionEncontrada = null;

        for (Funcion funcion : ListaFunciones) {
            if (funcion.getCódigo().equalsIgnoreCase(codigo)) {
                funcionEncontrada = funcion;
                break;
            }
        }

        // Verificar si existe la función
        if (funcionEncontrada == null) {
            throw new IllegalArgumentException(
                    "No existe una función con ese código"
            );
        }

        int ocupados = 0;

        // Contar las ventas activas de esa función
        for (Venta venta : ListaVentas) {
            if (venta.getFuncion().equals(funcionEncontrada) &&
                    venta.getEstadoVenta() == EstadoVenta.ACTIVA) {
                ocupados++;
            }
        }

        // Calcular los asientos disponibles
        int capacidad = funcionEncontrada.getSala().getListaAsientos().size();
        int disponibles = capacidad - ocupados;


        // Mostrar resultados
        System.out.println("Función: " + codigo);
        System.out.println("Asientos ocupados: " + ocupados);
        System.out.println("Asientos disponibles: " + disponibles);

    }


    //REGISTRAR VENTA DE ENTRADA
    //codigoEntrada=codigoVenta

    public boolean registrarVentaEntrada(String codigoEntrada, String codigo, String codigoAsiento, Cliente cliente) {

        // Verificar que exista la función
        Funcion funcionEncontrada = null;

        for (Funcion funcion : ListaFunciones) {
            if (funcion.getCódigo().equalsIgnoreCase(codigo)) {
                funcionEncontrada = funcion;
                break;
            }
        }

        if (funcionEncontrada == null) {
            throw new IllegalArgumentException("No existe esta funcion");
        }

        // Obtener la sala
        Sala sala = funcionEncontrada.getSala();

        if (sala == null) {
            throw new IllegalArgumentException(
                    "No existe una sala para esta función"
            );
        }

        // Verificar los asientos disponibles y buscar el seleccionado
        boolean disponibles = false;
        Asiento asientoSeleccionado = null;

        for (Asiento asiento : sala.getListaAsientos()) {

            if (asiento.getEstadoAsiento() == EstadoAsiento.DISPONIBLE) {
                disponibles = true;
            }

            if (asiento.getCódigoAsiento().equalsIgnoreCase(codigoAsiento)) {
                asientoSeleccionado = asiento;
            }
        }

        // Verificar que haya asientos disponibles

        if (!disponibles) {
            throw new IllegalArgumentException("No hay asientos disponibles");
        }

        // Verificar que exista el asiento seleccionado
        if (asientoSeleccionado == null) {
            throw new IllegalArgumentException("No existe este asiento");
        }

        // Ocupar el asiento
        // Este método  si ya está ocupado

        asientoSeleccionado.ocupar();

        // Registrar fecha y hora
        LocalDateTime fechaHoraVenta = LocalDateTime.now();

        // Crear la venta
        Venta nuevaVenta = new Venta(codigoEntrada, cliente, funcionEncontrada , asientoSeleccionado , fechaHoraVenta,1000, EstadoVenta.ACTIVA, cliente.getTipoCliente());


        // Agregar la venta a la lista
        ListaVentas.add(nuevaVenta);

        System.out.println(" ¡Venta de la compra registrada correctamente!");

        return true;
    }


    //consultar venta
    // Consultar ventas
    public void consultarVentas() {

        // Verificar si hay ventas registradas
        if (ListaVentas.isEmpty()) {
            System.out.println(" ¡No hay ventas registradas! ");
            return;
        }

        // Recorrer y mostrar las ventas
        for (Venta venta : ListaVentas) {
            System.out.println(venta.toString());
        }
    }


    //cancelar venta

    public boolean cancelarVenta(String codigoVenta) {

        //buscar la venta
        Venta ventaEncontrada = null;

        for (Venta venta : ListaVentas) {
            if (venta.getCodigo().equalsIgnoreCase(codigoVenta)) {
                ventaEncontrada = venta;
                break;
            }
        }

        //verificar si la venta existe
        if (ventaEncontrada == null) {
            throw new IllegalArgumentException(
                    "No existe una venta con ese codigo"
            );
        }

        //verificar si la venta esta activa ===revisar===
        if (ventaEncontrada.getEstadoVenta() == EstadoVenta.CANCELADA) {
            throw new IllegalArgumentException("!Esta venta ya fue cancelada!"// prueba
            );
        }

        //liberar el asiento
        ventaEncontrada.getAsiento().setEstadoAsiento(EstadoAsiento.DISPONIBLE);

        //cambiar el estado de la venta
        ventaEncontrada.setEstadoVenta(EstadoVenta.CANCELADA);

        return true;
    }



    //======Reportes=====
    //calcularTotal de entradas vendidas
    public int calcularTotalEntradasVendidas() {

        int totalEntradas = 0;

        // Recorrer las ventas registradas
        for (Venta venta : ListaVentas) {

            if (venta.getEstadoVenta() == EstadoVenta.ACTIVA) {
                totalEntradas++;
            }
        }

        return totalEntradas;
    }

    //calcular total de ingresos
    public double calcularTotalIngresos() {
        double totalIngresos = 0;

        for (Venta venta : ListaVentas) {
            if (venta.getEstadoVenta() == EstadoVenta.ACTIVA) {
                totalIngresos += venta.getValorPagado();
            }
        }

        return totalIngresos;
    }



    //obtener la pelicula de mayor entradas
    public Pelicula obtenerPeliculaMayorEntradas() {

        Pelicula peliculaMayor = null;
        int mayorCantidad = 0;

        // se recorre todas las películas
        for (Pelicula pelicula : ListaPeliculas) {

            int cantidadEntradas = 0;

            // Contar las ventas  de cada película
            for (Venta venta : ListaVentas) {

                if (venta.getEstadoVenta() == EstadoVenta.ACTIVA &&
                        venta.getFuncion().getPelicula().equals(pelicula)) {

                    cantidadEntradas++;
                }
            }

            // se esta comparando la cantidad de entradas vendidas
            if (cantidadEntradas > mayorCantidad) {
                mayorCantidad = cantidadEntradas;
                peliculaMayor = pelicula;
            }
        }

        return peliculaMayor;
    }



}
