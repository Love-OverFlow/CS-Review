import java.util.ArrayList;
import java.util.List;

/**
 * @author Love-OverFlow
 * @date 2023/8/5
 */

// 对象数据结构
public class ObjectStructure {
    private List<Element> elements = new ArrayList<>();

    public void traversal(Visitor visitor) {
        for (Element e : elements) {
            e.accept(visitor);
        }
    }

    public void add(Element e){
        elements.add(e);
    }
}
