// public class BluePaper implements Paper {
//     Pen pen;
//
//     public BluePaper(Pen p) {
//         pen = p;
//     }
//
//     @Override
//     public void construct() {
//         System.out.println(pen.write() + ", 写在蓝纸上");
//     }
// }

// 具体的抽象类实现
public class BluePaper extends Paper {
    public BluePaper(Pen p) {
        super(p);
    }

    @Override
    public void construct() {
        System.out.println(pen.write() + ", 写在蓝纸上");
    }
}
