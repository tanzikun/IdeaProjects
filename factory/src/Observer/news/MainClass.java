package Observer.news;

public class MainClass {

    public static void main(String[] args) {
        BlogUser user = new BlogUser();
        user.addObserver(new MyObserver());
        user.publishBlog("title", "test123123123");
        System.out.println(111);
        try{ throw new Exception();} catch(Exception e){
            System.out.println(222);
        }


        int index = 1;
        int foo[] = new int[3]; int bar = foo[index]; int baz = bar + index;
        System.out.println(baz);
    }

    public static void operate(StringBuffer x, StringBuffer y) { x.append(y);
        y = x;
    }



}
