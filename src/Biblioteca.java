import java.util.Arrays;
public class Biblioteca {
    public LibrosT libros;
    private Prestamo[] prestamos_Actuales;
    private Prestamo[] prestamos_Historicos;
    private int lleno_actuales;
    private int lleno_historicos;
    private static final int TAM = 100;

    public Biblioteca() {
        this.libros = new LibrosT();
        this.prestamos_Actuales = new Prestamo[TAM];
        this.prestamos_Historicos = new Prestamo[TAM];
        this.lleno_actuales = 0;
        this.lleno_historicos = 0;
    }
    public Biblioteca(LibrosT libros){
        this();
        this.libros=libros;
    }
    
    public LibrosT getLibros() {
        return libros;
    }
    public void setLibros(LibrosT libros) {
        this.libros = libros;
    }
    public Prestamo[] getPrestamos_Actuales() {
        return prestamos_Actuales;
    }
    public void setPrestamos_Actuales(Prestamo[] prestamos_Actuales) {
        this.prestamos_Actuales = prestamos_Actuales;
    }
    public Prestamo[] getPrestamos_Historicos() {
        return prestamos_Historicos;
    }
    public void setPrestamos_Historicos(Prestamo[] prestamos_Historicos) {
        this.prestamos_Historicos = prestamos_Historicos;
    }
    public int getLleno_actuales() {
        return lleno_actuales;
    }
    public void setLleno_actuales(int lleno_actuales) {
        this.lleno_actuales = lleno_actuales;
    }
    public int getLleno_historicos() {
        return lleno_historicos;
    }
    public void setLleno_historicos(int lleno_historicos) {
        this.lleno_historicos = lleno_historicos;
    }
    public static int getTam() {
        return TAM;
    }


    public void añadirPrestamoActual(Prestamo p) {
        if (lleno_actuales < TAM) {
            prestamos_Actuales[lleno_actuales] = p;
            lleno_actuales++;
        } else {
            System.out.println("Error. No se pueden añadir más prestamos actuales");
        }
    }

    public void añadirPrestamoHistorico(Prestamo p) {
        if (lleno_historicos < TAM) {
            prestamos_Historicos[lleno_historicos] = p;
            lleno_historicos++;
        } else {
            System.out.println("Error. No se pueden añadir más prestamos historicos");
        }
    }


      /**
     * Metodo para buscar la posicion de un prestamo actual segun su titulo
     * @param titulo
     * @return
     */
    public int buscarIndicePrestamoAct(String titulo) {
        int buscar = -1;
        for (int i = 0; i < lleno_actuales && buscar == -1; i++) {
            if (prestamos_Actuales[i].getLibros().buscarlibro(titulo).equals(titulo)) {
                buscar = i;
            }
        }
        return buscar;
    }

    /**
     * Metodo para buscar la posicion de un prestamo historico segun su titulo
     * @param titulo
     * @return
     */
    public int buscarIndicePrestamoHist(String titulo) {
        int buscar = -1;
        for (int i = 0; i < lleno_historicos && buscar == -1; i++) {
            if (prestamos_Historicos[i].getLibros().buscarlibro(titulo).equals(titulo)) {
                buscar = i;
            }
        }
        return buscar;
    }

    public Prestamo buscarPrestamoAct(String titulo) {
        Prestamo buscar = null;
        int indice = buscarIndicePrestamoAct(titulo);
        if (indice != -1) {
            buscar = prestamos_Actuales[indice];
        }
        return buscar;
    }

    public Prestamo buscarPrestamoHist(String titulo) {
        Prestamo buscar = null;
        int indice = buscarIndicePrestamoHist(titulo);
        if (indice != -1) {
            buscar = prestamos_Historicos[indice];
        }
        return buscar;
    }

    public boolean eliminarPrestamoAct(String titulo) {
        int indice = buscarIndicePrestamoAct(titulo);
        if (indice != -1) {
            for (int i = indice; i < lleno_actuales - 1; i++) {
                prestamos_Actuales[i] = prestamos_Actuales[i + 1];
                prestamos_Actuales[--lleno_actuales] = null;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarPrestamoHist(String titulo) {
        int indice = buscarIndicePrestamoHist(titulo);
        if (indice != -1) {
            for (int i = indice; i < lleno_historicos - 1; i++) {
                prestamos_Historicos[i] = prestamos_Historicos[i + 1];
                prestamos_Historicos[--lleno_historicos] = null;
            }
            return true;
        } else {
            return false;
        }
    }

    public Prestamo[] buscarPrestamosActualesUsuario(String nombre){

        Prestamo[] resultado = new Prestamo[TAM];
        int usuarioLleno = 0;
        for (int i = 0; i < lleno_actuales; i++) {
            if (prestamos_Actuales[i].getUsuario().getNombre().equals(nombre)) {
                resultado[usuarioLleno] = prestamos_Actuales[i];
                usuarioLleno++;
            }
        }
        return Arrays.copyOf(resultado, usuarioLleno);
    }

    public Prestamo[] buscarPrestamosHistoricoUsuario(String nombre){

        Prestamo[] resultado = new Prestamo[TAM];
        int usuarioLleno = 0;
        for (int i = 0; i < lleno_historicos; i++) {
            if (prestamos_Historicos[i].getUsuario().getNombre().equals(nombre)) {
                resultado[usuarioLleno] = prestamos_Historicos[i];
                usuarioLleno++;
            }
        }
        return Arrays.copyOf(resultado, usuarioLleno);
    }

    public Prestamo[] buscarPrestamosTotalesUsuarios(String nombre){

        Prestamo[] totales = new Prestamo[ buscarPrestamosActualesUsuario(nombre).length + buscarPrestamosHistoricoUsuario(nombre).length];
        System.arraycopy(buscarPrestamosActualesUsuario(nombre), 0, totales, 0, buscarPrestamosActualesUsuario(nombre).length);
        System.arraycopy(buscarPrestamosHistoricoUsuario(nombre), 0, totales, buscarPrestamosActualesUsuario(nombre).length, buscarPrestamosHistoricoUsuario(nombre).length);
        return totales;
    }


    /***
     * Metodo para realizar un prestamo
     * este libro se añade a los prestamos actuales y se elimina de la lista de libros
     * @param titulo
     * @return
     */
    public boolean realizar_Prestamo(String titulo){
        Prestamo p = new Prestamo();
        if(libros.buscarIndiceLibro(titulo) != -1){
            p.AñadirLibroPrestamo(libros.buscarlibro(titulo));
            añadirPrestamoActual(p);
            libros.eliminarLibro(titulo);
            return true;
        }else{
            System.out.println("El libro no se ha encontrado");
            return false;
        }
    }


    /**
     * Metodo para terminar un prestamo.
     * Retira el prestamo de los prestamos actuales y lo añade a los prestamos historicos
     * Posteriormente icrementa las prestaciones del libro
     * @param titulo
     * @return
     */
    public boolean terminar_Prestamo(String titulo){
        if(buscarPrestamoAct(titulo)!=null){
            añadirPrestamoHistorico(buscarPrestamoAct(titulo));
            eliminarPrestamoAct(titulo);
            libros.añadirLibro(buscarPrestamoHist(titulo).getLibros().buscarlibro(titulo));       
            libros.incrementarPrestaciones(titulo);
            return true;
        }else{
            System.out.println("No existe prestamo con ese libro");
            return false;
        }
    }

    public void añadirLibroBiblioteca(libro l){
        libros.añadirLibro(l);
    }
}
