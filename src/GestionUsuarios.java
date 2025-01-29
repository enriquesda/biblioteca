import java.util.Scanner;

public class GestionUsuarios {
    public static Scanner sc = new Scanner(System.in);

    private Usuario listaUsurs[];
    private int lleno;
    private final int tamaño = 100;

    public GestionUsuarios() {
        this.listaUsurs = new Usuario[tamaño];
        this.lleno = 0;
    }

    // Método para añadir un Usuario al array
    public void añadirUsuario(Usuario usur) {
        if (lleno < tamaño) {
            listaUsurs[lleno] = usur;
            lleno++;
        }

    }

    // Método para buscar el índice en el array de Usuario cuando coincide con el
    // usur.
    private int buscarIndice(String usur) {
        int busco = -1;
        for (int i = 0; i < lleno && busco == -1; i++) {
            if (listaUsurs[i].getNombre().equals(usur)) {
                busco = i;
            }
        }
        return busco;
    }

    // Método para buscar un usuario
    public Usuario buscarUsuario(String usur) {
        Usuario encontrar = null;
        int indice = buscarIndice(usur);
        if (indice != -1) {
            encontrar = listaUsurs[indice];
        }
        return encontrar;
    }

    // Método para cambiar la contraseña a un usuario
    public boolean cambiarContraseña(String usur) {
        int indice = buscarIndice(usur);
        if (indice != -1) {
            System.out.println("Introduce tu contraseña actual para " + usur + "\n");
            String con = sc.nextLine();
            if (con.equals(listaUsurs[indice].getContraseña())) {
                System.out.println("Introduce una nueva contraseña" + "\n");
                String con2 = sc.nextLine();
                listaUsurs[indice].setContraseña(con2);
                System.out.println("Su contraseña ha sido cambiada" + "\n");
                return true;
            } else {
                System.out.println("Su contarseña no coincide.No se ha podido cambiar su contraseña" + "\n");
                return false;
            }
        }
        return false;
    }

    public boolean cambiarDatos(String usur){
        int indice=buscarIndice(usur);
        if(indice!=-1){
            System.out.println("Introduce un nuevo correo");
            String dato=sc.nextLine();
            listaUsurs[indice].setCorreo(dato);
            System.out.println("Introduce tu edad");
            int edad=Integer.parseInt(sc.nextLine());
            listaUsurs[indice].setEdad(edad);
            System.out.println("Introduce tu sexo");
            char sexo = sc.next().charAt(0);
            listaUsurs[indice].setSexo(sexo);
            System.out.println("Se han actualizado tus datos");
            return true;
        }
        else{
            System.out.println("Error.No se ha podido actualizar tus datos");
            return false;
        }

    }

    // Método para eliminar Usuario
    public boolean eliminarUsuario(String usur) {
        int indice = buscarIndice(usur);
        if (indice != -1) {
            for (int i = indice; i < lleno - 1; i++) {
                listaUsurs[i] = listaUsurs[i + 1];
            }
            listaUsurs[--lleno] = null;
            System.out.println("Se ha eliminado el usuario " + usur + "\n");
            return true;
        } else {
            System.out.println("No se ha podido eliminar el usuario " + usur + "\n");
            return false;
        }
    }

    // MOSTRAR LISTA DE USUARIOS REGISTRADOS
    public String listaUsuarios() {
        String usuarios = "";
        for (int i = 0; i < lleno; i++) {
            usuarios += listaUsurs[i].getNombre() + "\n";
        }
        return usuarios;
    }

    // MOSTRAR TODA LA INFORMACIÓN DE TODOS LOS USUARIOS
    public String listaTodaInfoUsurs() {
        String usuarios = "";
        for (int i = 0; i < lleno; i++) {
            usuarios += listaUsurs[i].toString() + "\n";
        }
        return usuarios;
    }

    // MOSTRAR INFORMACIÓN DE UN USUARIO
    public String infoUsuario(String usuario) {
        String usur = "";
        int indice = buscarIndice(usuario);
        if (indice != -1) {
            usur += listaUsurs[indice].toString() + "\n";
        }
        else{
            System.out.println("Usuario no encontrado");
        }
        return usur;
    }

