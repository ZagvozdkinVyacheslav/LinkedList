import Structure.LinkList;

public class appMain {
    public static void main(String[] args) {
        LinkList<Integer> lst = new LinkList<>();
        lst.addFront(5);
        lst.addFront(6);
        lst.addFront(7);
        lst.addFront(8);
        lst.addEnd(4);
        lst.remove(5);
        System.out.println(lst.toString());
    }
}
