package strategy.strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public double cost(double money){
        return this.strategy.cost(money);
    }
}
