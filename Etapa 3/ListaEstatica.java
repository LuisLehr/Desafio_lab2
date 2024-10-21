public class ListaEstatica<E> {
    private E[] elementos;
    private int tamanho;

    //Construtor que inicializa a lista com a capacidade especificada.
    @SuppressWarnings("unchecked")
    public ListaEstatica(int capacidade) {
        elementos = (E[]) new Object[capacidade];
        tamanho = 0;
    }
 
    // Adiciona um elemento à lista.
    public void adicionar(E elemento) {
        if (tamanho < elementos.length) {
            elementos[tamanho++] = elemento;
        } else {
            throw new IllegalStateException("Lista está cheia");
        }
    }

    // Conta a quantidade de vezes que um elemento aparece na lista.
    public int contaElementos(E el) {
        return contaElementos(el, 0);
    }

    // Método recursivo que conta a quantidade de vezes que um elemento aparece na lista.
    private int contaElementos(E el, int indice) {
        if (indice == tamanho) {
            return 0;
        }
        int contagem = elementos[indice].equals(el) ? 1 : 0;
        return contagem + contaElementos(el, indice + 1);
    }

    public static void main(String[] args) {
        ListaEstatica<Integer> lista = new ListaEstatica<>(10);
        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.adicionar(1);
        lista.adicionar(1);

        System.out.println("Elemento 1 aparece: " + lista.contaElementos(1) + " vezes"); // Saída: 3
        System.out.println("Elemento 2 aparece: " + lista.contaElementos(2) + " vezes"); // Saída: 1
        System.out.println("Elemento 3 aparece: " + lista.contaElementos(3) + " vezes"); // Saída: 1
    }
}

