package FactoeyMethod;

public class FruitFactoryMainClass {
    public static void main(String[] args){
        try{
            FruitFactory appleFactory = new AppleFactory();
            Fruit apple = appleFactory.getFruit();
            FruitFactory bananaFactory = new BananaFactory();
            Fruit banana = bananaFactory.getFruit();
            FruitFactory pearFactory = new PearFactory();
            Fruit pear = pearFactory.getFruit();
            apple.get();
            banana.get();
            pear.get();

        }catch (Exception e){

        }finally {

        }
    }

}
