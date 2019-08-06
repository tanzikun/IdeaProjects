package decorator.news;

public class MainClass {

    public static void main(String[] args) {
        Car runCar = new RunCar();
        CarDecorator carDecorator = new FlyCarDecorator(runCar);
        carDecorator.show();
        System.out.println("------------------");
        CarDecorator carDecorator2 = new SwimCarDecorator(runCar);
        carDecorator2.show();
        System.out.println("------------------");
        Car flySwimCar = new FlyCarDecorator(carDecorator2);
        flySwimCar.show();
        System.out.println("------------------");
    }

}
