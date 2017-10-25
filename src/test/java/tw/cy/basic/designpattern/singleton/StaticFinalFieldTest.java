package tw.cy.basic.designpattern.singleton;

import static org.junit.Assert.assertSame;
import static tw.cy.basic.designpattern.singleton.StaticFinalField.*;

import org.junit.Test;

/**
 * In order to correct test, you need to run test method individually.
 * 
 * @author Plus
 *
 */
public class StaticFinalFieldTest {

	@Test
	public void testGetInstance() {
		StaticFinalField s1 = getInstance();
		StaticFinalField s2 = getInstance();
		assertSame(s1, s2);
	}

	@Test
	public void testGetInstanceByMultiThreads() throws InterruptedException {
		final StaticFinalField[] s = new StaticFinalField[2];
		new Thread(() -> s[0] = getInstance()).start();
		new Thread(() -> s[1] = getInstance()).start();
		Thread.sleep(1000L);
		assertSame(s[0], s[1]);
	}
}
