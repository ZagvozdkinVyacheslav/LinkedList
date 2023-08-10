package Nodes;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

import static com.fasterxml.jackson.databind.MapperFeature.DEFAULT_VIEW_INCLUSION;

@Getter
@Setter
public class Node<AnyType>{

    public AnyType data;

    public Node<AnyType> next;

    public Node(AnyType data) {
        this.data = data;
        this.next = null;
    }

    public Node(AnyType data, Node<AnyType> next) {

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
