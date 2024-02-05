package utility.DoublyLinkedList;

import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Objects;

// создание собственного класса потребовалось ради выполнения операции добавления и удаления дублируемых элементов за О(1)
//это было условием задачи
public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;
    private Map<Integer, Node<T>> accordance = new HashMap<>();

    public List<T> getTasks() {
        List<T> out = new ArrayList<>();
        Node<T> node = head;
        while (node != null) {
            out.add(node.getData());
            node = node.getNext();
        }
        return out;
    }

    public void linkLast(T data) {
        Node<T> node = new Node<>(data, tail, null);
        if (size == 0) {
            tail = node;
            head = tail;
        } else {
            tail.setNext(node);
            tail = node;
        }
        if (accordance.containsKey(data.hashCode())) {
            removeNode(accordance.get(data.hashCode()));
        }
        accordance.put(data.hashCode(), node);
        size++;
    }

    public void removeNode(Node<T> node) {
        if (Objects.isNull(node.getPrevious())) {
            node.getNext().setPrevious(null);
            head = node.getNext();
            node.setNext(null);
        } else if (Objects.isNull(node.getNext())) {
            node.getPrevious().setNext(null);
            tail = node.getPrevious();
            node.setPrevious(null);
        } else {
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
            node.setNext(null);
            node.setPrevious(null);
        }
        accordance.remove(node.getData().hashCode());
        size--;
    }

    public Map<Integer, Node<T>> getAccordance() {
        return accordance;
    }
}
