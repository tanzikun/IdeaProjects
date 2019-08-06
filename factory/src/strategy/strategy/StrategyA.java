package strategy.strategy;

public class StrategyA implements Strategy {
    @Override
    public double cost(double money) {
        return money * 0.8;
    }
}
