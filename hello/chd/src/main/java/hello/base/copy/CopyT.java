package hello.base.copy;

import java.lang.Cloneable;



class Family implements Cloneable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }

}

class Student implements Cloneable {
    private String name;
    private Family family;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    /*@Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/

    @Override
    protected Object clone() {
        Student o = null;
        try {
            o = (Student)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        o.family = (Family) family.clone();
        return o;
    }

    @Override
   public String toString()
    {
        return "Student name: " + this.name + " Family: " + this.getFamily().getName();
    }
}


public class CopyT {
    public static void main (String[] args) throws CloneNotSupportedException{
        System.out.println("hello world");
        Student stu = new Student();
        Family family = new Family();
        stu.setName("xiao hong");
        stu.setFamily(family);
        stu.getFamily().setName("xiao family");

        Student stu1 = (Student) stu.clone();
        stu1.setName("xiao ming");
        stu1.getFamily().setName("xiao ming's family");
        System.out.println(stu);
        System.out.println(stu1);
    }
}