package tw.cy.basic.DesignPattern.strategy;

public class JpegLoader extends ImageLoader {

    @Override
    public Object load(String filePath) {
        return "JPEG loaded";
    }
    
}
