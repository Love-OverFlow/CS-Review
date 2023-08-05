public class DoleFactory implements FruitFactory {
    void myAspect() { // 同一个产品族可以使用自己的切面
        System.out.println("对本次销售进行记录");
    }

    @Override
    public Strawberry CreateStrawberry() {
        this.myAspect();
        return new DoleStrawberry("dole");
    }

    @Override
    public Lemon CreateLemon() {
        this.myAspect();
        return new DoleLemon("dole");
    }
}
