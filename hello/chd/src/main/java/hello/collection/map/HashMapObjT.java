package hello.collection.map;

import java.util.HashMap;
import java.util.Iterator;

public class HashMapObjT {
    public static void main(String[] args)
    {
        HashMap<Object, Integer> hashMapA = new HashMap<Object, Integer>();
        hashMapA.put(new A(), 10);
        hashMapA.put(new A(), 5);
        System.out.println("HashMapA Elements:");
        System.out.println("\t" + hashMapA + "\n");

        HashMap<Object, Integer> hashMapB = new HashMap<Object, Integer>();
        hashMapB.put(new B(), 10);
        hashMapB.put(new B(), 5);
        System.out.println("HashMapB Elements:");
        System.out.println("\t" + hashMapB + "\n");

        HashMap<Object, Integer> hashMapC = new HashMap<Object, Integer>();
        hashMapC.put(new C(), 10);
        hashMapC.put(new C(), 5);
        System.out.println("HashMapC Elements:");
        System.out.println("\t" + hashMapC + "\n");

       /* Object c1 = new C();
        Object c2 = new C();
        ((C) c1).setName("hello");
        System.out.println(((C) c1).getName());
        System.out.println(((C) c2).getName());
        System.out.println(c1 == c2);
        System.out.println(c1.equals(c2));

        ((C) c2).setName("hello world");
        System.out.println(((C) c1).getName());
        System.out.println(((C) c2).getName());
        System.out.println(c1 == c2);
        System.out.println(c1.equals(c2));*/

//        Iterator<C> c = hashMapC.forEach(Object, Integer);
    }
}


class A {
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}

class B {
    @Override
    public int hashCode() {
        return 1;
    }
}

class C {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return 2;
    }
}