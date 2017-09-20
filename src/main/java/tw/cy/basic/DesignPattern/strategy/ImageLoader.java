package tw.cy.basic.DesignPattern.strategy;

import lombok.Setter;

public class ImageLoader {

    public static enum ImageType {
        GIF, JPEG, PNG, ICO;
    }

    @Setter
    private ImageLoadable loader;
    
    public Object load(String filePath) {
        return loader.load(filePath);
    }

    public Object load(String filePath, ImageType type)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return getLoader(type).load(filePath);
    }

    private ImageLoadable getLoader(ImageType type)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        String fullName = String.format("%s.%sLoader", this.getClass().getPackage().getName(), convertName(type));
        return (ImageLoadable) Class.forName(fullName).newInstance();
    }

    private String convertName(ImageType type) {
        String name = type.name();
        return String.format("%s%s", name.substring(0, 1), name.substring(1, name.length()).toLowerCase());
    }

}
