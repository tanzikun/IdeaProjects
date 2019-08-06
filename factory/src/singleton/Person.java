package singleton;


/**
 * 饿汉式
 */
public class Person {

    //类加载的时候实例化，可保证线程安全
    public  static final Person person = new Person();

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //构造函数私有化
    private Person(){}

    //提供一个全局的静态方法
    public  static  Person getPerson(){
        return person;
    }
}
