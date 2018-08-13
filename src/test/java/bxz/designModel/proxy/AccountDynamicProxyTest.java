package bxz.designModel.proxy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * AccountDynamicProxy_JDK Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>08/07/2018</pre>
 */
public class AccountDynamicProxyTest {

	@Before
	public void before() throws Exception {
	}

	@After
	public void after() throws Exception {
	}

	/**
	 * Method: getInstance(Object target)
	 */
	@Test
	public void testJDK() throws Exception {
		Account account = (Account) new AccountDynamicProxy_JDK().getInstance(new AccountImpl());

		account.queryAccount();
		account.updateAccount();
	}

	/**
	 * Method: invoke(Object proxy, Method method, Object[] args)
	 */
	@Test
	public void testCGLIB() throws Exception {

		/**
		 * Cgliber可以看成是一个带有类生成能力的方法回调器
		 */
		AccountDynamicProxy_CGLIB cgliber = new AccountDynamicProxy_CGLIB();

		/**
		 *  使用方法回调器的类生成功能生成代理类实例：mayunCgliber
		 *  由于getInstance方法返回值为Object类型，并不是MaYun类的子类型，
		 *  所以需要将其强转为MaYun类型，实际上mayunCgliber是代理实例
		 */
		MaYun mayunCgliber = (MaYun) cgliber.getInstance(new MaYun());
		mayunCgliber.quanli();

	}


} 
