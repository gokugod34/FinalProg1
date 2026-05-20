public class Queue<T> {

    private LinkedList<T> datos;

    public Queue() {
        datos = new LinkedList<T>();
    }

    public void enqueue(T elem) {
        datos.add(elem);
    }

    public T dequeue() {
        if (datos.isEmpty()) {
            return null;
        }
        T primero = datos.get(0);
        datos.remove(primero);
        return primero;
    }

    public T peek() {
        if (datos.isEmpty()) {
            return null;
        }
        return datos.get(0);
    }

    public boolean isEmpty() {
        return datos.isEmpty();
    }
}