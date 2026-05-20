public class Stack<T> {

    private LinkedList<T> lista;

    public Stack() {
        lista = new LinkedList<T>();
    }

    public void push(T elemento) {
        lista.add(elemento);
    }

    public T pop() {
        T aux = lista.get(lista.size()-1);
        lista.remove(aux);
        return aux;
    }

    public T peek() {
        return lista.get(lista.size()-1);
    }

    public boolean isEmpty() {
        return lista.size() == 0;
    }
}