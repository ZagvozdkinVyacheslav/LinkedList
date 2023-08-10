package Structure;

import Nodes.Node;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;
@Getter
@Setter
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
    //требуется отладка
    public void add(Integer index, AnyType data) {
        if(index > size() - 1) throw new IndexOutOfBoundsException();
        var current = head;
        for (int i = 1; i <= index; i++) {
            current = current.next;
        }
        Node<AnyType> temp = new Node<>(current.prev,data,current.next);
        current.prev.next = temp;
        if(current == tail) tail = temp;

    }

    public boolean contains(AnyType data) {
        if(isEmpty())return false;
        var current = head;
        while(current != null){
            if(current.getData().equals(data))return true;
            current = current.next;
        }
        return false;
    }

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
    public Node<AnyType> getByIndex(Integer index){//тесты
        if(index > size() - 1) throw new IndexOutOfBoundsException("Вы вышли за пределы");
        var current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
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
    public void saveToFile(String path){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(path, "UTF-8");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.println(new ObjectMapper().writeValueAsString(this));


        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        writer.close();
    }
}
