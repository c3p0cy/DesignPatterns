package tw.cy.basic.DesignPattern.strategy;

public class JpegLoader implements ImageLoadable {

    public Object load(String filePath) {
        return "JPEG loaded";
    }

}
