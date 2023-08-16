package Entity;

import Abstract.DataNode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Data2 extends DataNode {
    private String firstName;
    private String secondName;

    public Data2(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }


    @Override
    public String print() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
