public class DoleLemon implements Lemon {
    String brand;

    public DoleLemon(String brand) {
        this.brand = brand;
    }

    @Override
    public void AcidAttack() {
        System.out.printf("acid attack from %s \n", this.brand);
    }
}
