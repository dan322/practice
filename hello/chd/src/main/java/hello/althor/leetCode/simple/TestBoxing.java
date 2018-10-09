package hello.althor.leetCode.simple;

import java.util.Calendar;

public class TestBoxing {
    Integer j;
    int i;

    public static void main (String[] args)
    {
//        TestBoxing testBoxing = new TestBoxing();
//        testBoxing.go();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 1, 7, 15, 40);
        calendar.add(calendar.DATE, 35);
        System.out.println("add 35 days " + calendar.getTime());
        calendar.roll(calendar.DATE, 35);
        System.out.println("roll 35 days " + calendar.getTime());
        calendar.set(Calendar.DATE, 1);
        System.out.println("set to 1" + calendar.getTime());
    }

    public void go()
    {
        j = i;
        System.out.println(j);
        System.out.println(i);
    }
}
