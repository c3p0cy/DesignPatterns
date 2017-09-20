package tw.cy.basic.DesignPattern.strategy;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import static tw.cy.basic.DesignPattern.strategy.ImageLoader.ImageType;

public class PngLoaderTest {

    @Test
    public void load() {
        ImageLoadable loader = new PngLoader();
        assertEquals(loader.load(null), "PNG loaded");
    }
}
