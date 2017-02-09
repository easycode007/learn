package patterns.strategy;

import patterns.strategy.calculator.Context;
import patterns.strategy.calculator.OperationAdd;
import patterns.strategy.calculator.OperationMultiply;
import patterns.strategy.calculator.OperationSubstract;
import patterns.strategy.textEditor.CapTextFormatter;
import patterns.strategy.textEditor.LowerTextFormatter;
import patterns.strategy.textEditor.TextEditor;
import patterns.strategy.textEditor.TextFormatter;

/**
 * Created by Razvan on 27.01.2017.
 */
public class MainClass {

    public static void textEditor() {
        TextFormatter formatter = new CapTextFormatter();
        TextEditor editor = new TextEditor(formatter);
        editor.publishText("Testing text in caps formatter");
        formatter = new LowerTextFormatter();
        editor = new TextEditor(formatter);
        editor.publishText("Testing text in lower formatter");
    }

    public static void calculator() {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
    public static void main(String[] args) {
        calculator();
    }
}
