public class Person implements Cloneable {

    private int age; // 年龄字段 (内置数据类型)
    private Address address; // 地址字段 (自定义数据类型)

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();
        p.address = (Address) address.clone();
        return p;
    }

    public Person(int age, Address address) {
        this.age = age;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public Person() { }
}