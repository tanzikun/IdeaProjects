package AbstractFactory;

public class MainClass {
    public static void main(String[] args){
        FruitFactory ff = new NorthFactoryFactory();
        Fruit apple = ff.getApple();
        apple.get();

        Fruit banana = ff.getBanana();
        banana.get();

        FruitFactory ff2 = new SouthFactoryFactory();
        Fruit apple2 = ff2.getApple();
        apple2.get();

        Fruit banana2 = ff.getBanana();
        banana2.get();

        FruitFactory ff3 = new WenShiFruitFactory();
        Fruit apple3 = ff3.getApple();
        apple3.get();

        Fruit banana3 = ff3.getBanana();
        banana3.get();
    }

}
