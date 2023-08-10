package Entity;

import Abstract.DataNode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.val;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

@Getter
@Setter
public class Data1 extends DataNode {
    private String name;
    private double weight;
    private boolean tattoo;

    public Data1(String name, double weight, boolean tattoo) {
        this.name = name;
        this.weight = weight;
        this.tattoo = tattoo;
    }


    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        var decFields = new ArrayList<>(Arrays.asList(this.getClass().getDeclaredFields()));

        sb.append("{");
        try {
        for (int i = 0; i < decFields.size(); i++) {
            switch (decFields.get(i).getType().toString()){
                case "class java.lang.String":
                    sb.append("\"" + decFields.get(i).getName() + "\"" + ":" + "\"" + decFields.get(i).get(this) + "\"" + ",");
                    break;
                case "char":
                    sb.append("\"" + decFields.get(i).getName() + "\"" + ":" + "'" + decFields.get(i).get(this) + "'" + ",");
                    break;
                default:
                    sb.append("\"" + decFields.get(i).getName() + "\"" + ":" + decFields.get(i).get(this) + ",");
                    break;
            }

            System.out.println(decFields.get(i).getType().toString());
        }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }
    public String printTest() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
