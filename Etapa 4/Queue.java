public interface Queue<T> {
    boolean isEmpty();
    boolean isFull();
    int numElements();
    void enqueue(T element);
    T dequeue();
    T front();
    T back();
}
