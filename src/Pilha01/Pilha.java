package Pilha01;

public interface Pilha<T> {
    public void push(T info);
    public T pop();
    public T peek();
    boolean estaVazia();
    public void liberar();
}
