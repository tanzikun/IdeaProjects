package decorator;

public class SwinCar implements Car {

    @Override
    public void show() {
        this.run();
        this.swim();
    }

    @Override
    public void run(){
        System.out.println("可以跑");
    }

    public void swim(){
        System.out.println("可以游");
    }
}
