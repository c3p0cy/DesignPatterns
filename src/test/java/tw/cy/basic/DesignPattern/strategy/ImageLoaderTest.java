package tw.cy.basic.DesignPattern.strategy;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ImageLoaderTest {

    @Test
    public void load() {
        ImageLoader loader = new ImageLoader();
        try {
            assertEquals(loader.load(null, ImageLoader.ImageType.GIF), "GIF loaded");
            assertEquals(loader.load(null, ImageLoader.ImageType.JPEG), "JPEG loaded");
            assertEquals(loader.load(null, ImageLoader.ImageType.PNG), "PNG loaded");
        } catch (InstantiationException |IllegalAccessException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
