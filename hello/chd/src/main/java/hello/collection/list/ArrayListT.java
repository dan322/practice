package hello.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListT {

    public static void main(String[] args) {
        List a = new ArrayList<String>();
//        List<String> a = new ArrayList<>();
        a.add("List01");
        a.add("List02");
        a.add("List04");
        System.out.print(a);
        a.add(2, "List03");
        System.out.println(a);
        a.remove(1);
        System.out.println(a);

        Iterator i= a.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
