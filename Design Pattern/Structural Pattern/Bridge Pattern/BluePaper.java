public class RedPaper implements Paper {
    Pen pen;
    public RedPaper(Pen p) {
        pen = p;
    }
    @Override
    public void construct() {
        System.out.println(pen.write() + ", 写在红纸上");
    }
}
