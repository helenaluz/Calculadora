package trabalho.Pilha02;

public class ListaDupla<T> {
    private NoListaDupla<T> primeiro;

    public ListaDupla() {
        primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T info) {
        NoListaDupla<T> novo = new NoListaDupla<T>();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        novo.setAnterior(null);
        if (primeiro != null) {
            primeiro.setAnterior(novo);
        }
        primeiro = novo;
    }

    public NoListaDupla<T> buscar(T info) {
        NoListaDupla<T> p = primeiro;
        while (p != null) {
            if (p.getInfo().equals(info)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    public void retirar(T info) {
        NoListaDupla<T> p = buscar(info);
        if (p != null) {
            if (p.getAnterior() != null) {
                p.getAnterior().setProximo(p.getProximo());
            } else {
                primeiro = p.getProximo();
            }
            if (p.getProximo() != null) p.getProximo().setAnterior(p.getAnterior());
        }
    }

    public void exibirOrdemInversa() {
        NoListaDupla<T> ultimo = obterUltimo();
        while (ultimo != null) {
            System.out.println(ultimo.getInfo());
            ultimo = ultimo.getAnterior();
        }
    }

    public void liberar() {
        NoListaDupla<T> p = primeiro;
        while (p != null) {
            NoListaDupla<T> temp = p.getProximo();
            p.setAnterior(null);
            p.setProximo(null);
            p = temp;
        }
        primeiro = null;
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        NoListaDupla<T> p = primeiro;
        while (p != null) {
            if (retorno.length() > 0) {
                retorno.append(", ");
            }
            retorno.append(p.getInfo().toString());
            p = p.getProximo();
        }
        return retorno.toString();
    }

    private NoListaDupla<T> obterUltimo() {
        NoListaDupla<T> p = primeiro;
        while (p != null && p.getProximo() != null) {
            p = p.getProximo();
        }
        return p;
    }
}
