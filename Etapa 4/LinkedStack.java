public class LinkedStack<T> implements Stack<T> {
    private Node<T> top;
    private int size;

    public LinkedStack() {
        top = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean isFull() {
        return false; // Uma pilha encadeada nunca está cheia (a não ser que falte memória)
    }

    @Override
    public int numElements() {
        return size;
    }

    @Override
    public void push(T element) {
        Node<T> newNode = new Node<>(element, top);
        top = newNode;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null; // Ou pode lançar uma exceção
        }
        T element = top.getData();
        top = top.getNext();
        size--;
        return element;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            return null; // Ou pode lançar uma exceção
        }
        return top.getData();
    }

    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        System.out.println("A pilha está vazia? " + stack.isEmpty()); // true
        System.out.println("A pilha está cheia? " + stack.isFull()); // false

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Número de elementos: " + stack.numElements()); // 3
        System.out.println("O elemento do topo é: " + stack.top()); // 30

        System.out.println("Elemento desempilhado: " + stack.pop()); // 30
        System.out.println("O elemento do topo é: " + stack.top()); // 20

        System.out.println("Elemento desempilhado: " + stack.pop()); // 20
        System.out.println("Elemento desempilhado: " + stack.pop()); // 10

        System.out.println("A pilha está vazia? " + stack.isEmpty()); // true
    }
}
