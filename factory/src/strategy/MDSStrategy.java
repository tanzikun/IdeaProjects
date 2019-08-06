package strategy;

public class MDSStrategy implements Strategy{
    @Override
    public void encrypt() {
        System.out.println("执行MDS");
    }
}
