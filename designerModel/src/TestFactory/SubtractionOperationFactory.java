package TestFactory;

public class SubtractionOperationFactory implements OperationFactory{

    public Operation getOperation(String oper){
        return new SubtractionOperation();
    }
}
