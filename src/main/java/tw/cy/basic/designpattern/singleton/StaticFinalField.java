package tw.cy.basic.designpattern.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 缺點：<br />
 * # 類別載入時就會進行初始化<br />
 * # 呼叫靜態方法時，即使未使用到該 instance 也會觸發類別載入<br />
 * # 無法避免反射
 * 
 * @author Plus
 *
 */
@Slf4j
public class StaticFinalField {

	private static final StaticFinalField instance = new StaticFinalField();

	private StaticFinalField() {
		log.debug(String.format("%s: construct start", this.hashCode()));
		try {
			Thread.sleep(500L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug(String.format("%s: construct end", this.hashCode()));
	}

	public static StaticFinalField getInstance() {
		return instance;
	}

	/**
	 * 呼叫此方法時，雖未使用到 instance，仍會初始化 instance
	 */
	public static void callThisWillForceInitialInstance() {
	}
}
