package Pilha02;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
     PilhaVetor<String> pilha = new PilhaVetor<>();
        System.out.println(pilha.estaVazia());
        pilha.push("Oii");
        pilha.push("Tchau");
        pilha.push("tchau");
        System.out.println(pilha.toString());
        System.out.println(pilha.peek());
        pilha.pop();
        System.out.println(pilha.toString());
        System.out.println(pilha.peek());

     PilhaVetor<String> pilhaDois = new PilhaVetor<>();
        pilhaDois.push("Blehh");
        pilhaDois.push("Bluuu");
        pilhaDois.push("Nliiii");
        System.out.println(pilha.toString());
        System.out.println(pilha.peek());
    }
}