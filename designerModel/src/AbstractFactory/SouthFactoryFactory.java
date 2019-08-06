package AbstractFactory;

public class SouthFactoryFactory implements  FruitFactory{

    public  Fruit getApple(){
        return new SouthApple();
    }

    public  Fruit getBanana(){
        return new SouthBanana();
    }
}
