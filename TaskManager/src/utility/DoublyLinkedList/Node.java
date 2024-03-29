package utility.DoublyLinkedList;

import tasks.Task;

import java.util.Objects;

public class Node<T> {
    private final Task data;
    private Node<T> next;
    private Node<T> previous;

    public Node(Task data, Node<T> previous, Node<T> next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(data, node.data) && Objects.equals(next, node.next) && Objects.equals(previous, node.previous);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next, previous);
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Task getData() {
        return data;
    }
}