package Structure;

import Entity.Data1;
import Entity.Data2;
import Nodes.Node;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkListTest {
    LinkList<Data2> lst = new LinkList<>();

    @Test
    void addFront() {

        lst.addFront(new Data2("1", "2"));
        lst.addFront(new Data2("3", "4"));
        lst.addFront(new Data2("5", "6"));
        assertEquals("[{\"firstName\":\"5\",\"secondName\":\"6\"}{\"firstName\":\"3\",\"secondName\":\"4\"}{\"firstName\":\"1\",\"secondName\":\"2\"}]", lst.print());
    }

    @Test
    void addEnd() {
        lst.addEnd(new Data2("1", "2"));
        lst.addEnd(new Data2("3", "4"));
        lst.addEnd(new Data2("5", "6"));
        assertEquals("[{\"firstName\":\"1\",\"secondName\":\"2\"}{\"firstName\":\"3\",\"secondName\":\"4\"}{\"firstName\":\"5\",\"secondName\":\"6\"}]", lst.print());
    }

    @Test
    void add1() {//check index 0 and usually work
        lst.add(0,new Data2("1", "2"));
        lst.add(0,new Data2("3", "4"));
        lst.add(1,new Data2("5", "6"));

        assertEquals("[{\"firstName\":\"1\",\"secondName\":\"2\"}{\"firstName\":\"5\",\"secondName\":\"6\"}{\"firstName\":\"3\",\"secondName\":\"4\"}]", lst.print());
    }
    @Test
    void add2() {//check index == size - 1
        lst.addEnd(new Data2("1", "2"));
        lst.addEnd(new Data2("3", "4"));
        lst.addEnd(new Data2("5", "6"));
        lst.add(2,new Data2("9", "9"));

        assertEquals("[{\"firstName\":\"1\",\"secondName\":\"2\"}{\"firstName\":\"3\",\"secondName\":\"4\"}{\"firstName\":\"9\",\"secondName\":\"9\"}{\"firstName\":\"5\",\"secondName\":\"6\"}]", lst.print());
    }
    @Test
    void add3() {//IndexOutOfBoundsException()
        lst.addEnd(new Data2("1", "2"));
        lst.addEnd(new Data2("1", "2"));
        lst.addEnd(new Data2("1", "2"));
        assertThrows(IndexOutOfBoundsException.class,
                ()->{lst.add(3,new Data2("1", "2"));});

    }


    @Test
    void contains() {
        lst.addEnd(new Data2("1", "2"));
        lst.addEnd(new Data2("2", "3"));
        lst.addEnd(new Data2("4", "5"));
        assertEquals(true,lst.contains(new Data2("1", "2")));
    }
    @Test
    void contains1() {
        lst.addEnd(new Data2("1", "2"));
        lst.addEnd(new Data2("1", "2"));
        lst.addEnd(new Data2("5", "4"));
        assertTrue(lst.contains(new Data2("5", "4")));
    }
    @Test
    void contains3() {
        lst.addEnd(new Data2("1", "2"));
        lst.addEnd(new Data2("1", "2"));
        lst.addEnd(new Data2("1", "2"));
        assertFalse(lst.contains(new Data2("1233", "2")));
    }

    @Test
    void remove() {
        lst.addEnd(new Data2("1", "2"));
        lst.addEnd(new Data2("3", "2"));
        lst.addEnd(new Data2("4", "2"));
        lst.remove(new Data2("1", "2"));
        assertEquals("[{\"firstName\":\"3\",\"secondName\":\"2\"}{\"firstName\":\"4\",\"secondName\":\"2\"}]", lst.print());
    }
    @Test
    void removeExc() {
        lst.addEnd(new Data2("1", "2"));
        lst.addEnd(new Data2("1", "2"));
        lst.addEnd(new Data2("1", "2"));
        assertThrows(NoSuchElementException.class,
                ()->{lst.remove(new Data2("1", "222222"));});
    }

    @Test
    void getByIndex() {//check working
        lst.addEnd(new Data2("1", "2"));
        assertInstanceOf(Node.class, lst.getByIndex(0));
    }
    @Test
    void getByIndexExc() {//check Exception
        lst.addEnd(new Data2("1", "2"));
        assertThrows(IndexOutOfBoundsException.class,
                ()->{lst.getByIndex(1);});
    }
    @Test
    void getByIndex1() {//check expected node
        lst.addEnd(new Data2("1", "2"));
        lst.addEnd(new Data2("1", "2"));
        lst.addEnd(new Data2("2", "23"));
        lst.addEnd(new Data2("1", "2"));
        assertEquals("{\"firstName\":\"2\",\"secondName\":\"23\"}", lst.getByIndex(2).data.print());
    }


    @Test
    void isEmptyTrue() {
        assertTrue(lst.isEmpty());
    }
    @Test
    void isEmptyFalse() {
        lst.addEnd(new Data2("1", "2"));
        assertFalse(lst.isEmpty());
    }

    @Test
    void size() {
        assertEquals(0, lst.size());
    }
    @Test
    void size1() {
        lst.addEnd(new Data2("1", "2"));
        lst.addFront(new Data2("1", "2"));
        lst.add(0,new Data2("1", "2"));
        assertEquals(3, lst.size());
    }

    @Test
    void saveToFile() {
        lst.addEnd(new Data2("1", "2"));
        lst.addEnd(new Data2("1", "2"));
        lst.addEnd(new Data2("1", "2"));
        lst.addEnd(new Data2("1", "2"));
        lst.saveToFile("listData.txt");
        StringBuilder sb = new StringBuilder();
        try(FileReader reader = new FileReader("listData.txt");) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = bufferedReader.readLine();
            while (line != null){
                sb.append(line);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals("[\t{\t\t\"firstName\":\"1\",\t\t\"secondName\":\"2\"\t},\t{\t\t\"firstName\":\"1\",\t\t\"secondName\":\"2\"\t},\t{\t\t\"firstName\":\"1\",\t\t\"secondName\":\"2\"\t},\t{\t\t\"firstName\":\"1\",\t\t\"secondName\":\"2\"\t}]", sb.toString());

    }
}