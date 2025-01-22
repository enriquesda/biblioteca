public class Usuario {

    private String nombre;
    private String contraseña;
    private int edad;
    private char sexo;
    private String correo;
    private char tipo;

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
        this.tipo=comprobarTipo();
    }

    public Usuario(String nombre, String contraseña, int edad, char sexo, String correo,char tipo) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.edad = edad;
        this.sexo = comprobarSexo();
        this.correo = correo;
        this.tipo=comprobarTipo();
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
        this.sexo = sexo;
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
        this.tipo = tipo;
    }

}

