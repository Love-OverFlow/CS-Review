public class ConcreteColleague2 implements Colleague {
    private Mediator mediator;

    public ConcreteColleague2(Mediator m) {
        this.mediator = m;
    }

    @Override
    public void message() {
        mediator.deal(this);
    }

    @Override
    public void selfMethod() {
        System.out.println("B 类员工收到消息, 正在处理");
    }
}
