public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Внутрішній клас для представлення вузла ноди
    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        public Node(T value) {
            this.value = value;
        }
    }

    // Метод додавання елемента в кінець списку
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Метод який видаляє елемент із вказаним індексом
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Індекс виходить за межі списку");
        }
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.previous = null;
            } else {
                tail = null;  // якщо список порожній після видалення
            }
        } else if (index == size - 1) {
            tail = tail.previous;
            if (tail != null) {
                tail.next = null;
            } else {
                head = null;  // якщо список порожній після видалення
            }
        } else {
            Node<T> currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            currentNode.previous.next = currentNode.next;
            currentNode.next.previous = currentNode.previous;
        }
        size--;
    }

    // Метод який очищає колекцію
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    // Метод який повертає розмір колекції
    public int size() {
        return size;
    }

    // Метод який повертає елемент з вказаним індексом
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Індекс виходить за межі списку");
        }

        Node<T> currentNode;
        if (index < size / 2) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.previous;
            }
        }
        return currentNode.value;
    }
}
