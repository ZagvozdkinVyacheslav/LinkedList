package Structure;

import Nodes.Node;

import java.util.NoSuchElementException;

public class LinkList<AnyType> {
    private Node<AnyType> head;
    private Node<AnyType> tail;
    private int size;


    public LinkList() {
        this.head = null;
        this.size = 0;
        this.tail = null;

    }
    public void addFront(AnyType data) {
        if(isEmpty()){
            head = new Node<>(null, data, null);
            tail = head;
        }
        else{
            Node<AnyType> temp = head;
            head = new Node<>(null, data, temp);
            head.next.prev = head;
        }
        size++;
    }

    public void addEnd(AnyType data) {

        if(isEmpty()){
            head = new Node<>(null, data, null);
            tail = head;
        }
        else{
            Node<AnyType> temp = tail;
            tail = new Node<>(temp, data, null);
            tail.prev.next = tail;
        }
        size++;
    }

    /*public boolean contains(AnyType data) {

    }*/

    public void remove(AnyType data) {
        if (isEmpty())
            throw new NoSuchElementException("Element " + data.toString() + " not found");
        if(head.getData().equals(data)){
            head = head.next;
            //теоретически тут отчистка из памяти ноды
            return;
        }
        if(tail.getData().equals(data)){
            tail = tail.prev;
            //теоретически тут отчистка из памяти ноды
            return;
        }
        Node<AnyType> current = head;
        while(current.next != null){
            if(current.getData().equals(data)){
                current.next.prev = current.prev;
                current.prev.next = current.next;
                size--;
                return;
                //теоретически тут отчистка из памяти ноды
            }
            current = current.next;
        }
        throw new NoSuchElementException("Element " + data.toString() + " not found");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        var current = head;
        while (current != null){
            sb.append(current.getData());
            current = current.next;
        }
        return sb.toString();
    }

    public boolean isEmpty() {
        if(size == 0)return true;
        return false;
    }

    public int size() {
        return size;
    }
}
