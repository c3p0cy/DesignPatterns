package tw.cy.basic.DesignPattern.strategy;

public class ImageLoader {

    public static enum ImageType { GIF, JPEG, PNG, ICO }
    
    public Object load(String filePath, ImageType type) {
        switch (type) {
        case GIF:
            return loadGif(filePath);
        case JPEG:
            return loadJpeg(filePath);
        case PNG:
            return loadPng(filePath);
        case ICO:
            return loadIco(filePath);
        default:
            throw new RuntimeException("Unknow ImageType" + type);
        }
    }
    
    private String loadIco(String filePath) {
        return "ICO loaded";
    }
    
    
    private String loadGif(String filePath) {
        return "GIF loaded";
    }
    
    private String loadJpeg(String filePath) {
        return "JPEG loaded";
    }
    
    private String loadPng(String filePath) {
        return "PNG loaded";
    }
}
