public class DoleStrawberry implements Strawberry {
    String brand;

    public DoleStrawberry(String brand) {
        this.brand = brand;
    }

    @Override
    public void SweetAttack() {
        System.out.printf("sweet attack from %s \n", this.brand);
    }
}
