public class main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address(new Code());
        Person p1 = new Person(23, address);
        Person p2 = (Person) p1.clone();

        System.out.println(p1 == p2); // false

        System.out.println(p1.getAddress()); // Address@214c265e
        System.out.println(p2.getAddress()); // Address@448139f0

        System.out.println(p1.getAddress().getCode() == p2.getAddress().getCode()); // false
    }
}
