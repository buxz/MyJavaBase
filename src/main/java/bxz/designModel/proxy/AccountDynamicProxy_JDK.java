package bxz.designModel.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by SQ_BXZ on 2018-08-07.
 * JDK动态代理是基于接口实现的，采用的是反射原理。
 */
public class AccountDynamicProxy_JDK implements InvocationHandler {

	private Object object;

	/**
	 * 绑定委托对象并生成代理类
	 * @param target
	 * @return
	 */
	public Object getInstance(Object target) {
		this.object = target;
		// 参数列表：类，方法，参数
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
	}


	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result=null;
		System.out.println("before-----");
		//执行方法
		result=method.invoke(object, args);
		System.out.println("after-----");
		return result;
	}
}
