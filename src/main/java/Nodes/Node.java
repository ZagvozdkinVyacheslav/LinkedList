package Nodes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
@Getter//SonarLint ругается, но геттеры и сеттеры есть
@Setter
public class Node<T>{

    public T data;

    public Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public Node(T data, Node<T> next) {

        this.data = data;
        this.next = next;
    }
    public String print() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(data)
                    .replace("{\"","{\n\t\t\"")
                    .replace(",\"",",\n\t\t\"")
                    .replace("}","\n\t}");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
