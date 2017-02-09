package patterns.strategy.calculator;

/**
 * Created by Razvan on 27.01.2017.
 */
public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
