public class Book {

    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    private boolean available;
    private int timesLoaned;
    private Queue<String> colaEspera;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = 0;
        this.available = true;
        this.timesLoaned = 0;
        this.colaEspera = new Queue<String>();
    }

    public String getTitle() { 
        return title; 
    }
    public String getAuthor() { 
        return author; 
    }
    public String getIsbn() { 
        return isbn; 
    }
    public int getPublicationYear() { 
        return publicationYear; 
    }
    public boolean isAvailable() { 
        return available; 
    }
    public int getTimesLoaned() { 
        return timesLoaned;
    }

    public void setTitle(String t) { 
        title = t; 
    }
    public void setAuthor(String a) { 
        author = a; 
    }
    public void setIsbn(String i) { 
        isbn = i; 
    }
    public void setPublicationYear(int y) { 
        publicationYear = y; 
    }

    public void lend() {
        if (available) {
            available = false;
            timesLoaned++;
        }
    }

    public void returnBook() {
        available = true;
    }

    public void agregarEspera(String usuario) {
        colaEspera.enqueue(usuario);
    }

    public String verPrimerEspera() {
        return colaEspera.peek();
    }

    public void prestarSiguiente() {
        if (!colaEspera.isEmpty() && available) {
            String usuario = colaEspera.dequeue();
            lend();
            System.out.println("Libro asignado a: " + usuario);
        }
    }

    public String toString() {
        return "Titulo: " + title + " | Autor: " + author + " | ISBN: " + isbn + " | Disponible: " + available;
    }
}