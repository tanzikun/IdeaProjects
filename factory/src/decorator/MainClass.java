package decorator;

public class MainClass {

    public static void main(String[] args) {
        Car flyCar = new FlyCar();
        flyCar.show();
        Car swinCar = new SwinCar();
        swinCar.show();
    }

}
