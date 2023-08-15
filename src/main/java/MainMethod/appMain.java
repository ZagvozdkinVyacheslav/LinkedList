package MainMethod;

import Abstract.DataNode;
import Entity.Data1;
import Entity.Data2;
import Entity.Data3;
import Structure.LinkList;

public class appMain {
    public static void main(String[] args) {
        LinkList<DataNode> dataNodeLinkList = new LinkList<>();
        LinkList<Data1> lst = new LinkList<>();
        lst.addFront(new Data1("asd",12,true));
        lst.addFront(new Data1("asd",12,true));
        dataNodeLinkList.addFront(lst);
        dataNodeLinkList.addFront(lst);
        System.out.println(dataNodeLinkList.print());

    }
}
