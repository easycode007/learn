package patterns.strategy.textEditor;

/**
 * Created by Razvan on 27.01.2017.
 */
public class TextEditor {
    private final TextFormatter textFormatter;

    public TextEditor(TextFormatter textFormatter) {
        this.textFormatter = textFormatter;
    }

    public void publishText(String text) {
        textFormatter.format(text);
    }
}
