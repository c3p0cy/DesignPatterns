package tw.cy.basic.designpattern.singleton;

import java.io.Serializable;

import lombok.extern.slf4j.Slf4j;

/**
 * 利用 method 及 synchronized 達成 lazy 及多執行者免役
 * 
 * 缺點：<br />
 * # 使用 synchronized 導致效能問題<br />
 * # 無法避免反射
 * 
 * @author Plus
 *
 */
@Slf4j
public class StaticFieldWithSyncLazyInitializeGetter implements Serializable {

	private static final long serialVersionUID = 1L;
	private static StaticFieldWithSyncLazyInitializeGetter instance;

	private StaticFieldWithSyncLazyInitializeGetter() {
		log.debug(String.format("%s: construct start", this.hashCode()));
		try {
			Thread.sleep(500L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug(String.format("%s: construct end", this.hashCode()));
	}

	public static StaticFieldWithSyncLazyInitializeGetter getInstance() {
		if (instance == null) {
			synchronized (StaticFieldWithSyncLazyInitializeGetter.class) {
				if (instance == null) {
					instance = new StaticFieldWithSyncLazyInitializeGetter();
				}
			}
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
