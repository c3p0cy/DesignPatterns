package tw.cy.basic.DesignPattern.strategy;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class PngLoaderTest {

    @Test
    public void load() {
        ImageLoadable loader = new PngLoader();
        assertEquals(loader.load(null), "PNG loaded");
    }
}
