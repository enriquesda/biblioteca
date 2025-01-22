public class Prestamo {
    private LibrosT  libros;
    private Usuario usuario;
    private int  Fecha_ini;
    private int  Fecha_fin;

    public Prestamo(){
        this.libros = new LibrosT();
        this.usuario = new Usuario();
        this.Fecha_ini = 0;
        this.Fecha_fin = 0;
    }
    public Prestamo( LibrosT libros, Usuario usuario, int Fecha_ini, int Fecha_fin){
        this.libros = libros;
        this.usuario = usuario;
        this.Fecha_ini = Fecha_ini;
        this.Fecha_fin = Fecha_fin;
    }
    public Prestamo(LibrosT libros, Usuario usuario){
        this.libros = libros;
        this.usuario = usuario;
        this.Fecha_ini = 0;
        this.Fecha_fin = 0;
    }

    public void AñadirLibroPrestamo(libro l){
        this.libros.añadirLibro(l);
    }

    public LibrosT getLibros() {
        return libros;
    }
    public void setLibros(LibrosT libros) {
        this.libros = libros;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public int getFecha_ini() {
        return Fecha_ini;
    }
    public void setFecha_ini(int fecha_ini) {
        Fecha_ini = fecha_ini;
    }
    public int getFecha_fin() {
        return Fecha_fin;
    }
    public void setFecha_fin(int fecha_fin) {
        Fecha_fin = fecha_fin;
    }


}
