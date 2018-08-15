package hello.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class List0 {

    public static void main (String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("he");
        list.add("she");
        list.add("her");
        list.add("hello");
        list.add("hey");

        ListIterator li = list.listIterator();
        while (li.hasNext()) {
            Object o = li.next();
            System.out.println(o);
            if (o.equals("hey")) li.remove();
        }
        System.out.println(list);
        System.out.println(li);
    }
}
