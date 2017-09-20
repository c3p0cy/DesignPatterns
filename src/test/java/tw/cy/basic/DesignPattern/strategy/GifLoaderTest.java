package tw.cy.basic.DesignPattern.strategy;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import static tw.cy.basic.DesignPattern.strategy.ImageLoader.ImageType;

public class GifLoaderTest {

    @Test
    public void load() {
        ImageLoadable loader = new GifLoader();
        assertEquals(loader.load(null), "GIF loaded");
    }
}
