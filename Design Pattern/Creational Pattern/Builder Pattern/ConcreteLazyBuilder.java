/**
 * 一个懒的有些极端的建造者
 */
public class ConcreteLazyBuilder implements Builder {
    private final Product product = new Product();

    @Override
    public void buildGround() {
        System.out.println("顺便糊个地基");
        product.setGround("稀烂的地基");
    }

    @Override
    public void buildCement() {
        System.out.println("整点水和泥巴");
        product.setCement("清透的水...泥?");
    }

    @Override
    public void buildRoof() {
        System.out.println("顺便糊个楼顶");
        product.setRoof("破烂的楼顶");
    }

    @Override
    public Product buildProduct() {
        System.out.println("组装...OK啦");
        return product;
    }
}
