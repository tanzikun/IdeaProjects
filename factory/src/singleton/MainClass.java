package singleton;

public class MainClass {
    public static void main(String[] args) {
        Person2 per = Person2.getPerson();
        Person2 per2 = Person2.getPerson();

        per.setName("1");
        per2.setName("2");
        System.out.println(per);
        System.out.println(per2);
    }

}
