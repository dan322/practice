package hello.collection.hash;

public class SkuObj {
    /**
     * skuObj.setId(i);
     *             skuObj.setName("name" + i);
     *             skuObj.setAge(i + 666);
     *             skuObj.setDesc("desc" + i);
     */
    private Integer id;
    private String name;
    private Integer age;
    private String desc;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getDesc() {
        return desc;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
