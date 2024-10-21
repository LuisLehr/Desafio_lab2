public interface Stack<T> {
    boolean isEmpty();
    boolean isFull();
    int numElements();
    void push(T element);
    T pop();
    T top();
}

