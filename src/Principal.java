import java.util.Scanner;

/*
 * @author Enrique Ambrona y Alberto Vera
 */
public class Principal {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception { // CUANDO YA INICIAS SESIÓN Y TE METES EN CUALQUIER MENÚ,
        // SI SALES TE SALES ENTERO DEL PROGRAMA. ME GUSTARÍA QUE
        // VOLVIERA AL PRINCIPIO DEL TODO POR SI QUIERES INICIAR
        // SESIÓN CON OTRO USUARIO O SALIRTE.
        GestionUsuarios usuarios = new GestionUsuarios();
        Biblioteca biblio = new Biblioteca();
        LibrosT libros = new LibrosT();
        meterDatosLib(libros);
        boolean funcionando = true;
        meterDatosUsur(usuarios);
        biblio.setLibros(libros);
        Usuario persona1 = usuarios.inicioSesion();
      
        if (persona1.getTipo() == 'A') {
            do {
                System.out.println("1: Agregar libro nuevo");
                System.out.println("2: Eliminar libro");
                System.out.println("3: Actualizar libro");// comp
                System.out.println("4: Buscar libro");
                System.out.println("5: Libros disponibles");// comp
                System.out.println("6: Registrar Nuevo usuario");
                System.out.println("7: Eliminar usuario");
                System.out.println("8: Consultar información de usuario");
                System.out.println("9: Realizar préstamos de libros");// comp
                System.out.println("10: Devolver libros prestados"); // comp
                System.out.println("11: Mostrar libros actualmente prestados"); // comp
                System.out.println("12: Mostrar número totales de libros prestados y activos");// comp
                System.out.println("13: Lista libros más prestados"); // comp
                System.out.println("14: Usuario con más préstamos activos"); // ENRIQUE METE FUNCIÓN
                System.out.println("0: Salir");
                int numero = Integer.parseInt(sc.nextLine());
                switch (numero) {
                    case 1:
                        libro l = new libro();
                        System.out.println("Introduce el título");
                        String datos = sc.nextLine();
                        l.setTitulo(datos);
                        System.out.println("Introduce el ISBM");
                        datos = sc.nextLine();
                        l.setISBM(datos);
                        System.out.println("Introduce la categoría");
                        datos = sc.nextLine();
                        l.setCategoria(datos);
                        System.out.println("Introduce el Autor");
                        datos = sc.nextLine();
                        l.setAutor(datos);
                        System.out.println("Introduce la Editorial");
                        datos = sc.nextLine();
                        l.setEditorial(datos);
                        System.out.println("Introduce el número de páginas");
                        int pag = Integer.parseInt(sc.nextLine());
                        l.setNum_paginas(pag);
                        l.setNum_prestaciones(0);
                        biblio.añadirLibroBiblioteca(l);
                        System.out.println("Se ha añadido un libro nuevo");
                        break;
                    case 2:
                        System.out.println("Introduce el título del libro a borrar");
                        String lib = sc.nextLine();
                        if (biblio.libros.eliminarLibro(lib)) {
                            System.out.println("Libro eliminado");
                        } else {
                            System.out.println("Libro no encontrado");
                        }
                        break;
                    case 3:
                        libro l1 = new libro();
                        System.out.println("Introduce el título del libro a modificar");
                        String datos1 = sc.nextLine();
                        l1.setTitulo(datos1);
                        System.out.println("Introduce el ISBM");
                        datos1 = sc.nextLine();
                        l1.setISBM(datos1);
                        System.out.println("Introduce la categoría");
                        datos1 = sc.nextLine();
                        l1.setCategoria(datos1);
                        System.out.println("Introduce el Autor");
                        datos1 = sc.nextLine();
                        l1.setAutor(datos1);
                        System.out.println("Introduce la Editorial");
                        datos1 = sc.nextLine();
                        l1.setEditorial(datos1);
                        System.out.println("Introduce el número de páginas");
                        int num1 = Integer.parseInt(sc.nextLine());
                        l1.setNum_paginas(num1);
                        System.out.println("Introduce el número de veces que se ha prestado");
                        l1.setNum_prestaciones(Integer.parseInt(sc.nextLine()));

                        if (biblio.libros.actualizarLibro(datos1, l1)) {
                            System.out.println("Libro actualizado");
                        } else {
                            System.out.println("Libro no encontrado");
                        }
                        break;
                    case 4:
                        boolean salir1 = true;
                        do {
                            System.out.println("¿Qué desea buscar?");
                            System.out.println("1: Buscar por título");
                            System.out.println("2: Buscar por autor");
                            System.out.println("3: Buscar por categoría");
                            System.out.println("4: Buscar por editorial");
                            System.out.println("5: Salir");
                            int numero1 = Integer.parseInt(sc.nextLine());

                            switch (numero1) {
                                case 1:
                                    System.out.println("Introduce un título");
                                    String tit1 = sc.nextLine();
                                    if (biblio.libros.buscarlibro(tit1) != null) {
                                        System.out.println(biblio.libros.buscarlibro(tit1).toString());
                                    } else {
                                        System.out.println("Libro no encontrado o prestado");
                                    }
                                    break;
                                case 2:
                                    System.out.println("Introduce un autor");
                                    tit1 = sc.nextLine();
                                    libro[] resultado = biblio.libros.buscarPorAutor(tit1);
                                    if (resultado != null) {
                                        for (int i = 0; i < resultado.length; i++) {
                                            System.out.println(resultado[i].toString());

                                        }
                                    } else {
                                        System.out.println("Libros no encontrados o prestados de ese autor");
                                    }
                                    break;
                                case 3:
                                    System.out.println("Introduce una categoría");
                                    tit1 = sc.nextLine();
                                    libro[] resultadoc = biblio.libros.buscarPorCategoria(tit1);
                                    if (resultadoc != null) {
                                        for (int i = 0; i < resultadoc.length; i++) {
                                            System.out.println(resultadoc[i].toString());

                                        }
                                    } else {
                                        System.out.println("Libros no encontrados o prestados de esa categoria");
                                    }
                                        
                                    break;
                                case 4:
                                    System.out.println("Introduce una editorial");
                                    tit1 = sc.nextLine();
                                    libro[] resultadoe = biblio.libros.buscarPorEditorial(tit1);
                                    if (resultadoe != null) {
                                        for (int i = 0; i < resultadoe.length; i++) {
                                            System.out.println(resultadoe[i].toString());

                                        }
                                    } else {
                                        System.out.println("Libros no encontrados o prestados de esa editorial");
                                    }
                                    break;
                                default:
                                    salir1 = false;
                            }
                        } while (salir1);
                        break;
                    case 5:
                        System.out.println("Los libros actualmente disponibles son:");
                        biblio.libros.mostrarLibros();
                        break;
                    case 6:
                        usuarios.registarUsuario();
                        break;
                    case 7:
                        System.out.println("Introduce el usuario a borrar");
                        String usur = sc.nextLine();
                        usuarios.eliminarUsuario(usur);
                        break;
                    case 8:
                        boolean salir = true;
                        do {
                            System.out.println("¿Qué desea buscar?");
                            System.out.println("1: Lista de usuarios");
                            System.out.println("2: Toda la información de todos los usuarios");
                            System.out.println("3: Información de un usuaio");
                            System.out.println("4: Salir");
                            int numero1 = Integer.parseInt(sc.nextLine());

                            switch (numero1) {
                                case 1:
                                    System.out.println(usuarios.listaUsuarios());
                                    break;
                                case 2:
                                    System.out.println(usuarios.listaTodaInfoUsurs());
                                    break;
                                case 3:
                                    System.out.println("Introduce el usuario");
                                    String usur1 = sc.nextLine();
                                    System.out.println(usuarios.infoUsuario(usur1));
                                    break;
                                default:
                                    salir = false;
                            }
                        } while (salir);

                        break;
                    case 9:
                        System.out.println("Que usuario va a realizar el préstamo?");
                        String nombre = sc.nextLine();
                        if (usuarios.buscarUsuario(nombre) != null) {
                            System.out.println("Que libro vas a prestar?");
                            String titulo = sc.nextLine();
                            if (biblio.libros.buscarlibro(titulo) != null) {
                                biblio.realizar_Prestamo(titulo, usuarios.buscarUsuario(nombre));
                            } else {
                                System.out.println("Libro no encontrado");
                            }
                        } else {
                            System.out.println("Usuario no encontrado");
                        }
                        break;

                    case 10:
                        System.out.println("Que libro es el que se va a devolver?");
                        String titulo = sc.nextLine();
                        if (biblio.terminar_Prestamo(titulo)) {
                            System.out.println("Libro devuelto");
                        }
                        break;
                    case 11:
                        System.out.println("Los libros actualmente prestados son:");
                        if (biblio.getPrestamos_Actuales() != null) {
                            Prestamo[] prestamosa = biblio.getPrestamos_Actuales();
                            for (int i = 0; i < prestamosa.length; i++) {
                                prestamosa[i].getLibros().mostrarLibros();
                            }
                        } else {
                            System.out.println("No hay préstamos actuales.");
                        }
                        break;
                    case 12:
                        System.out.println("El numero total de libros que se han prestado es de :");
                        int contador = 0;
                        Prestamo[] prestados = biblio.getPrestamos_Historicos();
                        if (prestados != null) {
                            for (int i = 0; i < prestados.length; i++) {
                                contador += prestados[i].getLibros().getLibrost().length;
                            }
                        }
                        System.out.println(contador);

                        System.out.println("Y el numero total de libros que  estan prestados es de :");
                        contador = 0;
                        prestados = biblio.getPrestamos_Actuales();
                        if (prestados != null) {
                            for (int i = 0; i < prestados.length; i++) {
                                contador += prestados[i].getLibros().getLibrost().length;
                            }
                        }
                        System.out.println(contador);
                        break;
                    case 13:
                        int tamaño = 0;
                        tamaño += biblio.libros.getLibrost().length;
                        Prestamo[] pre = biblio.getPrestamos_Actuales();
                        libro[] li = new libro[100];
                        int contl = 0;
                        if (pre != null) {
                            for (int i = 0; i < pre.length; i++) {
                                tamaño += pre[i].getLibros().getLibrost().length;
                                libro[] libaux = pre[i].getLibros().getLibrost();
                                int posActual = 0;
                                System.arraycopy(libaux, 0, li, posActual, libaux.length);
                                posActual += libaux.length;
                            }
                        }
                        for (int i = 0; i < li.length; i++) {
                            if (li[i].getNum_prestaciones() >= contl) {
                                contl = li[i].getNum_prestaciones();
                            }
                        }
                        System.out.println("El libro o libros que mas se ha prestado con un numero de presataciones: "
                                + contl + " y son :");
                        for (int i = 0; i < li.length; i++) {
                            if (li[i] != null && li[i].getNum_prestaciones() == contl) {
                                System.out.println(li[i].toString());
                            }
                        }

                        break;
                    case 14:
                        // usuario con mas prestamos activos
                        Prestamo[] prea = biblio.getPrestamos_Actuales();
                        if (prea != null) {
                            boolean enc = false;
                            int cuen = 0;
                            String[] listusu = new String[100]; // Array de usuarios únicos

                            for (int i = 0; i < listusu.length; i++) {
                                listusu[i] = null;
                            }

                            // Obtener usuarios únicos
                            for (int i = 0; i < prea.length; i++) {
                                enc = false;
                                String nombreUsuario = prea[i].getUsuario().getNombre();

                                // Verificar si el usuario ya está en el array
                                for (int j = 0; j < cuen; j++) {
                                    if (nombreUsuario.equals(listusu[j])) {
                                        enc = true;
                                        break;
                                    }
                                }

                                // Si no está en la lista, agregarlo
                                if (!enc && cuen < listusu.length) {
                                    listusu[cuen] = nombreUsuario;
                                    cuen++;
                                }
                            }

                            // Encontrar el número máximo de préstamos
                            int maxPrestamos = 0;
                            for (int i = 0; i < cuen; i++) {
                                if (listusu[i] != null) {
                                    int prestamosUsuario = biblio.buscarPrestamosActualesUsuario(listusu[i]).length;
                                    if (prestamosUsuario > maxPrestamos) {
                                        maxPrestamos = prestamosUsuario;
                                    }
                                }
                            }

                            // Imprimir usuarios con el máximo de préstamos
                            System.out.println(
                                    "Los usuarios con más libros prestados, con un total de " + maxPrestamos + " son:");
                            for (int i = 0; i < cuen; i++) {
                                if (listusu[i] != null
                                        && biblio.buscarPrestamosActualesUsuario(listusu[i]).length == maxPrestamos) {
                                    System.out.println(usuarios.buscarUsuario(listusu[i]));
                                }
                            }
                        }

                        break;

                    default:
                        funcionando = false;
                }
            } while (funcionando);
        } else {
            do {
                System.out.println("1: Cambiar Contraseña");
                System.out.println("2: Cambiar Datos");
                System.out.println("3: Buscar libro");// comp
                System.out.println("4: Libros disponibles"); // comp
                System.out.println("5: Realizar préstamos de libros");// comp
                System.out.println("6: Devolver libros prestados"); // ENRIQUE METE FUNCIÓN
                System.out.println("7: Salir");

                int numero = Integer.parseInt(sc.nextLine());
                switch (numero) {
                    case 1:
                        System.out.println(usuarios.cambiarContraseña(persona1.getNombre()));
                        break;
                    case 2:
                    System.out.println(usuarios.cambiarDatos(persona1.getNombre()));
                    break;
                    case 3:
                        boolean salir1 = true;
                        do {
                            System.out.println("¿Qué desea buscar?");
                            System.out.println("1: Buscar por título");
                            System.out.println("2: Buscar por autor");
                            System.out.println("3: Buscar por categoría");
                            System.out.println("4: Buscar por editorial");
                            System.out.println("5: Salir");
                            int numero1 = Integer.parseInt(sc.nextLine());

                            switch (numero1) {
                                case 1:
                                    System.out.println("Introduce un título");
                                    String tit1 = sc.nextLine();
                                    if (biblio.libros.buscarlibro(tit1) != null) {
                                        System.out.println(biblio.libros.buscarlibro(tit1).toString());
                                    } else {
                                        System.out.println("Libro no encontrado o prestado");
                                    }
                                    break;
                                case 2:
                                    System.out.println("Introduce un autor");
                                    tit1 = sc.nextLine();
                                    libro[] resultado = biblio.libros.buscarPorAutor(tit1);
                                    if (resultado != null) {
                                        for (int i = 0; i < resultado.length; i++) {
                                            System.out.println(resultado[i].toString());

                                        }
                                    } else {
                                        System.out.println("Libros no encontrados o prestados de ese autor");
                                    }
                                    break;
                                case 3:
                                    System.out.println("Introduce una categoría");
                                    tit1 = sc.nextLine();
                                    libro[] resultadoc = biblio.libros.buscarPorCategoria(tit1);
                                    if (resultadoc != null) {
                                        for (int i = 0; i < resultadoc.length; i++) {
                                            System.out.println(resultadoc[i].toString());

                                        }
                                    } else {
                                        System.out.println("Libros no encontrados o prestados de esa categoria");
                                    }
                                    break;
                                case 4:
                                    System.out.println("Introduce una editorial");
                                    tit1 = sc.nextLine();
                                    libro[] resultadoe = biblio.libros.buscarPorEditorial(tit1);
                                    if (resultadoe != null) {
                                        for (int i = 0; i < resultadoe.length; i++) {
                                            System.out.println(resultadoe[i].toString());

                                        }
                                    } else {
                                        System.out.println("Libros no encontrados o prestados de esa editorial");
                                    }
                                    break;
                                default:
                                    salir1 = false;
                            }
                        } while (salir1);
                        break;
                    case 4:
                        System.out.println("Los libros disponibles en la biblioteca son: ");
                        System.out.println(biblio.libros.toString());
                        break;
                    case 5:
                        String nombre = persona1.getNombre();
                        System.out.println("Que libro vas a prestar?");
                        String titulo = sc.nextLine();
                        if (biblio.libros.buscarlibro(titulo) != null) {
                            biblio.realizar_Prestamo(titulo, usuarios.buscarUsuario(nombre));
                        } else {
                            System.out.println("Libro no encontrado");
                        }

                        break;
                    case 6:
                        System.out.println("Que libro es el que se va a devolver?");
                        String titulo_devolver = sc.nextLine();
                        if (biblio.terminar_Prestamo(titulo_devolver)) {
                            System.out.println("Libro devuelto");
                        }
                        break;

                    default:
                        funcionando = false;
                }
            } while (funcionando);
        }
        // PARA PRUEBA
        /*
         * System.out.println(usuarios.listaUsuarios());
         * System.out.println(usuarios.listaTodaInfoUsurs());
         * System.out.println(g1.infoUsuario("pepe"));
         */


