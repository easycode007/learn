package patterns.decorator.window;

/**
 * Created by Razvan on 26.01.2017.
 */
public class DecoratedWindow implements Window {
    private Window privateWindowRefernce;

    public DecoratedWindow(Window windowRefernce) {
        this.privateWindowRefernce = windowRefernce;
    }

    @Override
    public void renderWindow() {
        privateWindowRefernce.renderWindow();
    }
}
