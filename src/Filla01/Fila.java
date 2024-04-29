package Filla01;
public interface Fila<T> {

    public void inserir (T valor);
    public boolean estavazia();
    public T peek();
    public void  retirar();
    public void liberar();
}
