public class LibrosT {
    private libro librost[];

    public LibrosT() {
        this.librost = new libro[60];
    }
    public void añadirLibro(libro l) {
        for (int i = 0; i < librost.length; i++) {
            if (librost[i] == null) {
                librost[i] = l;
                break;
            }

            else{
                System.out.println("Error. Libreria llena");
            }
        }
    }
    public void mostrarLibrosD() {
        for (int i = 0; i < librost.length; i++) {
            if (librost[i] != null) {
                System.out.println(i+"º"+librost[i].toString());
            }
        }
    }
    public void buscarLibro(String titulo) {
        for (int i = 0; i < librost.length; i++) {
            if (librost[i] != null && librost[i].getTitulo().equals(titulo)) {
                System.out.println(librost[i].toString());
                break;
            }
        }
    }

    public void eliminarLibro(String titulo) {
        for (int i = 0; i < librost.length; i++) {
            if (librost[i] != null && librost[i].getTitulo().equals(titulo)) {
                librost[i] = null;
                break;
            }
        }
    }

    public void modificarLibro(String titulo, String ISBM, String Categoria, String Autor, String Editorial, int Num_paginas, int Num_prestaciones) {
        for (int i = 0; i < librost.length; i++) {
            if (librost[i] != null && librost[i].getTitulo().equals(titulo)) {
                librost[i].setISBM(ISBM);
                librost[i].setCategoria(Categoria);
                librost[i].setAutor(Autor);
                librost[i].setEditorial(Editorial);
                librost[i].setNum_paginas(Num_paginas);
                librost[i].setNum_prestaciones(Num_prestaciones);
                break;
            }
        }
    }

    public void prestarLibro(String titulo) {
        for (int i = 0; i < librost.length; i++) {
            if (librost[i] != null && librost[i].getTitulo().equals(titulo)) {
                librost[i].incrementarPrestaciones();
                break;
            }
        }
    }
    
}
