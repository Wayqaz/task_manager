package utility.DoublyLinkedList;

import tasks.Task;

import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Objects;

/* создание собственного класса потребовалось ради выполнения операции добавления и удаления дублируемых элементов за О(1)
это было условием задачи*/
public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;
    private final Map<Integer, Node<T>> accordance = new HashMap<>();

    public List<Task> getTasks() {
        List<Task> out = new ArrayList<>();
        Node<T> node = head;
        while (node != null) {
            out.add(node.getData());
            node = node.getNext();
        }
        return out;
    }

    public void linkLast(Task data) {
        Node<T> node = new Node<>(data, tail, null);
        if (accordance.containsKey(data.getId())) {
            removeNode(accordance.get(data.getId()));
        }
        if (size == 0) {
            tail = node;
            head = tail;
        } else if (size == 1) {
            head.setNext(node);
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        accordance.put(data.getId(), node);
        size++;
    }
    public void removeNode(Node<T> node) {
        if(Objects.isNull(node.getPrevious()) && Objects.isNull(node.getNext())){ //технического смысла не имеет, но необходимо для логического структурирования
            node.setPrevious(null);
            node.setNext(null);
        }else if (Objects.isNull(node.getPrevious())) {
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
        accordance.remove(node.getData().getId());
        size--;
    }

    public Map<Integer, Node<T>> getAccordance() {
        return accordance;
    }
}
