import Filla01.FilaVetor;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        FilaVetor<String> fila =  c.extrairTermos("(5+6)*(3+3)*(32)");
        FilaVetor<String> filaPosFixada  = c.gerarEsprPosfixada(fila);
        System.out.println("Resultado: "+c.calcularExprPosfixada(filaPosFixada));
    }
}
