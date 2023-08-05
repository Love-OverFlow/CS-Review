public class ConcreteColleague1 implements Colleague {
    private Mediator mediator;

    public ConcreteColleague1(Mediator m) {
        this.mediator = m;
    }
    @Override
    public void message() {
        mediator.deal(this);
    }

    @Override
    public void selfMethod() {
        System.out.println("A 类员工收到消息, 正在处理");
    }
}

