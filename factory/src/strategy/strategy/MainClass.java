package strategy.strategy;


public class MainClass {
    public static void main(String[] args) {
        double money = 200;
        Context context = new Context(new StrategyA());
        money = context.cost(money);
        System.out.println("实际付账:"+ money + "元");
        System.out.println("---------------------------");

        double money2 = 200;
        Context context2 = new Context(new StrategyB());
        money2 = context2.cost(money2);
        System.out.println("实际付账:"+ money2 + "元");
        System.out.println("---------------------------");
    }

}
