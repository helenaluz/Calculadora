import Filla01.*;
import Pilha01.PilhaVetor;

public class Calculadora {
    public FilaVetor<String> extrairTermos(String expressao) {
        FilaVetor<String> fila = new FilaVetor<>(expressao.length());

        expressao = expressao.replaceAll("\\s", "");
        expressao = expressao.replace(",", ".");

        StringBuilder termoAtual = new StringBuilder();

        for (int i = 0; i < expressao.length(); i++) {
            char caractere = expressao.charAt(i);

            if (caractere == '-' && (i == 0 || isOperador(expressao.charAt(i - 1)) || expressao.charAt(i - 1) == '(')) {
                termoAtual.append(caractere);
            } else if (isOperador(caractere) || caractere == '(' || caractere == ')') {
                if (termoAtual.length() > 0) {
                    fila.inserir(termoAtual.toString());
                    termoAtual.setLength(0);
                }
                fila.inserir(String.valueOf(caractere));
            } else {
                termoAtual.append(caractere);
            }
        }

        if (termoAtual.length() > 0) {
            fila.inserir(termoAtual.toString());
        }

        return fila;
    }

    public FilaVetor<String> gerarEsprPosfixada(FilaVetor<String> esprInfixada) {
        FilaVetor<String> filaC = new FilaVetor<>(esprInfixada.getLimite());
        PilhaVetor<String> pilhaB = new PilhaVetor<>(esprInfixada.getLimite());

        while (!esprInfixada.estavazia()) {
            String termo = esprInfixada.retirar();
            if (termo != null) {
                if (isOperando(termo)) {
                    filaC.inserir(termo);
                } else if (termo.equals("(")) {
                    pilhaB.push(termo);
                } else if (termo.equals(")")) {
                    while (!pilhaB.estaVazia() && !pilhaB.peek().equals("(")) {
                        filaC.inserir(pilhaB.pop());
                    }
                    pilhaB.pop();
                } else {
                    while (!pilhaB.estaVazia() && precedencia(termo) <= precedencia(pilhaB.peek())) {
                        filaC.inserir(pilhaB.pop());
                    }
                    pilhaB.push(termo);
                }
            }
        }

        while (!pilhaB.estaVazia()) {
            filaC.inserir(pilhaB.pop());
        }

        return filaC;
    }

    public String calcularExprPosfixada(FilaVetor<String> exprPosfixada) {
        PilhaVetor<Double> pilhaAuxiliar = new PilhaVetor<>(exprPosfixada.getLimite());

        while (!exprPosfixada.estavazia()) {
            String termo = exprPosfixada.retirar();
            if (isOperando(termo)) {
                double operando = Double.parseDouble(termo);
                pilhaAuxiliar.push(operando);
            } else {
                double operand2 = pilhaAuxiliar.pop();
                double operand1 = pilhaAuxiliar.pop();
                double resultado = aplicarOperador(operand1, operand2, termo);
                pilhaAuxiliar.push(resultado);
            }
        }

        return pilhaAuxiliar.pop().toString().replace(".", ",");
    }

    private double aplicarOperador(double operand1, double operand2, String operador) {
        switch (operador) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Divisão por zero não é permitida");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Operador inválido: " + operador);
        }
    }
    private boolean isOperando(String termo) {
        try {
            Double.parseDouble(termo);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int precedencia(String operador) {
        switch (operador) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }

    private boolean isOperador(char caractere) {
        return caractere == '+' || caractere == '-' || caractere == '*' || caractere == '/';
    }
}
