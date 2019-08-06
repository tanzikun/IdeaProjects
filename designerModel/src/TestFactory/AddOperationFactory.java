package TestFactory;

public class AddOperationFactory implements OperationFactory{

    public Operation getOperation(String oper){
        return new AddOperation();
    }
}
