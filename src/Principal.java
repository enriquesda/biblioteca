import java.util.Scanner;

public class Principal {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        GestionUsuarios usuarios = new GestionUsuarios();
        boolean funcionando=true;
        meterDatos(usuarios);
        Usuario persona1=usuarios.inicioSesion();
        if(persona1.getTipo()=='A'){
            do {
                System.out.println("1: Agregar libro nuevo");
                System.out.println("2: Eliminar libro");
                System.out.println("3: Actualizar libro");//ENRIQUE AÑADE MENÚ PARA BUSCAR LIBRO
                System.out.println("4: Buscar libro"); //ENRIQUE AÑADE MENÚ PARA BUSCAR LIBRO
                System.out.println("5: Libros disponibles"); //ENRIQUE AÑADE FUNCIÓN
                System.out.println("6: Registrar Nuevo usuario");
                System.out.println("7: Eliminar usuario");
                System.out.println("8: Consultar información de usuario");
                System.out.println("9: Realizar préstamos de libros");//ENRIQUE METE FUNCIÓN
                System.out.println("10: Devolver libros prestados"); //ENRIQUE METE FUNCIÓN
                System.out.println("11: Mostrar libros actualmente prestados"); //ENRIQUE METE FUNCIÓN
                System.out.println("12: Mostrar número totales de libros prestados y activos");//ENRIQUE METE FUNCIÓN
                System.out.println("13: Lista libros más prestados"); //ENRIQUE METE FUNCIÓN
                System.out.println("14: Usuario con más préstamos activos"); //ENRIQUE METE FUNCIÓN
                int numero = Integer.parseInt(sc.nextLine());
                switch (numero) {
                    case 1:
                    break;
                    case 2:
                    break;
                    case 3:
                    break;
                    case 4:
                    break;
                    case 5:
                    break;
                    case 6:
                    break;
                    case 7:
                    break;
                    case 8:
                    break;
                    case 9:
                    break;
                    case 10:
                    break;
                    case 11:
                    break;
                    case 12:
                    break;
                    case 13:
                    break;
                    case 14:
                    break;

                    default:
                        funcionando = false;
                }

            } while (funcionando);
        }
        else{
            do {
                
                System.out.println("1: Buscar libro"); //ENRIQUE AÑADE MENÚ PARA BUSCAR LIBRO
                System.out.println("2: Libros disponibles"); //ENRIQUE AÑADE FUNCIÓN
                System.out.println("3: Realizar préstamos de libros");//ENRIQUE METE FUNCIÓN
                System.out.println("4: Devolver libros prestados"); //ENRIQUE METE FUNCIÓN
                
                int numero = Integer.parseInt(sc.nextLine());
                switch (numero) {
                    case 1:
                    break;
                    case 2:
                    break;
                    case 3:
                    break;
                    case 4:
                    break;
                    
                    default:
                        funcionando = false;
                }

            } while (funcionando);

        }
       
