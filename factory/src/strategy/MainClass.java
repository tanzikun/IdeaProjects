package strategy;

public class MainClass {
    public static void main(String[] args) {
        MD5Strategy stra = new MD5Strategy();
        stra.encrypt();

        MDSStrategy stra2 = new MDSStrategy();
        stra2.encrypt();

        System.out.println("---------------------------");

        Context context =  new Context(stra);
        context.encrypt();

        Context context2 =  new Context(stra2);
        context2.encrypt();

        System.out.println("---------------------------");


    }

}
