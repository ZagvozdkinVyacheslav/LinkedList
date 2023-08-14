package Structure;

import Nodes.Node;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkListTest {
    LinkList<Integer> lst = new LinkList<>();

    @Test
    void addFront() {
        lst.addFront(1);
        lst.addFront(2);
        lst.addFront(3);
        assertEquals("[3, 2, 1]", lst.toString());
    }

    @Test
    void addEnd() {
        lst.addEnd(1);
        lst.addEnd(2);
        lst.addEnd(3);
        assertEquals("[1, 2, 3]", lst.toString());
    }

    @Test
    void add1() {//check index 0 and usually work
        lst.add(0,1);
        lst.add(0,2);
        lst.add(1,3);

        assertEquals("[1, 3, 2]", lst.toString());
    }
    @Test
    void add2() {//check index == size - 1
        lst.addEnd(0);
        lst.addEnd(1);
        lst.addEnd(3);
        lst.add(2,2);

        assertEquals("[0, 1, 2, 3]", lst.toString());
    }
    @Test
    void add3() {//IndexOutOfBoundsException()
        lst.addEnd(0);
        lst.addEnd(1);
        lst.addEnd(3);
        assertThrows(IndexOutOfBoundsException.class,
                ()->{lst.add(3,2);});

    }


    @Test
    void contains() {
        lst.addEnd(0);
        lst.addEnd(1);
        lst.addEnd(3);
        assertEquals(true,lst.contains(0));
    }
    @Test
    void contains1() {
        lst.addEnd(0);
        lst.addEnd(1);
        lst.addEnd(3);
        assertTrue(lst.contains(3));
    }
    @Test
    void contains3() {
        lst.addEnd(0);
        lst.addEnd(1);
        lst.addEnd(3);
        assertFalse(lst.contains(4));
    }

    @Test
    void remove() {
        lst.addEnd(0);
        lst.addEnd(1);
        lst.addEnd(2);
        lst.remove(1);
        assertEquals("[0, 2]", lst.toString());
    }
    @Test
    void removeExc() {
        lst.addEnd(0);
        lst.addEnd(1);
        lst.addEnd(2);
        assertThrows(NoSuchElementException.class,
                ()->{lst.remove(4);});
    }

    @Test
    void getByIndex() {//check working
        lst.addEnd(0);
        assertInstanceOf(Node.class, lst.getByIndex(0));
    }
    @Test
    void getByIndexExc() {//check Exception
        lst.addEnd(0);
        assertThrows(IndexOutOfBoundsException.class,
                ()->{lst.getByIndex(1);});
    }
    @Test
    void getByIndex1() {//check expected node
        lst.addEnd(1);
        lst.addEnd(2);
        lst.addEnd(3);
        lst.addEnd(4);
        assertEquals(3, lst.getByIndex(2).data);
    }


    @Test
    void isEmptyTrue() {
        assertTrue(lst.isEmpty());
    }
    @Test
    void isEmptyFalse() {
        lst.addEnd(1);
        assertFalse(lst.isEmpty());
    }

    @Test
    void size() {
        assertEquals(0, lst.size());
    }
    @Test
    void size1() {
        lst.addEnd(1);
        lst.addFront(2);
        lst.add(0,5);
        assertEquals(3, lst.size());
    }

    @Test
    void saveToFile() {
        lst.addEnd(1);
        lst.addEnd(2);
        lst.addEnd(3);
        lst.addEnd(4);
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
        assertEquals("[\t1,\t2,\t3,\t4]", sb.toString());

    }
}