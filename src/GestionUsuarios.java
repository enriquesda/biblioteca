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

    public void añadirUsuario(Usuario usur) {
        listaUsurs[lleno] = usur;
        lleno++;
    }

    public int buscarIndice(String usur) {
        int busco = -1;
        for (int i = 0; i < lleno && busco == -1; i++) {
            if (listaUsurs[i].getNombre().equals(usur)) {
                busco = i;
            }
        }
        return busco;
    }

    public Usuario buscarUsuario(String usur) {
        Usuario encontrar = null;
        int indice = buscarIndice(usur);
        if (indice != -1) {
            encontrar = listaUsurs[indice];
        }
        return encontrar;
    }

    public void cambiarContraseña(String usur) {
        int indice = buscarIndice(usur);
        if (indice != -1) {
            System.out.println("Introduce tu contraseña");
            String con = sc.nextLine();
            if (con.equals(listaUsurs[indice].getContraseña())) {
                System.out.println("Introduce una nueva contraseña");
                String con2 = sc.nextLine();
                listaUsurs[indice].setContraseña(con2);
                System.out.println("Su contraseña ha sido cambiada");
            }
            else{
                System.out.println("Su contarseña no coincide.No se ha podido cambiar su contraseña");
            }
        }

    }

}
