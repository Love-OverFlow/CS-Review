public class main {
    public static void main(String[] args) {
        // 吃吃佳农品牌的水果
        FruitFactory factory = new GoodFarmerFactory();

        var goodfarmerStrawberry = factory.CreateStrawberry();
        goodfarmerStrawberry.SweetAttack();
        //===--------------------------------------------------------------------===//
        // 检查水果坏了没...洗洗水果
        // sweet attack from goodfarmer
        //===--------------------------------------------------------------------===//
        var goodfarmerLemon = factory.CreateLemon();
        goodfarmerLemon.AcidAttack();
        //===--------------------------------------------------------------------===//
        // 检查水果坏了没...洗洗水果
        // acid attack from goodfarmer
        //===--------------------------------------------------------------------===//

        // 吃吃都乐品牌的水果
        factory = new DoleFactory();

        var doleStrawberry = factory.CreateStrawberry();
        doleStrawberry.SweetAttack();
        //===--------------------------------------------------------------------===//
        // 对本次销售进行记录
        // sweet attack from dole
        //===--------------------------------------------------------------------===//
        var dolefarmerLemon = factory.CreateLemon();
        dolefarmerLemon.AcidAttack();
        //===--------------------------------------------------------------------===//
        // 对本次销售进行记录
        // acid attack from dole
        //===--------------------------------------------------------------------===//
    }
}
