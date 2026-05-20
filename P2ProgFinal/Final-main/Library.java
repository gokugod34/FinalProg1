public class Library {

    private String name;
    private LinkedList<Book> books;

    public Library(String name) {
        this.name = name;
        books = new LinkedList<Book>();
    }

    public void addBook(Book b) { 
        books.add(b); 
    }
    
    public void removeBook(Book b) { 
        books.remove(b); 
    }
    
    public Book getBookAt(int i) { 
        return books.get(i); 
    }
    
    public int getSize() { 
        return books.size(); 
    }

    public Book findBookByIsbn(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equalsIgnoreCase(isbn)) {
                return books.get(i);
            }
        }
        return null;
    }

    public LinkedList<Book> findBooksByTitle(String title) {
        LinkedList<Book> resultados = new LinkedList<Book>();
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                resultados.add(b);
            }
        }
        return resultados;
    }

    public LinkedList<Book> findBooksByAuthor(String author) {
        LinkedList<Book> resultados = new LinkedList<Book>();
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                resultados.add(b);
            }
        }
        return resultados;
    }

    public LinkedList<Book> getAvailableBooks() {
        LinkedList<Book> disponibles = new LinkedList<Book>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isAvailable()) {
                disponibles.add(books.get(i));
            }
        }
        return disponibles;
    }

    public LinkedList<Book> getLoanedBooks() {
        LinkedList<Book> prestados = new LinkedList<Book>();
        for (int i = 0; i < books.size(); i++) {
            if (!books.get(i).isAvailable()) {
                prestados.add(books.get(i));
            }
        }
        return prestados;
    }

    public void getStatistics() {
        System.out.println("Total libros: " + books.size());
        System.out.println("Libros disponibles: " + getAvailableBooks().size());
        System.out.println("Libros prestados: " + getLoanedBooks().size());
    }
}