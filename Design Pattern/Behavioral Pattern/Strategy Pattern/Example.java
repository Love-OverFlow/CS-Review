import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author Love-OverFlow
 * @date 2023/7/28
 */
public class Example {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>(Comparator.reverseOrder());
        treeSet.add("lily");
        treeSet.add("yer");
        treeSet.add("admin");
        for (String s : treeSet) {
            System.out.println(s); // [OUT] yer lily admin
        }
    }
}
