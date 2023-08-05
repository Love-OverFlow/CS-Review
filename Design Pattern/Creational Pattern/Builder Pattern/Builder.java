public interface Builder {
    // 一般来说, 有多少组件, 就有多少组件建造方法
    void buildGround();
    void buildCement();
    void buildRoof();

    // 建造完成, 返回产品类
    Product buildProduct();
}
