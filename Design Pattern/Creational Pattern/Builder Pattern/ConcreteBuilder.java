/**
 * 一个正常的建造者
 */
public class ConcreteBuilder implements Builder {
    private final Product product = new Product();

    @Override
    public void buildGround() {
        System.out.println("准备地基");
        product.setGround("坚固的地基");
    }

    @Override
    public void buildCement() {
        System.out.println("准备水泥");
        product.setCement("粘稠的水泥");
    }

    @Override
    public void buildRoof() {
        System.out.println("准备楼顶");
        product.setRoof("漂亮的楼顶");
    }

    @Override
        public Product buildProduct() {
        System.out.println("组装...建造完毕");
        return product;
    }
}
