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
        ArrayList<Field> decFields = null;
        try {
            decFields = new ArrayList<>(Arrays.asList(this.getClass().getDeclaredField("data").getClass().getDeclaredFields()));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

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

        }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

}
