package MainMethod;

import Entity.Data2;
import Structure.LinkList;

public class appMain {
    public static void main(String[] args) {
        System.out.println(new Data2("sfgas","wgrge").equals(new Data2("sfgas","wgrge")));

        System.out.println(new Data2("sfgas","wgrge").equals(new Data2("sfwefwggas","wgrge")));
    }
}
