public class GoodFarmerFactory implements FruitFactory {
    void myAspect() { // 同一个产品族可以使用自己的切面
        System.out.println("检查水果坏了没...洗洗水果");
    }

    @Override
    public Strawberry CreateStrawberry() {
        this.myAspect();
        return new GoodfarmerStrawberry("goodfarmer");
    }

    @Override
    public Lemon CreateLemon() {
        this.myAspect();
        return new GoodfarmerLemon("goodfarmer");
    }
}
