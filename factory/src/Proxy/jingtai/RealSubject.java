package Proxy.jingtai;

public class RealSubject implements Subject{


    @Override
    public void sailBook() {
        System.out.println("买书");
    }
}
