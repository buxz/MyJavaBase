package com.bxz.reflection;

import bxz.base.entity.Apple;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by SQ_BXZ on 2018-08-07.
 */

public class TestReflection {

	/**
	 * 正射
	 */
	@Test
	public void testBase() {
		Apple apple = new Apple();
		apple.setPrice(4);
		System.out.println("正射获得价格--"+apple.getPrice());

	}

	/**
	 * 反射测试
	 */
	@Test
	public void testReflection() throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
		// 获取类的 Class 对象实例
		Class testClass = Class.forName("bxz.base.entity.Apple");
		// 根据 Class 对象实例获取 Constructor 对象
		Constructor constructor = testClass.getConstructor();
		// 使用 Constructor 对象的 newInstance 方法获取反射类对象
		Object object = constructor.newInstance();

		// 获取方法
		Method setPrice = testClass.getMethod("setPrice", int.class);
		// 利用 invoke 方法调用方法
		setPrice.invoke(object,14);
		// 获取方法
		Method getPrice = testClass.getMethod("getPrice");
		System.out.println("反射获得价格--"+getPrice.invoke(object));

	}


}
