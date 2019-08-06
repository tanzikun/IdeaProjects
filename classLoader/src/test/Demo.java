package test;

public class Demo {

    public Demo(){
        System.out.println("A demo" + this.getClass().getClassLoader());
    }

    public static void main(String[] args) {
        System.out.println(Demo.class.getClassLoader()); //sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader loader =  Demo.class.getClassLoader();
        while (loader != null){
            System.out.println(loader);
            loader = loader.getParent();
        }
        System.out.println(loader);
    }

    /**
     * sun.misc.Launcher$AppClassLoader@18b4aac2
     * sun.misc.Launcher$AppClassLoader@18b4aac2
     * sun.misc.Launcher$ExtClassLoader@14ae5a5
     * null
     */
}
