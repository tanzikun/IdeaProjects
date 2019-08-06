package Proxy.dongtai;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {

    private  RealSubject realSubject;

    public void setRealSubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        dazhe();
        Object result = method.invoke(realSubject, args);
        give();
        return result;
    }

    public void dazhe(){
        System.out.println("打折");
    }

    public void give(){
        System.out.println("送代金券");
    }
}
