public class LinkedList<T> {

    private Node<T> head;
    private int size;
/**
     * Crea una lista vacía.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }
/**
     * Agrega un elemento al final de la lista.
     * @param data Elemento a insertar.
     */
    public void add(T data) {
        Node<T> n = new Node<T>(data);
        if (head == null) {
            head = n;
        } else {
            Node<T> aux = head;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(n);
        }
size++;
    }
/**
     * Elimina la primera ocurrencia de un elemento en la lista.
     * @param data Elemento a eliminar.
     */

    /**
     * Retorna el elemento que se encuentra en la posición dada.
     * @param index Índice del elemento solicitado (0 <= index < size)
     * @return Elemento encontrado o null si el índice es inválido.
     */

    /**
     * Obtiene la cantidad de elementos almacenados.
     * @return tamaño actual de la lista.
     */
    public boolean contains(T data) {
        Node<T> aux = head;
        while (aux != null) {
            if (aux.getData().equals(data)) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        int contador = 0;
        Node<T> aux = head;
        while (contador < index) {
            aux = aux.getNext();
            contador++;
        }
        return aux.getData();
    }

    public void remove(T data) {
        if (head == null) {
            return;
        }
        if (head.getData().equals(data)) {
            head = head.getNext();
            size--;
            return;
        }
        Node<T> aux = head;
        while (aux.getNext() != null) {
            if (aux.getNext().getData().equals(data)) {
                aux.setNext(aux.getNext().getNext());
                size--;
                return;
            }
            aux = aux.getNext();
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void clear() {
        head = null;
        size = 0;
    }
}