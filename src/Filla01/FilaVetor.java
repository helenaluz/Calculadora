package Filla01;
import java.util.Arrays;

public class FilaVetor<T> implements  Fila{
    private Object[] info;
    private int limite;
    private int tamanho;
    private int inicio;

    public FilaVetor(int limite){
        this.limite = limite;
        info = (T[]) new Object[limite];
        this.tamanho = 0;
        this.inicio = 0;
    }
    @Override
    public void inserir(Object valor) {
        if(limite == tamanho){
            throw new RuntimeException("Fila está cheia");
        }
            int posicaoInserir = (this.inicio + this.tamanho) % this.limite;
            info[posicaoInserir] = valor;
            tamanho++;
        }

    @Override
    public boolean estavazia() {
        return tamanho == 0;
    }
    @Override
    public T peek() {
        if(estavazia()) {
            throw new RuntimeException("Fila está vazia");
        }
        return (T)  info[inicio];
    }
    @Override
    public T retirar() {
        if(estavazia()) {
            throw new RuntimeException("Fila está vazia");
        }
        T valor = peek();
        inicio = (inicio+1)%limite;
        tamanho--;
        return valor;
    }
    @Override
    public void liberar() {
        for (Object X: info
             ) {
            retirar();
        }
    }
    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
        FilaVetor<T> f3 = new FilaVetor<T>(this.limite + f2.limite);
        for (int i = inicio; i < info.length; i++) {
            if (info[i] != null) f3.inserir(info[i]);
        }
        for (int i = f2.inicio; i < f2.info.length; i++) {
            if (f2.info[i] != null) f3.inserir(f2.info[i]);
        }
        return f3;
    }

    @Override
    public String toString() {
        StringBuilder minhaString = new StringBuilder();
        for (int i = inicio; i < info.length; i++) {
            if (info[i] != null) minhaString.append(info[i] + "| ");
        }
        return minhaString.toString();
    }

    public int getLimite(){
        return limite;
    }
}
