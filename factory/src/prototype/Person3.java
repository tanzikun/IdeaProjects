package prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度克隆
 */

public class Person3 implements Cloneable{
    //姓名
    private String name;
    //年龄
    private int age;
    //性别
    private String sex;
    //
    private List<String> friend;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<String> getFriend() {
        return friend;
    }

    public void setFriend(List<String> friend) {
        this.friend = friend;
    }

    public Person3 clone(){
        try {
            Person3 person = (Person3)super.clone();
            List<String> friends = new ArrayList<>();
            for (String f : this.getFriend()){
                friends.add(f);
            }
            person.setFriend(friends);
            return person;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", friend=" + friend +
                '}';
    }
}
