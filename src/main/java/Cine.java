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
        int asientosFila = 10;
        int cantidadFilas = (int) Math.ceil((double) capacidad / asientosFila);
        int contadorAsientos = 0;
        for (int a = 0; a < cantidadFilas; a++) {
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
                System.out.println("Fila "+fila+":");
            }
            System.out.println(asiento.getCódigo()+":"+asiento.getEstadoAsiento());
        }
    }

    public boolean actualizarSala(String codigo, Sala infoActualizada) {
        boolean actualizada = false;
        for (Sala sala : ListaSalas) {
            if (sala.getCódigo().equalsIgnoreCase(codigo)) {
                sala.setNombre(infoActualizada.getNombre());
                sala.setCapacidad(infoActualizada.getCapacidad());
                sala.setEstadoSala(infoActualizada.getEstadoSala());
                //eliminar los asientos antiguos
                sala.getListaAsientos().clear();
                //actualizar los asientos
                //usamos el mismo metodo que esta en registrarSala
                int asientosFila = 10;
                int cantidadFilas = (int) Math.ceil((double) infoActualizada.getCapacidad() / asientosFila);
                int contadorAsientos = 0;
                for (int a = 0; a < cantidadFilas; a++) {
                    char letra = (char) ('A' + a);
                    String fila = String.valueOf(letra);

                    for (int numero = 1; numero <= asientosFila && contadorAsientos < infoActualizada.getCapacidad(); numero++) {
                        String codigoAsiento = fila + numero;
                        Asiento nuevoAsiento = new Asiento(codigoAsiento, fila, numero, EstadoAsiento.DISPONIBLE);
                        sala.getListaAsientos().add(nuevoAsiento);
                        contadorAsientos++;
                    }
                }
                return true;
            }
        }
        return false;
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

    //METODOS FUNCION
    //programar funcion
    public boolean registrarFuncion(String codigo, String codigoPelicula, String codigoSala, LocalDate fecha, String hora, double valorBase, EstadoFuncion estadoFuncion){
       //asiganr pelicula
        Pelicula pelicula_funcion=null;
        for(Pelicula peliculaF:ListaPeliculas){
            if(peliculaF.getCodigo().equalsIgnoreCase(codigoPelicula)){
                pelicula_funcion=peliculaF;
                break;
            }
        }
        //asignarr sala
        Sala sala_funcion=null;
        for(Sala salaF:ListaSalas){
            if(salaF.getCódigo().equalsIgnoreCase(codigoSala)){
                sala_funcion=salaF;
                break;
            }
        }
        //si la sala y pelicula no existan
        //"==" porque estamos comparando si son iguales
        if(pelicula_funcion==null){
            System.out.println("La pelicula no existe");
            return false;
        }else if (sala_funcion==null){
            System.out.println("La sala no existe");
            return false;
        }
        //impedir registar funcion si el estado de la sala es FUERA_DE_SERVICIO
        if(sala_funcion.getEstadoSala()==EstadoSala.FUERA_DE_SERVICIO){
            System.out.println("La sala esta fuera de servicio");
            return false;
        }
        //registar la funcion
        Funcion nuevaFuncion=new Funcion(codigo,pelicula_funcion,sala_funcion, fecha,hora,valorBase,estadoFuncion);
        ListaFunciones.add(nuevaFuncion);
        return true;
    }



    //REGISTRAR VENTA DE ENTRADA
    //codigoEntrada=codigoVenta
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
            //se retorna un false en caso que no exista la funcion, para detener el proceso
            return false;
        }

        //sala
        Sala sala = funcionEncontrada.getSala();
        //si no hay sala
        if (sala == null) {
            System.out.println("No existe una sala para esta funcion");
            //se retorna un false en caso que no exista la sala, para detener el proceso
            return false;
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
            //se retorna un false en caso de que no haya disponibles, para detener el proceso
            return false;
        }

        //verifica existencia de asiento
        if (asientoSeleccionado == null) {
            System.out.println("No existe este asiento");
            //se retorna un false en caso que no exista el asiento, para detener el proceso
            return false;
        }

        if (asientoSeleccionado.getEstadoAsiento() != EstadoAsiento.DISPONIBLE) {
            System.out.println("El asiento esta ocupado");
            //se retorna un false en caso que el asiento no este en estado DISPONIBLE, para detener el proceso
            return false;
        }

        //valor de la entrada
        double valorFinal = (cliente.getTipoCliente().getValor())+funcionEncontrada.getValorBase();

        //cambiar esado del asiento a OCUPADO
        asientoSeleccionado.setEstadoAsiento(EstadoAsiento.OCUPADO);

        //registrar fecha y hora de la venta
        LocalDateTime fechaHoraVenta = LocalDateTime.now();

        //registrar la entrada vendida
        //se crea con estado ACTIVA
        Venta nuevaVenta = new Venta(codigoEntrada, cliente, funcionEncontrada, asientoSeleccionado, fechaHoraVenta, valorFinal,EstadoVenta.ACTIVA, cliente.getTipoCliente());
        ListaVentas.add(nuevaVenta);

        System.out.println("Venta de la compra registrada correctamente");
        return true;
    }


}
