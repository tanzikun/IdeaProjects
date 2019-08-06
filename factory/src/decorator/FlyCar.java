package decorator;

public class FlyCar implements Car{

    @Override
    public void show() {
        this.run();
        this.fly();
    }
    @Override
    public void run(){
        System.out.println("可以跑");
    }

    public void fly(){
        System.out.println("可以飞");
    }
}
