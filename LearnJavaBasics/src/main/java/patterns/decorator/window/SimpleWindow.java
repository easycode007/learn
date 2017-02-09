package patterns.decorator.window;

/**
 * Created by Razvan on 26.01.2017.
 */
public class SimpleWindow implements Window {
    @Override
    public void renderWindow() {
        System.out.println("Simple window render method");
    }
}
