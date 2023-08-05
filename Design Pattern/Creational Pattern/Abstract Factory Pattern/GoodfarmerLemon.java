public class GoodfarmerLemon implements Lemon {
    String brand;

    @Override
    public void AcidAttack() {
        System.out.printf("acid attack from %s, ", this.brand);
    }
}
