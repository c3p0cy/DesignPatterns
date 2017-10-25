package tw.cy.basic.designpattern.singleton;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StaticFinalInstanceWithGetter {

	private static final StaticFinalInstanceWithGetter instance = new StaticFinalInstanceWithGetter();;

	private StaticFinalInstanceWithGetter() {
		log.debug(String.format("%s: construct start",this.hashCode()));
		try {
			Thread.sleep(500L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug(String.format("%s: construct end",this.hashCode()));
	}

	public static StaticFinalInstanceWithGetter getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		// StaticFinalInstanceWithGetter s1 = getInstance();
		// StaticFinalInstanceWithGetter s2 = getInstance();
		// log.debug("s1 == s2 ? " + (s1 == s2)); //true

		// 多執行緒下的併發會產生相同的 instance
		final StaticFinalInstanceWithGetter[] s3 = new StaticFinalInstanceWithGetter[2];
		new Thread(() -> s3[0] = getInstance()).start();
		new Thread(() -> s3[1] = getInstance()).start();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug("s3[0] == s3[1] ? " + (s3[0] == s3[1])); // true
		log.debug("getInstance: " + getInstance());
	}

}
