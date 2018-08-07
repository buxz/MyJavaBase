package bxz.designModel.proxy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * AccountDynamicProxy Tester.
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
	public void testGetInstance() throws Exception {
		AccountDynamicProxy dynamicProxy = new AccountDynamicProxy();
		Account account = (Account) dynamicProxy.getInstance(new AccountImpl());
		account.queryAccount();
		account.updateAccount();
	}

	/**
	 * Method: invoke(Object proxy, Method method, Object[] args)
	 */
	@Test
	public void testInvoke() throws Exception {
//TODO: Test goes here... 
	}


} 
