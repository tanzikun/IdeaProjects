package AbstractFactory;

public class WenShiFruitFactory implements  FruitFactory{

    public  Fruit getApple(){
        return new WenShiApple();
    }

    public  Fruit getBanana(){
        return new WenShiBanana();
    }
}
