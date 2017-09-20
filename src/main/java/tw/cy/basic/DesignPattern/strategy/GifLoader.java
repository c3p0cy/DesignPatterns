package tw.cy.basic.DesignPattern.strategy;

public class GifLoader implements ImageLoadable {

    public Object load(String filePath) {
        return "GIF loaded";
    }

}
