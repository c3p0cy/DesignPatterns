package tw.cy.basic.designpattern.singleton;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static tw.cy.basic.designpattern.singleton.StaticFieldWithSyncLazyInitializeGetter.getInstance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

/**
 * In order to correct test, you need to run test method individually.
 * 
 * @author Plus
 *
 */
public class StaticFieldWithSyncLazyInitializeGetterTest {

	@Test
	public void testGetInstance() {
		StaticFieldWithSyncLazyInitializeGetter s1 = getInstance();
		StaticFieldWithSyncLazyInitializeGetter s2 = getInstance();
		assertSame(s1, s2);
	}

	@Test
	public void testGetInstanceByMultiThreads() throws InterruptedException {
		final StaticFieldWithSyncLazyInitializeGetter[] s = new StaticFieldWithSyncLazyInitializeGetter[2];
		new Thread(() -> s[0] = getInstance()).start();
		new Thread(() -> s[1] = getInstance()).start();
		Thread.sleep(1000L);
		assertSame(s[0], s[1]);
	}

	/**
	 * Passed when no readResolve() defined
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetInstanceBySerialize() throws Exception {
		StaticFieldWithSyncLazyInitializeGetter s1 = getInstance();
		StaticFieldWithSyncLazyInitializeGetter s2 = null;

		try (FileOutputStream fos = new FileOutputStream("StaticFieldWithSyncLazyInitializeGetter.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(s1);
			oos.flush();
		}

		try (FileInputStream fis = new FileInputStream("StaticFieldWithSyncLazyInitializeGetter.txt");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			s2 = (StaticFieldWithSyncLazyInitializeGetter) ois.readObject();
		}
		
		assertNotSame(String.format("s1(%s) == s2(%s)", s1.hashCode(), s2.hashCode()), s1, s2);
	}

	/**
	 * Passed when having readResolve() defined
	 * @throws Exception
	 */
	@Test
	public void testGetInstanceBySerializeWithReadResolveMethod() throws Exception {
		StaticFieldWithSyncLazyInitializeGetter s1 = getInstance();
		StaticFieldWithSyncLazyInitializeGetter s2 = null;

		try (FileOutputStream fos = new FileOutputStream("StaticFieldWithSyncLazyInitializeGetter.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(s1);
			oos.flush();
		}

		try (FileInputStream fis = new FileInputStream("StaticFieldWithSyncLazyInitializeGetter.txt");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			s2 = (StaticFieldWithSyncLazyInitializeGetter) ois.readObject();
		}
		
		assertSame(String.format("s1(%s) == s2(%s)", s1.hashCode(), s2.hashCode()), s1, s2);
	}
}
