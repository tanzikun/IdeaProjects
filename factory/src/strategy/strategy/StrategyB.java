package strategy.strategy;

public class StrategyB implements Strategy {
    @Override
    public double cost(double money) {
        if(money >= 200){
            money = money - 50;
        }
        return money;
    }
}
