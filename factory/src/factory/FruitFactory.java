package factory;

public class FruitFactory {
    /*
        获得Apple类的实例
     */
    public  static Fruit getApple(){
        return new Apple();
    }

    public  static Fruit getBanana(){
        return new Banana();
    }

    public static Fruit getFruit(String type) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class fruit = Class.forName(type);
        return (Fruit) fruit.newInstance();
    }
}
