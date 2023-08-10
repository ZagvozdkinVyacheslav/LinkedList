package Nodes;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import static com.fasterxml.jackson.databind.MapperFeature.DEFAULT_VIEW_INCLUSION;

@Getter
@Setter
public class Node<AnyType>{
    @JsonBackReference
    public Node<AnyType> prev;
    public AnyType data;
    @JsonManagedReference
    public Node<AnyType> next;

    public Node(AnyType data) {
        this.prev = null;
        this.data = data;
        this.prev = null;
    }

    public Node(Node<AnyType> prev, AnyType data, Node<AnyType> next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
