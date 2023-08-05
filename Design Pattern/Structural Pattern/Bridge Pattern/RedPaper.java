// public class RedPaper implements Paper {
//     Pen pen;
//
//     public RedPaper(Pen p) {
//         pen = p;
//     }
//
//     @Override
//     public void construct() {
//         System.out.println(pen.write() + ", 写在红纸上");
//     }
// }

// 具体的抽象类实现
public class RedPaper extends Paper {
    public RedPaper(Pen p) {
        super(p);
    }

    @Override
    public void construct() {
        System.out.println(pen.write() + ", 写在红纸上");
    }
}
