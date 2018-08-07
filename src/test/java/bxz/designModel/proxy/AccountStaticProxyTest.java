package bxz.designModel.proxy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * AccountStaticProxy Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>08/07/2018</pre>
 */
public class AccountStaticProxyTest {

	@Before
	public void before() throws Exception {
	}

	@After
	public void after() throws Exception {
	}


	@Test
	public void testMain(){
		AccountStaticProxy accountStaticProxy = new AccountStaticProxy(new AccountImpl());
		accountStaticProxy.queryAccount();
		accountStaticProxy.updateAccount();
	}

	@Test
	public void testQueryAccount() throws Exception {
		AccountStaticProxy accountStaticProxy = new AccountStaticProxy(new AccountImpl());
		accountStaticProxy.queryAccount();
	}

	@Test
	public void testUpdateAccount() throws Exception {
		AccountStaticProxy accountStaticProxy = new AccountStaticProxy(new AccountImpl());
		accountStaticProxy.updateAccount();
	}


} 
