import java.util.Scanner;

public class Principal {

    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        //HAY QUE CREAR EL ARRAY DE LIBROS Y DE USUARIOS...TELA MARINERA JAJAJA

        GestionUsuarios usuarios = new GestionUsuarios();
        System.out.println("Bienvenido a la Biblioteca");
        System.out.println("Introduce tu usuario");
        String usuario=sc.nextLine();
        System.out.println("Introduce tu usuario");
        String contraseña=sc.nextLine();

        //LO QUE QUIERO HACER ES BUSCAR EL USUARIO EN EL ARRAY DE USUARIOS, SI LO ENCUENTRA TENEMOS QUE HACER ES DECIR SI
        //LA CONTRASEÑA DE ESE USUARIO ES IGUAL QUE LA CONTRASEÑA QUE INTRODUZCAMOS. SI ES IGUAL, TENEMOS QUE VER EL TIPO: SI
        //ES A LE DAREMOS UN MENU Y SI ES U OTRO MENÚ. A VER SI ME VIENE LA INSPIRACIÓN :(

        Usuario buscaUsur=usuarios.buscarUsuario(usuario);
        if(buscaUsur.getNombre().equals(usuario)){
            

        }


        sc.close();
    }
}
