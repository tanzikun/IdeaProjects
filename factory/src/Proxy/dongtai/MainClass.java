package Proxy.dongtai;


import java.lang.reflect.Proxy;

public class MainClass {
    /**
     * 动态代理
     * @param args
     */
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        MyHandler myHandler = new MyHandler();
        myHandler.setRealSubject(realSubject);

        Subject proxySubject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), realSubject.getClass().getInterfaces(), myHandler);
        proxySubject.sailBook();

    }

}
