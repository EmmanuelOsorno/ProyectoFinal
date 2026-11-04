import java.time.LocalDateTime;
import java.util.ArrayList;

public class Cine {

    //listas para los componentes
    private ArrayList<Pelicula> ListaPeliculas;
    private ArrayList<Sala> ListaSalas;
    private ArrayList<Cliente> ListaClientes;
    private ArrayList<Funcion> ListaFunciones;
    private ArrayList<Venta> ListaVentas;

    //constructor
    public Cine() {
        this.ListaPeliculas = new ArrayList<>();
        this.ListaSalas = new ArrayList<>();
        this.ListaClientes = new ArrayList<>();
        this.ListaFunciones = new ArrayList<>();
        this.ListaVentas = new ArrayList<>();
    }

    //get y set
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
    public void registrarPelicula(String codigo, String nombre, String genero, int duracion, Clasificacion clasificacion, EstadoPelicula estadoPelicula) {
        Pelicula nuevaPelicula = new Pelicula(codigo, nombre, genero, duracion, clasificacion, estadoPelicula);
        ListaPeliculas.add(nuevaPelicula);
    }

    public void consultarPeliculas() {
        //si no hay peliculas
        if (ListaPeliculas.size() == 0) {
            System.out.println("No hay peliculas registradas");
            return;
        }
        for (int a = 0; a < ListaPeliculas.size(); a++) {
            Pelicula pelicula = ListaPeliculas.get(a);
            System.out.println(pelicula.toString());
        }
    }

    public boolean actualizarPelicula(String codigo, Pelicula infoActualizada) {
        boolean actualizado = false;
        for (Pelicula pelicula : ListaPeliculas) {
            if (pelicula.getCodigo().equalsIgnoreCase(codigo)) {
                pelicula.setNombre(infoActualizada.getNombre());
                pelicula.setGenero(infoActualizada.getGenero());
                pelicula.setDuracion(infoActualizada.getDuracion());
                pelicula.setClasificacion(infoActualizada.getClasificacion());
                pelicula.setEstadoPelicula(infoActualizada.getEstadoPelicula());
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
        Sala nuevaSala = new Sala(codigo, nombre, capacidad, estadoSala);

        //generar los asientos al registrar la sala
        //poner una cantidad predeterminada de asientos en la fila
        int asientosFila = 20;
        int cantidadFilas = (int) Math.ceil((double) capacidad / asientosFila);
        int contadorAsientos = 0;
        for (int a = 0; a <= cantidadFilas; a++) {
            char letra = (char) ('A' + a);
            String fila = String.valueOf(letra);

            for (int numero = 1; numero <= asientosFila && contadorAsientos < capacidad; numero++) {
                String codigoAsiento = fila + numero;
                Asiento nuevoAsiento = new Asiento(codigoAsiento, fila, numero, EstadoAsiento.DISPONIBLE);
                nuevaSala.getListaAsientos().add(nuevoAsiento);
                contadorAsientos++;
            }
        }
        ListaSalas.add(nuevaSala);
    }

    public void consultarSalas() {
        //si no hay salas
        if (ListaSalas.size() == 0) {
            System.out.println("No hay salas registradas");
            return;
        }
        for (int a = 0; a < ListaSalas.size(); a++) {
            Sala sala = ListaSalas.get(a);
            System.out.println(sala.toString());
        }
    }

    public boolean actualizarSala(String codigo, Sala infoActualizada) {
        boolean actualizada = false;
        for (Sala sala : ListaSalas) {
            if (sala.getCódigo().equalsIgnoreCase(codigo)) {
                sala.setNombre(infoActualizada.getNombre());
                sala.setCapacidad(infoActualizada.getCapacidad());
                sala.setEstadoSala(infoActualizada.getEstadoSala());
                sala.setListaAsientos(infoActualizada.getListaAsientos());
                actualizada = true;
                break;
            }
        }
        return actualizada;
    }

    //desabilitar sala, es decir, cambiar su estado a FUERA_DE_SERVICIO
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

    //REGISTRAR VENTA DE ENTRADA
    public boolean registrarVentaEntrada(String codigoEntrada, String codigoFuncion, String codigoAsiento, Cliente cliente) {
        //verificar funcion
        Funcion funcionEncontrada = null;
        for (Funcion funcion : ListaFunciones) {
            if (funcion.getCódigo().equalsIgnoreCase(codigoFuncion)) {
                funcionEncontrada = funcion;
                break;
            }
        }
        if (funcionEncontrada == null) {
            System.out.println("No existe esta funcion");
        }

        //sala
        Sala sala = funcionEncontrada.getSala();
        //si no hay sala
        if (sala == null) {
            System.out.println("No existe una sala para esta funcion");
        }

        //verificar asientos
        boolean disponibles = false;
        Asiento asientoSeleccionado = null;
        for (Asiento asiento : sala.getListaAsientos()) {
            if (asiento.getEstadoAsiento() == EstadoAsiento.DISPONIBLE) {
                disponibles = true;
            }
            if (asiento.getCódigo().equalsIgnoreCase(codigoAsiento)) {
                asientoSeleccionado = asiento;
            }
        }
        //si no hay asientos en estado DISPONIBLE
        if (!disponibles) {
            System.out.println("No hay asientos disponibles");
        }

        //verifica existencia de asiento
        if (asientoSeleccionado == null) {
            System.out.println("No existe este asiento");
        }

        if (asientoSeleccionado.getEstadoAsiento() != EstadoAsiento.DISPONIBLE) {
            System.out.println("El asiento esta ocupado");
        }

        //valor de la entrada
        double valorFinal = cliente.getTipoCliente().getValor();

        //cambiar esado del asiento a OCUPADO
        asientoSeleccionado.setEstadoAsiento(EstadoAsiento.OCUPADO);

        //registrar fecha y hora de la venta
        LocalDateTime fechaHoraVenta = LocalDateTime.now();

        //registrar la entrada vendida
        Entrada nuevaEntrada = new Entrada(codigoEntrada, funcionEncontrada, cliente, asientoSeleccionado, fechaHoraVenta, valorFinal, cliente.getTipoCliente());

        System.out.println("Venta de la compra registrada correctamente");
        return true;
    }





}
