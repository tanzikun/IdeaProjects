package prototype;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("test1");
        person1.setAge(20);
        person1.setSex("男");

        Person person2 = person1.clone();
        person2.setName("test2");
        System.out.println(person1);
        System.out.println(person2);

        Person2 person21 = new Person2();
        List<String> friends = new ArrayList<>();
        friends.add("James");
        friends.add("Yao");
        person21.setFriend(friends);

        Person2 person22 = person21.clone();

        System.out.println(person21.getFriend());
        System.out.println(person22.getFriend());

        friends.add("Mac");
        person21.setFriend(friends);

        System.out.println(person21.getFriend());
        System.out.println(person22.getFriend());


        Person3 person31 = new Person3();
        List<String> friends3 = new ArrayList<>();
        friends3.add("James");
        friends3.add("Yao");
        person31.setFriend(friends3);

        Person3 person32 = person31.clone();

        System.out.println(person31.getFriend());
        System.out.println(person32.getFriend());

        friends3.add("Mac");
        person21.setFriend(friends3);

        System.out.println(person31.getFriend());
        System.out.println(person32.getFriend());
    }

}