        //PARA PRUEBA
        System.out.println(usuarios.listaUsuarios());
        System.out.println(usuarios.listaTodaInfoUsurs());
        /*System.out.println(g1.infoUsuario("pepe"));*/
        sc.close();
    }

    public static void meterDatos(GestionUsuarios usuario){
        usuario.añadirUsuario(new Usuario("Alberto", "1a2345", 'A'));
        usuario.añadirUsuario(new Usuario("Beatriz", "2b3456", 'U'));
        usuario.añadirUsuario(new Usuario("Carlos", "3c4567", 'U'));
        usuario.añadirUsuario(new Usuario("Diana", "4d5678", 'U'));
        usuario.añadirUsuario(new Usuario("Eduardo", "5e6789", 'U'));
        usuario.añadirUsuario(new Usuario("Fernanda", "6f7890", 'U'));
        usuario.añadirUsuario(new Usuario("Gabriel", "7g8901", 'U'));
        usuario.añadirUsuario(new Usuario("Héctor", "8h9012", 'U'));
        usuario.añadirUsuario(new Usuario("Isabel", "9i0123", 'U'));
        usuario.añadirUsuario(new Usuario("Javier", "10j1234", 'U'));
        usuario.añadirUsuario(new Usuario("Karen", "11k2345", 'U'));
        usuario.añadirUsuario(new Usuario("Luis", "12l3456", 'U'));
        usuario.añadirUsuario(new Usuario("Marta", "13m4567", 'U'));
        usuario.añadirUsuario(new Usuario("Nicolás", "14n5678", 'U'));
        usuario.añadirUsuario(new Usuario("Olga", "15o6789", 'U'));
        usuario.añadirUsuario(new Usuario("Pablo", "16p7890", 'U'));
        usuario.añadirUsuario(new Usuario("Quintín", "17q8901", 'U'));
        usuario.añadirUsuario(new Usuario("Rosa", "18r9012", 'U'));
        usuario.añadirUsuario(new Usuario("Sergio", "19s0123", 'U'));
        usuario.añadirUsuario(new Usuario("Teresa", "20t1234", 'U'));
        usuario.añadirUsuario(new Usuario("Ulises", "21u2345", 'U'));
        usuario.añadirUsuario(new Usuario("Valeria", "22v3456", 'U'));
        usuario.añadirUsuario(new Usuario("Walter", "23w4567", 'U'));
        usuario.añadirUsuario(new Usuario("Ximena", "24x5678", 'U'));
        usuario.añadirUsuario(new Usuario("Yolanda", "25y6789", 'U'));
        usuario.añadirUsuario(new Usuario("Zacarías", "26z7890", 'U'));
        usuario.añadirUsuario(new Usuario("Andrés", "27a8901", 'U'));
        usuario.añadirUsuario(new Usuario("Brenda", "28b9012", 'U'));
        usuario.añadirUsuario(new Usuario("Cecilia", "29c0123", 'U'));
        usuario.añadirUsuario(new Usuario("David", "30d1234", 'U'));
        usuario.añadirUsuario(new Usuario("Elena", "31e2345", 'U'));
        usuario.añadirUsuario(new Usuario("Federico", "32f3456", 'U'));
        usuario.añadirUsuario(new Usuario("Gloria", "33g4567", 'U'));
        usuario.añadirUsuario(new Usuario("Hilda", "34h5678", 'U'));
        usuario.añadirUsuario(new Usuario("Iván", "35i6789", 'U'));
        usuario.añadirUsuario(new Usuario("Julieta", "36j7890", 'U'));
        usuario.añadirUsuario(new Usuario("Kevin", "37k8901", 'U'));
        usuario.añadirUsuario(new Usuario("Laura", "38l9012", 'U'));
        usuario.añadirUsuario(new Usuario("Mario", "39m0123", 'U'));
        usuario.añadirUsuario(new Usuario("Natalia", "40n1234", 'U'));
        usuario.añadirUsuario(new Usuario("Oscar", "41o2345", 'U'));
        usuario.añadirUsuario(new Usuario("Patricia", "42p3456", 'U'));
        usuario.añadirUsuario(new Usuario("Ricardo", "43r4567", 'U'));
        usuario.añadirUsuario(new Usuario("Silvia", "44s5678", 'U'));
        usuario.añadirUsuario(new Usuario("Tomás", "45t6789", 'U'));
        usuario.añadirUsuario(new Usuario("Úrsula", "46u7890", 'U'));
        usuario.añadirUsuario(new Usuario("Víctor", "47v8901", 'U'));
        usuario.añadirUsuario(new Usuario("Wendy", "48w9012", 'U'));
        usuario.añadirUsuario(new Usuario("Xavier", "49x0123", 'U'));
        usuario.añadirUsuario(new Usuario("Yago", "50y1234", 'U'));
        usuario.añadirUsuario(new Usuario("Zoe", "51z2345", 'U'));
        usuario.añadirUsuario(new Usuario("Álvaro", "52a3456", 'U'));
        usuario.añadirUsuario(new Usuario("Bárbara", "53b4567", 'U'));
        usuario.añadirUsuario(new Usuario("Carmen", "54c5678", 'U'));
        usuario.añadirUsuario(new Usuario("Diego", "55d6789", 'U'));
        usuario.añadirUsuario(new Usuario("Elsa", "56e7890", 'U'));
        usuario.añadirUsuario(new Usuario("Fabián", "57f8901", 'U'));
        usuario.añadirUsuario(new Usuario("Gabriela", "58g9012", 'U'));
        usuario.añadirUsuario(new Usuario("Hernán", "59h0123", 'U'));
        usuario.añadirUsuario(new Usuario("Ismael", "60i1234", 'U'));
    }

}
