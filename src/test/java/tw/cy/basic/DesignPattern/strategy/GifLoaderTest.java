package tw.cy.basic.DesignPattern.strategy;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class GifLoaderTest {

    @Test
    public void load() {
        ImageLoadable loader = new GifLoader();
        assertEquals(loader.load(null), "GIF loaded");
    }
}
