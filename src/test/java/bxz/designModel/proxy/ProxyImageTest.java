package bxz.designModel.proxy; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After; 

/** 
* ProxyImage Tester. 
* 
* @author <Authors name> 
* @since <pre>08/07/2018</pre> 
* @version 1.0 
*/ 
public class ProxyImageTest {

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: display() 
* 
*/ 
@Test
public void testDisplay() throws Exception {
	Image image = new ProxyImage("test_10mb.jpg");
	//图像将从磁盘加载
	image.display();

	System.out.println("");
	//图像将无法从磁盘加载
//	image.display();
}


} 
