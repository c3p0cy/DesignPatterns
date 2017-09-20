package tw.cy.basic.DesignPattern.strategy;

public class GifLoader extends ImageLoader {

    @Override
    public Object load(String filePath) {
        return "GIF loaded";
    }
    
}
