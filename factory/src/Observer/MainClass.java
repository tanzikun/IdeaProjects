package Observer;

public class MainClass {

    public static void main(String[] args) {

        Person person = new Person();

        //注册观察者
        person.addObserver(new MyObserver());
        person.addObserver(new MyObserver());
        person.setName("test");
        person.setAge(22);
        person.setSex("男");

        System.out.println(person.countObservers());
    }

}
