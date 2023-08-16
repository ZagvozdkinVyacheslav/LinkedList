package Entity;

import Abstract.DataNode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
public class Data3 extends DataNode {
    private char symbol;

    public Data3(char symbol) {
        this.symbol = symbol;
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
