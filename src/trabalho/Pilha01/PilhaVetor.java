package trabalho.Pilha01;

import java.util.Arrays;

public class PilhaVetor<T> implements Pilha<T> {
    private T[] info;
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite){
        if (limite <= 0) throw new IllegalArgumentException("Limite inválido para a pilha");
        this.info = (T[]) new Object[limite];
        this.limite = limite;
        this.tamanho = 0;
    }

    @Override
    public void push(T elemento) {
        if (tamanho == limite) throw new RuntimeException("Capacidade esgotada da pilha");
        info[tamanho++] = elemento;
    }

    @Override
    public T pop() {
        if (estaVazia()) throw new RuntimeException("Exercicio01.Pilha está vazia");
        return info[--tamanho];
    }

    @Override
    public T peek() {
        if (estaVazia()) throw new RuntimeException("Exercicio01.Pilha está vazia");
        return info[tamanho - 1];
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void liberar() {
        Arrays.fill(info, null);
        tamanho = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            sb.append(info[i]);
            if (i < tamanho - 1) sb.append(",");
        }
        return sb.toString();
    }

    public void concatenar(PilhaVetor<T> pilha) {
        if (tamanho + pilha.tamanho > limite)
            throw new RuntimeException("Exercicio01.Pilha com tamanho insuficiente para essa operação");
        for (int i = 0; i < pilha.tamanho; i++) {
            push(pilha.info[i]);
        }
    }
}
