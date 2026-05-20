public class Main {

    public static void main(String[] args) {

        Library biblioteca = new Library("Biblioteca Central");
        Stack<Book> historialPrestamos = new Stack<Book>();

        Book libro1 = new Book("Introduccion a Java", "Programador X", "111");
        Book libro2 = new Book("Patrones de Disenio", "Gang of Four", "222");
        Book libro3 = new Book("Logica Estructurada", "Alonzo Church", "333");
        
        biblioteca.addBook(libro1);
        biblioteca.addBook(libro2);
        biblioteca.addBook(libro3);

        System.out.println("--- PRUEBA DE BUSQUEDAS FLEXIBLES ---");
        LinkedList<Book> busquedaTitulo = biblioteca.findBooksByTitle("java");
        for (int i = 0; i < busquedaTitulo.size(); i++) {
            System.out.println("Encontrado por titulo: " + busquedaTitulo.get(i).getTitle());
        }

        LinkedList<Book> busquedaAutor = biblioteca.findBooksByAuthor("Gang");
        for (int i = 0; i < busquedaAutor.size(); i++) {
            System.out.println("Encontrado por autor: " + busquedaAutor.get(i).getTitle());
        }

        System.out.println("\n--- PRUEBA DE PRESTAMOS Y HISTORIAL (STACK) ---");
        libro1.lend();
        historialPrestamos.push(libro1);
        System.out.println("Se presto el libro: " + libro1.getTitle());

        System.out.println("\n--- PRUEBA DE COLA DE ESPERA (QUEUE) ---");
        libro1.agregarEspera("Lorenzo Sanabria");
        libro1.agregarEspera("Maria Fernandez");
        System.out.println("Primer usuario en espera: " + libro1.verPrimerEspera());

        System.out.println("\n--- DEVOLUCION Y ASIGNACION AUTOMATICA ---");
        libro1.returnBook();
        libro1.prestarSiguiente();
        historialPrestamos.push(libro1);

        System.out.println("\n--- DESHACER ULTIMO PRESTAMO (POP) ---");
        if (!historialPrestamos.isEmpty()) {
            Book ultimo = historialPrestamos.pop();
            ultimo.returnBook();
            System.out.println("Se desizo el prestamo erroneo de: " + ultimo.getTitle());
        }

        System.out.println("\n--- ESTADISTICAS REALES DEL SISTEMA ---");
        biblioteca.getStatistics();
    }
}