package tw.cy.basic.DesignPattern.strategy;

public class PngLoader extends ImageLoader {

    @Override
    public Object load(String filePath) {
        return "PNG loaded";
    }
    
}