    // MÉTODO PARA REGISTRAR UN USUARIO
    public Usuario registarUsuario() {
        Usuario usur = new Usuario();
        
        boolean funcionando = true;
    
            do {
                System.out.println("¿Quieres registrar un usuario?" + "\n");
                System.out.println("1: SI");
                System.out.println("2: NO" + "\n");

                int numero = Integer.parseInt(sc.nextLine());
                switch (numero) {
                    case 1:
                        System.out.println("Dime tu usuarrio" + "\n");
                        String usuario = sc.nextLine();
                        usur.setNombre(usuario);
                        System.out.println("Dime tu contraseña" + "\n");
                        String contraseña = sc.nextLine();
                        usur.setContraseña(contraseña);
                        System.out.println("¿Seguro que quiere registrarlo?" + "\n");
                        System.out.println("SI");
                        System.out.println("NO");
                        String confir = sc.nextLine();
                        if (confir.equals("SI")) {
                            añadirUsuario(usur);
                            System.out.println("Usuario añadido" + "\n");
                        } else {
                            System.out.println("No se ha añadido el usuario" + "\n");
                        }

                    default:
                        funcionando = false;
                }

            } while (funcionando);
        
        return usur;
    }

    // MÉTODO PARA CONFIRMAR INICIO DE SESIÓN (si el usuario y la contraseña son correctas) Y SI NO ESTAS REGISTRADO PUES TE
    // PUEDES REGISTRAR
    public Usuario confirmarUsurCont() {
        Usuario pers = new Usuario();
        System.out.println("Bienvenido a la Biblioteca" + "\n");
        System.out.println("Introduce tu usuario" + "\n");
        String usuario = sc.nextLine();
        System.out.println("Introduce tu contraseña" + "\n");
        String contraseña = sc.nextLine();
        int indice = buscarIndice(usuario);
        boolean cierto = true;
        while (cierto) {
            if (indice != -1) {
                if (listaUsurs[indice].getNombre().equals(usuario)
                        && listaUsurs[indice].getContraseña().equals(contraseña)) {
                    System.out.println("Usuario y contraseña correctas" + "\n");
                    pers = listaUsurs[indice];
                    cierto = false;

                } else {
                    System.out.println("Contraseña incorrecta.Vuelva a introducir sus credenciales" + "\n");
                    System.out.println("Introduce tu usuario" + "\n");
                    usuario = sc.nextLine();
                    System.out.println("Introduce tu contraseña" + "\n");
                    contraseña = sc.nextLine();
                    indice = buscarIndice(usuario);
                }
            } else {
                System.out.println("Usuario incorrecto o no registrado" + "\n");
                registarUsuario();
                System.out.println("Introduce tu usuario" + "\n");
                usuario = sc.nextLine();
                System.out.println("Introduce tu contraseña" + "\n");
                contraseña = sc.nextLine();
                indice = buscarIndice(usuario);
            }

        }
        return pers;
    }

    // MÉTODO PARA EL INICIO --> te da a elegir entre si quieres iniciar sesión o si te quieres registrar
    public Usuario inicioSesion() {
        Usuario pers1 = new Usuario();
        boolean funcionando = true;
        System.out.println("LIBRERÍA AMVER");
        do {
            System.out.println("¿QUÉ QUIERES HACER?" + "\n");
            System.out.println("1: INICIAR SESIÓN");
            System.out.println("2: REGISTRAR USUARIO");
            System.out.println("3: SALIR");

            int numero = Integer.parseInt(sc.nextLine());
            switch (numero) {
                case 1:
                    pers1 = confirmarUsurCont();
                    funcionando=false;
                    break;

                case 2:
                    pers1 = registarUsuario();
                    break;

                default:
                    pers1= new Usuario("PERRRRRO", "1a2345", 36, 'H', "alberto1@gmail.com", 'S');
                    funcionando = false;
            }

        } while (funcionando);
        return pers1;
    }
}
