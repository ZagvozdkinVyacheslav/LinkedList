package org.example.entity;

import org.example.abstractClass.DataNode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
