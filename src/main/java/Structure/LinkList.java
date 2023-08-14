package Structure;

import Nodes.Node;
import lombok.Cleanup;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.NoSuchElementException;
@Getter
@Setter
public class LinkList<T> {
    private Node<T> head;

    private int size;


    public LinkList() {
        this.head = null;
        this.size = 0;


    }
    public void addFront(T data) {
        if(isEmpty()){
            head = new Node<>(data, null);

        }
        else{
            Node<T> temp = head;
            head = new Node<>(data, temp);
        }
        size++;
    }

    public void addEnd(T data) {

        if(isEmpty()){
            head = new Node<>( data, null);
        }
        else{
            var current = head;
            while(current.next != null){
                current = current.next;
            }
            var temp = new Node<T>(data, null);
            current.next = temp;
        }
        size++;
    }
    //требуется отладка
    public void add(Integer index, T data) {
        if(isEmpty()){
            head = new Node<>( data, null);
        }
        else {
            if(index >= size()) throw new IndexOutOfBoundsException();
            var current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<T> temp = new Node<>(data,current.next);
            current.next = temp;
        }
        size++;
    }

    public boolean contains(T data) {
        if(isEmpty())return false;
        var current = head;
        while(current != null){
            if(current.getData().equals(data))return true;
            current = current.next;
        }
        return false;
    }

    public void remove(T data) {
        if (isEmpty())
            throw new NoSuchElementException("Element " + data.toString() + " not found");
        if(head.getData().equals(data)){
            head = head.next;
            //теоретически тут отчистка из памяти ноды
            return;
        }

        Node<T> current = head;
        while(current.next != null){
            if(current.next.getData().equals(data)){
                var temp = current.next;
                current.next = temp.next;
                temp = null;// SonarLint говорит убрать, но тогда теоретически не попадет в gc
                size--;
                return;
                //теоретически тут отчистка из памяти ноды
            }
            current = current.next;
        }
        throw new NoSuchElementException("Element " + data.toString() + " not found");
    }
    public Node<T> getByIndex(Integer index){//тесты
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
        sb.append("[");
        var current = head;
        while (current != null){
            if(current.getClass().getPackage().getName().startsWith("java.lang")){
                sb.append(current.getData() + ", ");
            }
            else{
                sb.append(current.getData() + ", ");
            }
            current = current.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    public boolean isEmpty() {
        if(getSize() == 0) return true;
        return false;
    }

    public int size() {
        return size;
    }


    public void saveToFile(String path){
        try {
            @Cleanup FileWriter file = new FileWriter(path);
            file.write("[\n\t");
            var current = head;
            for (int i = 0; i < getSize(); i++) {
                file.write(current.print());
                if(i < getSize() - 1)
                    file.write(",\n\t");
                else
                    file.write("\n]");
                current = current.next;
            }
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
