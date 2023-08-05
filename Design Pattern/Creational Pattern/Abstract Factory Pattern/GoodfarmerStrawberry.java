public class GoodfarmerStrawberry implements Strawberry {
    String brand;

    @Override
    public void SweetAttack() {
        System.out.printf("sweet attack from %s, ", this.brand);
    }
}
