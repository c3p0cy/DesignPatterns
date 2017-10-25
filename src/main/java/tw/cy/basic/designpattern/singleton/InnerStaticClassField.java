package tw.cy.basic.designpattern.singleton;

import java.io.Serializable;

import lombok.extern.slf4j.Slf4j;

/**
 * 利用類別初始化時天生多執緒免役特性
 * 
 * 缺點：<br />
 * # 無法避免反射
 * 
 * @author Plus
 *
 */
@Slf4j
public class InnerStaticClassField implements Serializable {

	private static final long serialVersionUID = 1L;

	private static class Inner {
		public static final InnerStaticClassField instance = new InnerStaticClassField();
	}

	private InnerStaticClassField() {
		log.debug(String.format("%s: construct start", this.hashCode()));
		try {
			Thread.sleep(500L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug(String.format("%s: construct end", this.hashCode()));
	}

	public static InnerStaticClassField getInstance() {
		return Inner.instance;
	}

	/**
	 * Prevents the creation of a new instance when deserializing, always return
	 * the current instance.
	 * 
	 * @return
	 */
	public Object readResolve() {
		return getInstance();
	}

}
