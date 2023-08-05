public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    // 一个正常的建造顺序
    public Product Construct() {
        // 构建顺序：准备水泥->地基->楼顶
        builder.buildCement();
        builder.buildGround();
        builder.buildRoof();

        return builder.buildProduct();
    }

    // 一个不正常的建造顺序
    public Product WrongConstruct() {
        // 构建顺序：准备楼顶->地基->水泥
        builder.buildRoof();
        builder.buildGround();
        builder.buildCement();

        return builder.buildProduct();
    }
}
