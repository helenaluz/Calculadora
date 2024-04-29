import Filla01.*;
public class Calculadora {
    public FilaVetor<String> extrairTermos(String expressao) {
        FilaVetor<String> fila = new FilaVetor<>(expressao.length());

        expressao = expressao.replaceAll("\\s", "");

        StringBuilder termoAtual = new StringBuilder();

        for (char caractere : expressao.toCharArray()) {
            if (isOperador(caractere) || caractere == '(' || caractere == ')') {
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

    private boolean isOperador(char caractere) {
        return caractere == '+' || caractere == '-' || caractere == '*' || caractere == '/';
    }

}
