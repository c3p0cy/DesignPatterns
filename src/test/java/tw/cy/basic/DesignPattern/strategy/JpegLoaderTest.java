package tw.cy.basic.DesignPattern.strategy;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class JpegLoaderTest {

    @Test
    public void load() {
        ImageLoadable loader = new JpegLoader();
        assertEquals(loader.load(null), "JPEG loaded");
    }
}
