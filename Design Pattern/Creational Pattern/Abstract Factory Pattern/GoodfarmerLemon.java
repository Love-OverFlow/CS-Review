public class GoodfarmerLemon implements Lemon {
    String brand;

    public GoodfarmerLemon(String brand) {
        this.brand = brand;
    }

    @Override
    public void AcidAttack() {
        System.out.printf("acid attack from %s \n", this.brand);
    }
}
