public class GoodfarmerStrawberry implements Strawberry {
    String brand;

    public GoodfarmerStrawberry(String brand) {
        this.brand = brand;
    }

    @Override
    public void SweetAttack() {
        System.out.printf("sweet attack from %s \n", this.brand);
    }
}
