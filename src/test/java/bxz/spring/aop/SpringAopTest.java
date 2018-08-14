package bxz.spring.aop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.naming.Name;

/**
 * TimeHandler Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>08/14/2018</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/aop.xml"})
public class SpringAopTest {

	@Autowired
	private HelloWorld helloWorldImpl1;
	@Autowired
	private HelloWorld helloWorldImpl2;

	@Before
	public void before() throws Exception {
	}

	@After
	public void after() throws Exception {
	}

	@Test
	public void testAop() throws Exception {

		helloWorldImpl1.printHelloWorld();
		System.out.println();
		helloWorldImpl1.doPrint();
		System.out.println();
		helloWorldImpl2.printHelloWorld();
		System.out.println();
		helloWorldImpl2.doPrint();
	}


} 
