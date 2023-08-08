package Nodes;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Node<AnyType> extends DataNode {
    public Node<AnyType> prev;
    private AnyType data;
    public Node<AnyType> next;

    public Node(AnyType data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
    @Override
    public void print() {
        System.out.println(data);
    }
}