        sc.close();
    }

    public static void cargarBiblio() {

    }

    public static void meterDatosUsur(GestionUsuarios usuario) {
        usuario.añadirUsuario(new Usuario("Alberto", "1a2345", 36, 'H', "alberto1@gmail.com", 'A'));
        usuario.añadirUsuario(new Usuario("Beatriz", "2b3456", 28, 'M', "beatriz2@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Carlos", "3c4567", 40, 'H', "carlos3@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Diana", "4d5678", 25, 'M', "diana4@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Enrique", "5e6789", 31, 'H', "enrique5@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Fernanda", "6f7890", 27, 'M', "fernanda6@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Gustavo", "7g8901", 45, 'H', "gustavo7@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Helena", "8h9012", 33, 'M', "helena8@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Iván", "9i0123", 29, 'H', "ivan9@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Julia", "0j1234", 22, 'M', "julia0@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Kevin", "1k2345", 37, 'H', "kevin1@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Laura", "2l3456", 26, 'M', "laura2@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Miguel", "3m4567", 42, 'H', "miguel3@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Nora", "4n5678", 30, 'M', "nora4@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Oscar", "5o6789", 38, 'H', "oscar5@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Paula", "6p7890", 24, 'M', "paula6@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Quintín", "7q8901", 46, 'H', "quintin7@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Raquel", "8r9012", 32, 'M', "raquel8@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Sergio", "9s0123", 28, 'H', "sergio9@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Tamara", "0t1234", 23, 'M', "tamara0@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Ulises", "1u2345", 35, 'H', "ulises1@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Valeria", "2v3456", 29, 'M', "valeria2@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("William", "3w4567", 41, 'H', "william3@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Ximena", "4x5678", 27, 'M', "ximena4@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Yahir", "5y6789", 36, 'H', "yahir5@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Zoe", "6z7890", 21, 'M', "zoe6@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Andrés", "7a8901", 34, 'H', "andres7@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Bárbara", "8b9012", 25, 'M', "barbara8@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("César", "9c0123", 43, 'H', "cesar9@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Daniela", "0d1234", 30, 'M', "daniela0@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Eduardo", "1e2345", 39, 'H', "eduardo1@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Fabiola", "2f3456", 26, 'M', "fabiola2@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Gabriel", "3g4567", 31, 'H', "gabriel3@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Hilda", "4h5678", 28, 'M', "hilda4@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Ignacio", "5i6789", 44, 'H', "ignacio5@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Jimena", "6j7890", 23, 'M', "jimena6@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Karla", "7k8901", 35, 'M', "karla7@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Luis", "8l9012", 40, 'H', "luis8@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("María", "9m0123", 22, 'M', "maria9@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Nicolás", "0n1234", 29, 'H', "nicolas0@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Olga", "1o2345", 31, 'M', "olga1@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Pablo", "2p3456", 38, 'H', "pablo2@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Querida", "3q4567", 24, 'M', "querida3@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Ricardo", "4r5678", 36, 'H', "ricardo4@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Sara", "5s6789", 26, 'M', "sara5@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Tomás", "6t7890", 37, 'H', "tomas6@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Úrsula", "7u8901", 27, 'M', "ursula7@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Vicente", "8v9012", 34, 'H', "vicente8@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Wendy", "9w0123", 23, 'M', "wendy9@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Xavier", "0x1234", 42, 'H', "xavier0@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Yolanda", "1y2345", 28, 'M', "yolanda1@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Zacarías", "2z3456", 39, 'H', "zacarias2@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Andrea", "3a4567", 26, 'M', "andrea3@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Bernardo", "4b5678", 32, 'H', "bernardo4@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Claudia", "5c6789", 29, 'M', "claudia5@gmail.com", 'U'));
        usuario.añadirUsuario(new Usuario("Diego", "6d7890", 41, 'H', "diego6@gmail.com", 'U'));
    }

    public static void meterDatosLib(LibrosT lib) {
        lib.añadirLibro(new libro("La Metamorfosis", "7584999347524", "Novela", "Kafka", "Alianza", 90, 0));
        lib.añadirLibro(new libro("Cien Años de Soledad", "9788497592208", "Novela", "Gabriel García Márquez",
                "Sudamericana", 471, 0));
        lib.añadirLibro(new libro("1984", "9780451524935", "Distopía", "George Orwell", "Secker & Warburg", 328,
                0));
        lib.añadirLibro(new libro("Don Quijote", "9788491050080", "Clásico", "Miguel de Cervantes", "Espasa",
                1345, 0));
        lib.añadirLibro(new libro("El Principito", "9780156012195", "Fábula", "Antoine de Saint-Exupéry",
                "Reynal & Hitchcock", 96, 0));
        lib.añadirLibro(
                new libro("Fahrenheit 451", "9781451673319", "Distopía", "Ray Bradbury",
                        "Ballantine Books", 194, 0));
        lib.añadirLibro(new libro("Matar a un Ruiseñor", "9780061120084", "Drama", "Harper Lee",
                "J.B. Lippincott & Co.", 281, 0));
        lib.añadirLibro(
                new libro("Crimen y Castigo", "9788491051162", "Filosofía", "Fiódor Dostoyevski",
                        "Alianza", 671, 0));
        lib.añadirLibro(new libro("La Odisea", "9780140268867", "Épico", "Homero", "Penguin Classics", 541, 0));
        lib.añadirLibro(
                new libro("El Nombre de la Rosa", "9780156001311", "Misterio", "Umberto Eco",
                        "Harcourt", 512, 0));
        lib.añadirLibro(new libro("El Señor de los Anillos", "9780261103252", "Fantasía", "J.R.R. Tolkien",
                "George Allen & Unwin", 1178, 0));
        lib.añadirLibro(new libro("Drácula", "9780141439846", "Terror", "Bram Stoker", "Archibald Constable",
                418, 0));
        lib.añadirLibro(new libro("Frankenstein", "9780143131847", "Terror", "Mary Shelley",
                "Lackington, Hughes, Harding, Mavor & Jones", 280, 0));
        lib.añadirLibro(
                new libro("Orgullo y Prejuicio", "9780679783268", "Romance", "Jane Austen",
                        "T. Egerton", 279, 0));
        lib.añadirLibro(new libro("La Casa de los Espíritus", "9780553383805", "Drama", "Isabel Allende",
                "Plaza & Janés", 433, 0));
        lib.añadirLibro(new libro("Los Miserables", "9780140444308", "Histórico", "Victor Hugo",
                "A. Lacroix, Verboeckhoven & Cie.", 1463, 0));
        lib.añadirLibro(new libro("El Retrato de Dorian Gray", "9780141442464", "Filosofía", "Oscar Wilde",
                "Ward, Lock & Co.", 254, 0));
        lib.añadirLibro(new libro("Anna Karenina", "9780143035008", "Romance", "León Tolstói",
                "The Russian Messenger",
                864, 0));
        lib.añadirLibro(new libro("La Divina Comedia", "9780142437223", "Épico", "Dante Alighieri",
                "Niccolò di Lorenzo", 798, 0));
        lib.añadirLibro(new libro("El Guardián entre el Centeno", "9780316769488", "Drama", "J.D. Salinger",
                "Little, Brown and Company", 277, 0));
        lib.añadirLibro(
                new libro("Las Mil y Una Noches", "9780140449389", "Cuentos", "Anónimo",
                        "Sir Richard Burton", 720, 0));
        lib.añadirLibro(
                new libro("El Aleph", "9788490628112", "Cuentos", "Jorge Luis Borges",
                        "Editorial Losada", 174, 0));
        lib.añadirLibro(new libro("Rayuela", "9788497592208", "Novela", "Julio Cortázar", "Sudamericana", 736,
                0));
        lib.añadirLibro(
                new libro("Ensayo sobre la Ceguera", "9780156007752", "Drama", "José Saramago",
                        "Harcourt", 326, 0));
        lib.añadirLibro(new libro("La Peste", "9780679720217", "Filosofía", "Albert Camus", "Gallimard", 308,
                0));
        lib.añadirLibro(new libro("El Gran Gatsby", "9780743273565", "Drama", "F. Scott Fitzgerald",
                "Charles Scribner's Sons", 180, 0));
        lib.añadirLibro(new libro("Los Juegos del Hambre", "9780439023481", "Ficción", "Suzanne Collins",
                "Scholastic",
                374, 0));
        lib.añadirLibro(
                new libro("La Sombra del Viento", "9788495618771", "Misterio", "Carlos Ruiz Zafón",
                        "Planeta", 576, 0));
        lib.añadirLibro(new libro("It", "9781501142970", "Terror", "Stephen King", "Viking Press", 1138, 0));
        lib.añadirLibro(
                new libro("El Alquimista", "9780061122415", "Filosofía", "Paulo Coelho", "HarperTorch",
                        208, 0));
        lib.añadirLibro(new libro("El Perfume", "9780143129493", "Drama", "Patrick Süskind", "Diogenes", 255,
                0));
        lib.añadirLibro(
                new libro("Dune", "9780441172719", "Ciencia Ficción", "Frank Herbert", "Chilton Books",
                        412, 0));
        lib.añadirLibro(new libro("Harry Potter y la Piedra Filosofal", "9780747532743", "Fantasía",
                "J.K. Rowling",
                "Bloomsbury", 223, 0));
        lib.añadirLibro(new libro("Cumbres Borrascosas", "9780141439556", "Romance", "Emily Brontë",
                "Thomas Cautley Newby", 464, 0));
        lib.añadirLibro(
                new libro("El Hobbit", "9780547928227", "Fantasía", "J.R.R. Tolkien",
                        "George Allen & Unwin", 310, 0));
        lib.añadirLibro(new libro("El Silmarillion", "9780618391110", "Fantasía", "J.R.R. Tolkien",
                "George Allen & Unwin", 365, 0));
        lib.añadirLibro(new libro("La Historia Interminable", "9780140386332", "Fantasía", "Michael Ende",
                "Thienemann",
                396, 0));
        lib.añadirLibro(
                new libro("Memorias de una Geisha", "9780679781584", "Drama", "Arthur Golden", "Knopf",
                        428, 0));
        lib.añadirLibro(new libro("El Código Da Vinci", "9780385504201", "Misterio", "Dan Brown", "Doubleday",
                489, 0));
        lib.añadirLibro(
                new libro("Ángeles y Demonios", "9780743493468", "Misterio", "Dan Brown",
                        "Pocket Books", 616, 0));
        lib.añadirLibro(new libro("Inferno", "9780385537858", "Misterio", "Dan Brown", "Doubleday", 480, 0));
        lib.añadirLibro(
                new libro("El Psicoanalista", "9788466622703", "Suspenso", "John Katzenbach",
                        "Ediciones B", 528, 0));
        lib.añadirLibro(new libro("Juego de Tronos", "9780553103540", "Fantasía", "George R.R. Martin",
                "Bantam Books",
                694, 0));
        lib.añadirLibro(new libro("Choque de Reyes", "9780553108033", "Fantasía", "George R.R. Martin",
                "Bantam Books",
                768, 0));
        lib.añadirLibro(new libro("Tormenta de Espadas", "9780553106633", "Fantasía", "George R.R. Martin",
                "Bantam Books", 973, 0));
        lib.añadirLibro(new libro("Festín de Cuervos", "9780553801507", "Fantasía", "George R.R. Martin",
                "Bantam Books", 753, 0));
        lib.añadirLibro(new libro("Danza de Dragones", "9780553801477", "Fantasía", "George R.R. Martin",
                "Bantam Books", 1056, 0));
        lib.añadirLibro(new libro("Cazadores de Sombras", "9781416955078", "Fantasía", "Cassandra Clare",
                "Margaret K. McElderry Books", 485, 0));
        lib.añadirLibro(
                new libro("La Reina Roja", "9780062310644", "Fantasía", "Victoria Aveyard",
                        "HarperTeen", 388, 0));
        lib.añadirLibro(new libro("El Juego de Ender", "9780812550702", "Ciencia Ficción", "Orson Scott Card",
                "Tor Books", 324, 0));
        lib.añadirLibro(new libro("Ready Player One", "9780307887436", "Ciencia Ficción", "Ernest Cline",
                "Crown Publishing", 374, 0));
        lib.añadirLibro(new libro("Neuromante", "9780441569595", "Ciencia Ficción", "William Gibson", "Ace",
                271, 0));
        lib.añadirLibro(
                new libro("Snow Crash", "9780553380958", "Ciencia Ficción", "Neal Stephenson",
                        "Bantam Books", 440, 0));
        lib.añadirLibro(
                new libro("Fundación", "9780553293357", "Ciencia Ficción", "Isaac Asimov",
                        "Gnome Press", 244, 0));
        lib.añadirLibro(
                new libro("Yo, Robot", "9780553382563", "Ciencia Ficción", "Isaac Asimov",
                        "Gnome Press", 224, 0));
        lib.añadirLibro(new libro("Crónicas Marcianas", "9781451678193", "Ciencia Ficción", "Ray Bradbury",
                "Doubleday",
                222, 0));
        lib.añadirLibro(
                new libro("Un Mundo Feliz", "9780060850524", "Distopía", "Aldous Huxley",
                        "Chatto & Windus", 268, 0));
        lib.añadirLibro(new libro("La Máquina del Tiempo", "9780812505047", "Ciencia Ficción", "H.G. Wells",
                "Heinemann", 118, 0));
        lib.añadirLibro(new libro("El Hombre Invisible", "9780141389516", "Ciencia Ficción", "H.G. Wells",
                "C. Arthur Pearson", 149, 0));
        lib.añadirLibro(new libro("La Guerra de los Mundos", "9780345472043", "Ciencia Ficción", "H.G. Wells",
                "William Heinemann", 192, 0));
        lib.añadirLibro(new libro("La Isla del Tesoro", "9780141321004", "Aventura", "Robert Louis Stevenson",
                "Cassell & Company", 240, 0));
        lib.añadirLibro(new libro("20,000 Leguas de Viaje Submarino", "9780140390474", "Aventura",
                "Julio Verne",
                "Pierre-Jules Hetzel", 304, 0));
        lib.añadirLibro(new libro("Viaje al Centro de la Tierra", "9780141441979", "Aventura", "Julio Verne",
                "Pierre-Jules Hetzel", 183, 0));
        lib.añadirLibro(new libro("La Vuelta al Mundo en 80 Días", "9780140449068", "Aventura", "Julio Verne",
                "Pierre-Jules Hetzel", 195, 0));
        lib.añadirLibro(new libro("El Conde de Montecristo", "9780140449266", "Aventura", "Alexandre Dumas",
                "Pierre-Jules Hetzel", 1276, 0));
        lib.añadirLibro(
                new libro("Robin Hood", "9780140367004", "Aventura", "Howard Pyle",
                        "Charles Scribner's Sons", 320, 0));
        lib.añadirLibro(new libro("Las Aventuras de Tom Sawyer", "9780143039563", "Aventura", "Mark Twain",
                "Chatto & Windus", 274, 0));
        lib.añadirLibro(
                new libro("Moby Dick", "9780142437247", "Aventura", "Herman Melville",
                        "Richard Bentley", 704, 0));
    }
}
