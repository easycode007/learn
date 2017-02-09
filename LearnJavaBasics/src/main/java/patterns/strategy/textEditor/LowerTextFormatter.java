package patterns.strategy.textEditor;

/**
 * Created by Razvan on 27.01.2017.
 */
public class LowerTextFormatter implements TextFormatter {
    @Override
    public void format(String text) {
        System.out.println("[LowerTextFormatter]: "+text.toLowerCase());
    }
}
