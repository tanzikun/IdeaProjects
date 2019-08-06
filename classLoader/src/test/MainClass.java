package test;

public class MainClass {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        /*MyClassLoader loader = new MyClassLoader("E:/temp/", "Zhangfei");
        Class<?> c = loader.loadClass("Demo");*/
        MyClassLoader loader = new MyClassLoader("E:/temp/", "Zhangfei");
        Class<?> c = loader.loadClass("test.Demo");
        c.newInstance();
        MyClassLoader wuKongLoader = new MyClassLoader(loader,"E:/temp/", "WuKong");
        Class<?> c2 = wuKongLoader.loadClass("test.Demo");
        c2.newInstance();

        MyClassLoader baJieLoader = new MyClassLoader(null,"E:/temp/", "baJie");
        Class<?> c3 = baJieLoader.loadClass("test.Demo");
        c3.newInstance();
    }

}
