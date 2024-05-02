import Filla01.FilaVetor;

public class Main {
    public static void main(String[] args) {
        Calculadora c = new Calculadora();
        FilaVetor<String> fila =  c.extrairTermos("-2+6");
        FilaVetor<String> filaPosFixada  = c.gerarEsprPosfixada(fila);
        System.out.println(c.calcularExprPosfixada(filaPosFixada));
    }
}
