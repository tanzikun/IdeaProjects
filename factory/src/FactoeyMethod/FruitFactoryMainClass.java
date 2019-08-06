package FactoeyMethod;

public class FruitFactoryMainClass {
    public static void main(String[] args){
        try{
            AppleFactory appleFactory = new AppleFactory();
            Fruit apple = appleFactory.getFruit();
            BananaFactory bananaFactory = new BananaFactory();
            Fruit banana = bananaFactory.getFruit();
            PearFactory pearFactory = new PearFactory();
            Fruit pear = pearFactory.getFruit();
            apple.get();
            banana.get();
            pear.get();

        }catch (Exception e){

        }finally {

        }
    }

}
