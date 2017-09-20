package tw.cy.basic.DesignPattern.strategy;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import static tw.cy.basic.DesignPattern.strategy.ImageLoader.ImageType;

public class ImageLoaderTest {

  @Test
  public void load() {
    ImageLoader loader = new ImageLoader();
    assertEquals(loader.load(null, ImageType.GIF), "GIF loaded");
    assertEquals(loader.load(null, ImageType.JPEG), "JPEG loaded");
    assertEquals(loader.load(null, ImageType.PNG), "PNG loaded");
    assertEquals(loader.load(null, ImageType.ICO), "ICO loaded");
  }
}
