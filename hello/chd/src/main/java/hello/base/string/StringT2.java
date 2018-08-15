package hello.base.string;

 class StringObj {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}

public class StringT2 {
     public static void main(String[] args) {
         StringObj strObj = new StringObj();
         strObj.setName("123");
         change(strObj);
         System.out.println(strObj);
     }

     public static void change(StringObj strObj) {
         strObj.setName("245");
     }
}
