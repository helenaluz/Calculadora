package Filla01;
public interface Fila<T> {

    public void inserir (T valor);
    public boolean estavazia();
    public T peek();
    public T  retirar();
    public void liberar();
}
