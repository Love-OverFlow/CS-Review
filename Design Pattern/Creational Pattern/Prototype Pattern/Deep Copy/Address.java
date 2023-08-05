public class Address implements Cloneable {
    private Code code; // 地址的编号信息字段

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Address address = (Address) super.clone();
        address.code = (Code) code.clone();
        return address;
    }

    public Code getCode() {
        return code;
    }

    public Address(Code c) {
        code = c;
    }
}