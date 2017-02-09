package patterns.decorator.window;

/**
 * Created by Razvan on 26.01.2017.
 */
public class ScrollableWindow extends DecoratedWindow {
    public ScrollableWindow(Window windowRefernce) {
        super(windowRefernce);
    }

    @Override
    public void renderWindow() {
        System.out.println("Scrollable Window render method");
        //super.renderWindow();
    }
}
