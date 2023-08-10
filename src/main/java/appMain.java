import Entity.Data1;
import Entity.Data3;
import Structure.LinkList;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

public class appMain {
    public static void main(String[] args) {
        LinkList<Data1> lst = new LinkList<>();
        lst.addEnd(new Data1("Slava", 1.3, true));
        lst.addEnd(new Data1("Sla", 1.34, true));
        lst.addEnd(new Data1("Sa", 1.333, false));
        
        lst.saveToFile("listData.txt");



    }
}
