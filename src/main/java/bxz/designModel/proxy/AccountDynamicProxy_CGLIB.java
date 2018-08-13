package bxz.designModel.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/**
 * Cglib 就犹如一个代码式的类生成器，一般手动创建类的内容涉及到的东西，都需要通过Cglib提供的API来完成。
 * 如下代码中：设置超类和设置回调，对应于正常类编写时，编写的继承类与方法回调
 * 这里实现的是MethodInterceptor接口（方法拦截器），这个接口的作用就是实现方法拦截（回调）
 *
 */
public class AccountDynamicProxy_CGLIB implements MethodInterceptor{

	//这个target指的就是被代理类的实例
	private Object target;

    /*
     * 生成代理实例（依据被代理类来生成代理类），Enhancer则是代理类生成工具
     */
    public Object getInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());//设置被继承类(超类)
        enhancer.setCallback(this);//设置回调
        return enhancer.create();
    }
    /*
     * 回调方法
     * intercept是拦截之意，此处是指使用代理方法proxy来调用原类（obj）中的指定方法（method），带参数（args），
     */
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        System.out.println("开始调用---");
        proxy.invokeSuper(obj, args);
        System.out.println("结束调用---");

        return null;
    }
}