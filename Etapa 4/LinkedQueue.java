public class LinkedQueue<T> implements Queue<T> {
    private Node<T> front;
    private Node<T> back;
    private int size;

    public LinkedQueue() {
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public boolean isFull() {
        return false; // Uma fila encadeada nunca está cheia (a não ser que falte memória)
    }

    @Override
    public int numElements() {
        return size;
    }

    @Override
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element, null);
        if (isEmpty()) {
            front = newNode;
            back = newNode;
        } else {
            back.setNext(newNode);
            back = newNode;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null; // Ou pode lançar uma exceção
        }
        T element = front.getData();
        front = front.getNext();
        size--;
        if (isEmpty()) {
            back = null;
        }
        return element;
    }

    @Override
    public T front() {
        if (isEmpty()) {
            return null; // Ou pode lançar uma exceção
        }
        return front.getData();
    }

    @Override
    public T back() {
        if (isEmpty()) {
            return null; // Ou pode lançar uma exceção
        }
        return back.getData();
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        System.out.println("A fila está vazia? " + queue.isEmpty()); // true
        System.out.println("A fila está cheia? " + queue.isFull()); // false

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Número de elementos: " + queue.numElements()); // 3
        System.out.println("O elemento da frente é: " + queue.front()); // 10
        System.out.println("O elemento de trás é: " + queue.back()); // 30

        System.out.println("Elemento desenfileirado: " + queue.dequeue()); // 10
        System.out.println("O elemento da frente é: " + queue.front()); // 20
        System.out.println("O elemento de trás é: " + queue.back()); // 30

        System.out.println("Elemento desenfileirado: " + queue.dequeue()); // 20
        System.out.println("Elemento desenfileirado: " + queue.dequeue()); // 30

        System.out.println("A fila está vazia? " + queue.isEmpty()); // true
    }
}
