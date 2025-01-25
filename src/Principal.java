import java.util.Scanner;

public class Principal {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception { // CUANDO YA INICIAS SESIÓN Y TE METES EN CUALQUIER MENÚ,
                                                              // SI SALES TE SALES ENTERO DEL PROGRAMA. ME GUSTARÍA QUE
                                                              // VOLVIERA AL PRINCIPIO DEL TODO POR SI QUIERES INICIAR
                                                              // SESIÓN CON OTRO USUARIO O SALIRTE.
        GestionUsuarios usuarios = new GestionUsuarios();
        LibrosT libros = new LibrosT();
        boolean funcionando = true;
        meterDatosUsur(usuarios);
        Usuario persona1 = usuarios.inicioSesion();
        if (persona1.getTipo() == 'A') {
            do {
                System.out.println("1: Agregar libro nuevo");
                System.out.println("2: Eliminar libro");
                System.out.println("3: Actualizar libro");
                System.out.println("4: Buscar libro");
                System.out.println("5: Libros disponibles"); // ENRIQUE AÑADE FUNCIÓN
                System.out.println("6: Registrar Nuevo usuario");
                System.out.println("7: Eliminar usuario");
                System.out.println("8: Consultar información de usuario");
                System.out.println("9: Realizar préstamos de libros");// ENRIQUE METE FUNCIÓN
                System.out.println("10: Devolver libros prestados"); // ENRIQUE METE FUNCIÓN
                System.out.println("11: Mostrar libros actualmente prestados"); // ENRIQUE METE FUNCIÓN
                System.out.println("12: Mostrar número totales de libros prestados y activos");// ENRIQUE METE FUNCIÓN
                System.out.println("13: Lista libros más prestados"); // ENRIQUE METE FUNCIÓN
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
                        libros.añadirLibro(l);
                        System.out.println("Se ha añadido un libro nuevo");
                        break;
                    case 2:
                        System.out.println("Introduce el título del libro a borrar");
                        String lib = sc.nextLine();
                        libros.eliminarLibro(lib);
                        break;
                    case 3:
                        libro l1 = new libro();
                        System.out.println("Introduce el título");
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
                        num1 = Integer.parseInt(sc.nextLine());
                        l1.setNum_prestaciones(num1);
                        libros.actualizarLibro(datos1, l1);
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
                                    System.out.println(libros.buscarlibro(tit1));
                                    break;
                                case 2:
                                    System.out.println("Introduce un autor");
                                    tit1 = sc.nextLine();
                                    System.out.println(libros.buscarPorAutor(tit1));
                                    break;
                                case 3:
                                    System.out.println("Introduce un título");
                                    tit1 = sc.nextLine();
                                    System.out.println(libros.buscarPorCategoria(tit1));
                                    break;
                                case 4:
                                    System.out.println("Introduce una editorial");
                                    tit1 = sc.nextLine();
                                    System.out.println(libros.buscarPorEditorial(tit1));
                                    break;
                                default:
                                    salir1 = false;
                            }
                        } while (salir1);
                        break;
                    case 5:
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
        } else {
            do {

                System.out.println("1: Cambiar Contraseña");
                System.out.println("2: Buscar libro");
                System.out.println("3: Libros disponibles"); // ENRIQUE AÑADE FUNCIÓN
                System.out.println("4: Realizar préstamos de libros");// ENRIQUE METE FUNCIÓN
                System.out.println("5: Devolver libros prestados"); // ENRIQUE METE FUNCIÓN
                System.out.println("6: Salir");

                int numero = Integer.parseInt(sc.nextLine());
                switch (numero) {
                    case 1:
                        System.out.println(usuarios.cambiarContraseña(persona1.getNombre()));
                        break;
                    case 2:
                        boolean salir2 = true;
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
                                    System.out.println(libros.buscarlibro(tit1));
                                    break;
                                case 2:
                                    System.out.println("Introduce un autor");
                                    tit1 = sc.nextLine();
                                    System.out.println(libros.buscarPorAutor(tit1));
                                    break;
                                case 3:
                                    System.out.println("Introduce un título");
                                    tit1 = sc.nextLine();
                                    System.out.println(libros.buscarPorCategoria(tit1));
                                    break;
                                case 4:
                                    System.out.println("Introduce una editorial");
                                    tit1 = sc.nextLine();
                                    System.out.println(libros.buscarPorEditorial(tit1));
                                    break;
                                default:
                                    salir2 = false;
                            }
                        } while (salir2);
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
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

    public static void meterDatosUsur(GestionUsuarios usuario) {
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

    public static void meterDatosLib(LibrosT lib) {
        lib.añadirLibro(new libro("La Metamorfosis", "7584999347524", "Novela", "Kafka", "Alianza", 90, 0));
        lib.añadirLibro(new libro("Cien Años de Soledad", "9788497592208", "Novela", "Gabriel García Márquez",
                "Sudamericana", 471, 0));
        lib.añadirLibro(new libro("1984", "9780451524935", "Distopía", "George Orwell", "Secker & Warburg", 328, 0));
        lib.añadirLibro(new libro("Don Quijote", "9788491050080", "Clásico", "Miguel de Cervantes", "Espasa", 1345, 0));
        lib.añadirLibro(new libro("El Principito", "9780156012195", "Fábula", "Antoine de Saint-Exupéry",
                "Reynal & Hitchcock", 96, 0));
        lib.añadirLibro(
                new libro("Fahrenheit 451", "9781451673319", "Distopía", "Ray Bradbury", "Ballantine Books", 194, 0));
        lib.añadirLibro(new libro("Matar a un Ruiseñor", "9780061120084", "Drama", "Harper Lee",
                "J.B. Lippincott & Co.", 281, 0));
        lib.añadirLibro(
                new libro("Crimen y Castigo", "9788491051162", "Filosofía", "Fiódor Dostoyevski", "Alianza", 671, 0));
        lib.añadirLibro(new libro("La Odisea", "9780140268867", "Épico", "Homero", "Penguin Classics", 541, 0));
        lib.añadirLibro(
                new libro("El Nombre de la Rosa", "9780156001311", "Misterio", "Umberto Eco", "Harcourt", 512, 0));
        lib.añadirLibro(new libro("El Señor de los Anillos", "9780261103252", "Fantasía", "J.R.R. Tolkien",
                "George Allen & Unwin", 1178, 0));
        lib.añadirLibro(new libro("Drácula", "9780141439846", "Terror", "Bram Stoker", "Archibald Constable", 418, 0));
        lib.añadirLibro(new libro("Frankenstein", "9780143131847", "Terror", "Mary Shelley",
                "Lackington, Hughes, Harding, Mavor & Jones", 280, 0));
        lib.añadirLibro(
                new libro("Orgullo y Prejuicio", "9780679783268", "Romance", "Jane Austen", "T. Egerton", 279, 0));
        lib.añadirLibro(new libro("La Casa de los Espíritus", "9780553383805", "Drama", "Isabel Allende",
                "Plaza & Janés", 433, 0));
        lib.añadirLibro(new libro("Los Miserables", "9780140444308", "Histórico", "Victor Hugo",
                "A. Lacroix, Verboeckhoven & Cie.", 1463, 0));
        lib.añadirLibro(new libro("El Retrato de Dorian Gray", "9780141442464", "Filosofía", "Oscar Wilde",
                "Ward, Lock & Co.", 254, 0));
        lib.añadirLibro(new libro("Anna Karenina", "9780143035008", "Romance", "León Tolstói", "The Russian Messenger",
                864, 0));
        lib.añadirLibro(new libro("La Divina Comedia", "9780142437223", "Épico", "Dante Alighieri",
                "Niccolò di Lorenzo", 798, 0));
        lib.añadirLibro(new libro("El Guardián entre el Centeno", "9780316769488", "Drama", "J.D. Salinger",
                "Little, Brown and Company", 277, 0));
        lib.añadirLibro(
                new libro("Las Mil y Una Noches", "9780140449389", "Cuentos", "Anónimo", "Sir Richard Burton", 720, 0));
        lib.añadirLibro(
                new libro("El Aleph", "9788490628112", "Cuentos", "Jorge Luis Borges", "Editorial Losada", 174, 0));
        lib.añadirLibro(new libro("Rayuela", "9788497592208", "Novela", "Julio Cortázar", "Sudamericana", 736, 0));
        lib.añadirLibro(
                new libro("Ensayo sobre la Ceguera", "9780156007752", "Drama", "José Saramago", "Harcourt", 326, 0));
        lib.añadirLibro(new libro("La Peste", "9780679720217", "Filosofía", "Albert Camus", "Gallimard", 308, 0));
        lib.añadirLibro(new libro("El Gran Gatsby", "9780743273565", "Drama", "F. Scott Fitzgerald",
                "Charles Scribner's Sons", 180, 0));
        lib.añadirLibro(new libro("Los Juegos del Hambre", "9780439023481", "Ficción", "Suzanne Collins", "Scholastic",
                374, 0));
        lib.añadirLibro(
                new libro("La Sombra del Viento", "9788495618771", "Misterio", "Carlos Ruiz Zafón", "Planeta", 576, 0));
        lib.añadirLibro(new libro("It", "9781501142970", "Terror", "Stephen King", "Viking Press", 1138, 0));
        lib.añadirLibro(
                new libro("El Alquimista", "9780061122415", "Filosofía", "Paulo Coelho", "HarperTorch", 208, 0));
        lib.añadirLibro(new libro("El Perfume", "9780143129493", "Drama", "Patrick Süskind", "Diogenes", 255, 0));
        lib.añadirLibro(
                new libro("Dune", "9780441172719", "Ciencia Ficción", "Frank Herbert", "Chilton Books", 412, 0));
        lib.añadirLibro(new libro("Harry Potter y la Piedra Filosofal", "9780747532743", "Fantasía", "J.K. Rowling",
                "Bloomsbury", 223, 0));
        lib.añadirLibro(new libro("Cumbres Borrascosas", "9780141439556", "Romance", "Emily Brontë",
                "Thomas Cautley Newby", 464, 0));
        lib.añadirLibro(
                new libro("El Hobbit", "9780547928227", "Fantasía", "J.R.R. Tolkien", "George Allen & Unwin", 310, 0));
        lib.añadirLibro(new libro("El Silmarillion", "9780618391110", "Fantasía", "J.R.R. Tolkien",
                "George Allen & Unwin", 365, 0));
        lib.añadirLibro(new libro("La Historia Interminable", "9780140386332", "Fantasía", "Michael Ende", "Thienemann",
                396, 0));
        lib.añadirLibro(
                new libro("Memorias de una Geisha", "9780679781584", "Drama", "Arthur Golden", "Knopf", 428, 0));
        lib.añadirLibro(new libro("El Código Da Vinci", "9780385504201", "Misterio", "Dan Brown", "Doubleday", 489, 0));
        lib.añadirLibro(
                new libro("Ángeles y Demonios", "9780743493468", "Misterio", "Dan Brown", "Pocket Books", 616, 0));
        lib.añadirLibro(new libro("Inferno", "9780385537858", "Misterio", "Dan Brown", "Doubleday", 480, 0));
        lib.añadirLibro(
                new libro("El Psicoanalista", "9788466622703", "Suspenso", "John Katzenbach", "Ediciones B", 528, 0));
        lib.añadirLibro(new libro("Juego de Tronos", "9780553103540", "Fantasía", "George R.R. Martin", "Bantam Books",
                694, 0));
        lib.añadirLibro(new libro("Choque de Reyes", "9780553108033", "Fantasía", "George R.R. Martin", "Bantam Books",
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
                new libro("La Reina Roja", "9780062310644", "Fantasía", "Victoria Aveyard", "HarperTeen", 388, 0));
        lib.añadirLibro(new libro("El Juego de Ender", "9780812550702", "Ciencia Ficción", "Orson Scott Card",
                "Tor Books", 324, 0));
        lib.añadirLibro(new libro("Ready Player One", "9780307887436", "Ciencia Ficción", "Ernest Cline",
                "Crown Publishing", 374, 0));
        lib.añadirLibro(new libro("Neuromante", "9780441569595", "Ciencia Ficción", "William Gibson", "Ace", 271, 0));
        lib.añadirLibro(
                new libro("Snow Crash", "9780553380958", "Ciencia Ficción", "Neal Stephenson", "Bantam Books", 440, 0));
        lib.añadirLibro(
                new libro("Fundación", "9780553293357", "Ciencia Ficción", "Isaac Asimov", "Gnome Press", 244, 0));
        lib.añadirLibro(
                new libro("Yo, Robot", "9780553382563", "Ciencia Ficción", "Isaac Asimov", "Gnome Press", 224, 0));
        lib.añadirLibro(new libro("Crónicas Marcianas", "9781451678193", "Ciencia Ficción", "Ray Bradbury", "Doubleday",
                222, 0));
        lib.añadirLibro(
                new libro("Un Mundo Feliz", "9780060850524", "Distopía", "Aldous Huxley", "Chatto & Windus", 268, 0));
        lib.añadirLibro(new libro("La Máquina del Tiempo", "9780812505047", "Ciencia Ficción", "H.G. Wells",
                "Heinemann", 118, 0));
        lib.añadirLibro(new libro("El Hombre Invisible", "9780141389516", "Ciencia Ficción", "H.G. Wells",
                "C. Arthur Pearson", 149, 0));
        lib.añadirLibro(new libro("La Guerra de los Mundos", "9780345472043", "Ciencia Ficción", "H.G. Wells",
                "William Heinemann", 192, 0));
        lib.añadirLibro(new libro("La Isla del Tesoro", "9780141321004", "Aventura", "Robert Louis Stevenson",
                "Cassell & Company", 240, 0));
        lib.añadirLibro(new libro("20,000 Leguas de Viaje Submarino", "9780140390474", "Aventura", "Julio Verne",
                "Pierre-Jules Hetzel", 304, 0));
        lib.añadirLibro(new libro("Viaje al Centro de la Tierra", "9780141441979", "Aventura", "Julio Verne",
                "Pierre-Jules Hetzel", 183, 0));
        lib.añadirLibro(new libro("La Vuelta al Mundo en 80 Días", "9780140449068", "Aventura", "Julio Verne",
                "Pierre-Jules Hetzel", 195, 0));
        lib.añadirLibro(new libro("El Conde de Montecristo", "9780140449266", "Aventura", "Alexandre Dumas",
                "Pierre-Jules Hetzel", 1276, 0));
        lib.añadirLibro(
                new libro("Robin Hood", "9780140367004", "Aventura", "Howard Pyle", "Charles Scribner's Sons", 320, 0));
        lib.añadirLibro(new libro("Las Aventuras de Tom Sawyer", "9780143039563", "Aventura", "Mark Twain",
                "Chatto & Windus", 274, 0));
        lib.añadirLibro(
                new libro("Moby Dick", "9780142437247", "Aventura", "Herman Melville", "Richard Bentley", 704, 0));
    }
}
