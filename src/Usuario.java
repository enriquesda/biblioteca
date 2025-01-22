public class Usuario {

    private String nombre;
    private String contraseña;
    private int edad;
    private char sexo;
    private String correo;
    private char tipo;
    private final char sexoFinal = 'H';
    private final char tipoFinal = 'U';

    public Usuario() {
        this.nombre = "";
        this.contraseña = "";
        this.edad = 0;
        this.sexo = 'H';
        this.correo = "";
        this.tipo='U';
    }

    public Usuario(String nombre,String contraseña,char tipo){
        this();
        this.nombre=nombre;
        this.contraseña=contraseña;
        this.tipo=comprobarTipo(tipo);
    }

    public Usuario(String nombre, String contraseña, int edad, char sexo, String correo,char tipo) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.edad = edad;
        this.sexo = comprobarSexo(sexo);
        this.correo = correo;
        this.tipo=comprobarTipo(tipo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = comprobarSexo(sexo);
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public char getTipo() {
        return sexo;
    }

    public void setTipo(char tipo) {
        this.tipo = comprobarTipo(tipo);
    }

     // Método comprobar sexo

     private char comprobarSexo(char sexo) {

        if (sexo == 'H' || sexo == 'M') {
            return sexo;
        }

        else {
            return this.sexo = this.sexoFinal;
        }
    }

    private char comprobarTipo(char tipo) {

        if (tipo == 'A' || sexo == 'U') {
            return tipo;
        }

        else {
            return this.tipo = this.tipoFinal;
        }
    }


    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", contraseña='" + getContraseña() + "'" +
            ", edad='" + getEdad() + "'" +
            ", sexo='" + getSexo() + "'" +
            ", correo='" + getCorreo() + "'" +
            ", tipo='" + getTipo() + "'" +
            "}";
    }

}

