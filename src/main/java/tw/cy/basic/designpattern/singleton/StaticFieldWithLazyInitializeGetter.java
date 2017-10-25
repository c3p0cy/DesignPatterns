package tw.cy.basic.designpattern.singleton;

import java.io.Serializable;

import lombok.extern.slf4j.Slf4j;

/**
 * 缺點：<br />
 * # 無法避免多執行緒 # 無法避免反射
 * 
 * @author Plus
 *
 */
@Slf4j
public class StaticFieldWithLazyInitializeGetter implements Serializable {

	private static final long serialVersionUID = 1L;
	private static StaticFieldWithLazyInitializeGetter instance;

	private StaticFieldWithLazyInitializeGetter() {
		log.debug(String.format("%s: construct start", this.hashCode()));
		try {
			Thread.sleep(500L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug(String.format("%s: construct end", this.hashCode()));
	}

	public static StaticFieldWithLazyInitializeGetter getInstance() {
		if (instance == null) {
			instance = new StaticFieldWithLazyInitializeGetter();
		}
		return instance;
	}

	/**
	 * Prevents the creation of a new instance when deserializing, always return
	 * the current instance.
	 * 
	 * @return
	 */
	public Object readResolve() {
		return instance;
	}
}
