package Pilha02;

public class PilhaVetor<T> implements Pilha<T> {
    private ListaDupla<T> lista;

    public PilhaVetor() {
        lista = new ListaDupla<>();
    }

    @Override
    public void push(T elemento) {
        lista.inserir(elemento);
    }

    @Override
    public T pop() {
        if (estaVazia()) throw new RuntimeException("Pilha está vazia");
        T elemento = lista.getPrimeiro().getInfo();
        lista.retirar(elemento);
        return elemento;
    }

    @Override
    public T peek() {
        if (estaVazia()) throw new RuntimeException("Pilha está vazia");
        return lista.getPrimeiro().getInfo();
    }

    @Override
    public boolean estaVazia() {
        return lista.getPrimeiro().getInfo() == null;
    }

    @Override
    public void liberar() {
        lista.liberar();
    }

    @Override
    public String toString() {
        return lista.toString();
    }
}
