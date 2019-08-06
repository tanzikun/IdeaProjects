package Proxy.jingtai;

public class MainClass {
    /**
     * 静态代理
     * @param args
     */
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        realSubject.sailBook();

        ProxySubject proxySubject = new ProxySubject();
        proxySubject.setRealSubject(realSubject);
        proxySubject.sailBook();
    }

}
