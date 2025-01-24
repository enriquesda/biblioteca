import java.util.Arrays;

public class LibrosT {
    private libro librost[];
    private int lleno;
    private static final int TAM = 100;

    public LibrosT() {
        this.librost = new libro[60];
        this.lleno = 0;
    }

    public void añadirLibro(libro l) {
        if (lleno < TAM) {
            librost[lleno] = l;
            lleno++;
        } else {
            System.out.println("Error. Libreria llena");
        }
    }

    public void mostrarLibros() {
        for (int i = 0; i < librost.length; i++) {
            if (librost[i] != null) {
                System.out.println(i + "º" + librost[i].toString());
            }
        }
    }

    public int buscarIndiceLibro(String titulo) {
        int buscar = -1;
        for (int i = 0; i < lleno && buscar == -1; i++) {
            if (librost[i].getTitulo().equals(titulo)) {
                buscar = i;
            }
        }
        return buscar;
    }

    public libro buscarlibro(String titulo) {
        libro buscar = null;
        int indice = buscarIndiceLibro(titulo);
        if (indice != -1) {
            buscar = librost[indice];
        }
        return buscar;
    }

    public boolean eliminarLibro(String titulo) {
        int indice = buscarIndiceLibro(titulo);
        if (indice != -1) {
            for (int i = indice; i < lleno - 1; i++) {
                librost[i] = librost[i + 1];
                librost[--lleno] = null;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean actualizarLibro(String titulo, libro actualizada) {
        int indice = buscarIndiceLibro(titulo);
        if (indice != -1) {
            librost[indice] = actualizada;
            return true;
        } else {
            return false;
        }
    }


    public libro[] buscarPorAutor(String autor) {
        libro[] resultado = new libro[TAM];
        int autorLleno = 0;
        for (int i = 0; i < lleno; i++) {
            if (librost[i].getAutor().equals(autor)) {
                resultado[autorLleno] = librost[i];
                autorLleno++;
            }
        }
        return Arrays.copyOf(resultado, autorLleno);
    }


    public libro[] buscarPorCategoria(String categoria) {
        libro[] resultado = new libro[TAM];
        int autorLleno = 0;
        for (int i = 0; i < lleno; i++) {
            if (librost[i].getAutor().equals(categoria)) {
                resultado[autorLleno] = librost[i];
                autorLleno++;
            }
        }
        return Arrays.copyOf(resultado, autorLleno);
    }



    public libro[] buscarPorEditorial(String Editorial) {
        libro[] resultado = new libro[TAM];
        int autorLleno = 0;
        for (int i = 0; i < lleno; i++) {
            if (librost[i].getAutor().equals(Editorial)) {
                resultado[autorLleno] = librost[i];
                autorLleno++;
            }
        }
        return Arrays.copyOf(resultado, autorLleno);
    }

    @Override
    public String toString() {
        String stringlibros = "";
        for (int i = 0; i < lleno; i++) {
            stringlibros += librost[i].toString() + "\n";
        }
        return stringlibros;
    }

    public static String toString(libro[] arraylibro){
        String stringlibro = "";
        for (libro book : arraylibro) {
            stringlibro += book.toString() + "\n";
        }
        return stringlibro;
    }

    // añadir prestar libro

}
