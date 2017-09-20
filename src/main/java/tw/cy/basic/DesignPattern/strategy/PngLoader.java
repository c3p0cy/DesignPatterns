package tw.cy.basic.DesignPattern.strategy;

public class PngLoader implements ImageLoadable {

    public Object load(String filePath) {
        return "PNG loaded";
    }
    
}
