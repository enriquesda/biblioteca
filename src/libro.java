
public class libro {

    private String titulo;
    private String ISBM;
    private String Categoria; //¿NO ES MEJOR HACER UN ENUM CON VARIAS CATEGORIAS?
    private String Autor;
    private String Editorial; //¿ENUM?
    private int Num_paginas;
    private int Num_prestaciones;

    public libro(String titulo, String ISBM, String Categoria, String Autor, String Editorial, int Num_paginas, int Num_prestaciones) {
        this.titulo = titulo;
        this.ISBM = ISBM;
        this.Categoria = Categoria;
        this.Autor = Autor;
        this.Editorial = Editorial;
        this.Num_paginas = Num_paginas;
        this.Num_prestaciones = Num_prestaciones;
    }

    public libro() {
        this.titulo = "";
        this.ISBM = "";
        this.Categoria = "";
        this.Autor = "";
        this.Editorial = "";
        this.Num_paginas = 0;
        this.Num_prestaciones = 0;
    }

    public libro(String titulo, String autor) {
        this();
        this.titulo = titulo;
        this.Autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getISBM() {
        return ISBM;
    }

    public void setISBM(String iSBM) {
        ISBM = iSBM;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String editorial) {
        Editorial = editorial;
    }

    public int getNum_paginas() {
        return Num_paginas;
    }

    public void setNum_paginas(int num_paginas) {
        Num_paginas = num_paginas;
    }

    public int getNum_prestaciones() {
        return Num_prestaciones;
    }

    public void setNum_prestaciones(int num_prestaciones) {
        Num_prestaciones = num_prestaciones;
    }

    public String toString() {
        return "libro [titulo=" + titulo + ", ISBM=" + ISBM + ", Categoria=" + Categoria + ", Autor=" + Autor
                + ", Editorial=" + Editorial + ", Num_paginas=" + Num_paginas + ", Num_prestaciones=" + Num_prestaciones
                + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        libro other = (libro) obj;
        if (titulo == null) {
            if (other.titulo != null) {
                return false;
            }
        } else if (!titulo.equals(other.titulo)) {
            return false;
        }
        if (ISBM == null) {
            if (other.ISBM != null) {
                return false;
            }
        } else if (!ISBM.equals(other.ISBM)) {
            return false;
        }
        if (Categoria == null) {
            if (other.Categoria != null) {
                return false;
            }
        } else if (!Categoria.equals(other.Categoria)) {
            return false;
        }
        if (Autor == null) {
            if (other.Autor != null) {
                return false;
            }
        } else if (!Autor.equals(other.Autor)) {
            return false;
        }
        if (Editorial == null) {
            if (other.Editorial != null) {
                return false;
            }
        } else if (!Editorial.equals(other.Editorial)) {
            return false;
        }
        if (Num_paginas != other.Num_paginas) {
            return false;
        }
        if (Num_prestaciones != other.Num_prestaciones) {
            return false;
        }
        return true;
    }

    public void incrementarPrestaciones() {
        this.Num_prestaciones++;
    }

}
