public class Client {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        var product = director.Construct();
        System.out.println(product);

        System.out.println("#################");

        builder = new ConcreteLazyBuilder(); // 一个懒惰的建造者
        director = new Director(builder);
        product = director.WrongConstruct(); // 搭配一个有大病的建造顺序
        System.out.println(product);
    }
}

/**
 * [OUT]
 * 准备水泥
 * 准备地基
 * 准备楼顶
 * 组装...建造完毕
 * [粘稠的水泥, 坚固的地基, 漂亮的楼顶]
 * #################
 * 顺便糊个楼顶
 * 顺便糊个地基
 * 整点水和泥巴
 * 组装...OK啦
 * [破烂的楼顶, 稀烂的地基, 清透的水...泥?]
 */