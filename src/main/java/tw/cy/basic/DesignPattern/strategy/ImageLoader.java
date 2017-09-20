package tw.cy.basic.DesignPattern.strategy;

public abstract class ImageLoader {

    public static enum ImageType { GIF, JPEG, PNG, ICO }
    
    public abstract Object load(String filePath);
    
}
