import java.util.ArrayList;

public class Product {
    private ArrayList<String> content = new ArrayList<>();

    public Product() {
    }

    public void setGround(String ground) {
        this.content.add(ground);
    }

    public void setCement(String cement) {
        this.content.add(cement);
    }

    public void setRoof(String roof) {
        this.content.add(roof);
    }

    @Override
    public String toString() {
        return content.toString();
    }
}
