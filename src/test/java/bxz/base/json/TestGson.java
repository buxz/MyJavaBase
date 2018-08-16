package bxz.base.json;

import bxz.base.entity.Apple;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SQ_BXZ on 2018-08-16.
 */
public class TestGson {

	/**
	 *  将bean转换成Json字符串
	 */
	@Test
	public void   testBeanToJsonString(){
		Apple apple = new Apple();
		apple.setPrice(10);
		apple.setName("测试");
		System.out.println(new Gson().toJson(apple));
	}

	/**
	 *  Json字符串 转换成 bean
	 */
	@Test
	public void   testJsonStringToBean(){
		Apple apple = new Apple();
		apple.setPrice(10);
		apple.setName("测试");
		String temp = new Gson().toJson(apple);
		System.out.println(temp);

		// Json字符串 转换成 bean
		Apple apple2 = new Gson().fromJson(temp,Apple.class);
		System.out.println(apple2.getName());
	}


	/**
	 *  Json字符串转换成JsonObject对象
	 */
	@Test
	public void   testJsonStringToJsonObject(){
		Apple apple = new Apple();
		apple.setPrice(10);
		apple.setName("测试");
		String temp = new Gson().toJson(apple);
		System.out.println(temp);

		// Json字符串转换成JsonObject对象
		JsonObject returnData = new JsonParser().parse(temp).getAsJsonObject();
		System.out.println(returnData.get("price").getAsString());
	}

	/**
	 *  将JsonArray类型的Json字符串解析成对象方法
	 */
	@Test
	public void   testJsonStringToJsonObject1(){
		String json = "[{\"username\":\"test\"},{\"username\":\"test2\"}]";
		JsonArray jsonArray = new JsonParser().parse(json).getAsJsonArray();
		for (JsonElement jsonElement : jsonArray) {
			System.out.println(jsonElement.getAsJsonObject());
		}
		System.out.println(new JsonParser().parse(json).getAsJsonArray().get(1).getAsJsonObject().get("username").getAsString());
	}

	/**
	 *
	 *  获取JsonObject中指定key值对应的JsonArray对象
	 */
	@Test
	public void   testJsonStringToJsonObject2(){
		String json= "{\"pids\":[\"1\",\"2\",\"3\"]}";
		System.out.println(new JsonParser().parse(json).getAsJsonObject().getAsJsonArray("pids").get(1).getAsString());
	}



	/**
	 *
	 *  获取JsonObject中指定key值对应的JsonArray对象
	 */
	@Test
	public void   testJsonStringToJsonObject3(){

		// 初始化数据对象
		ArrayList<Apple> arrayList = new ArrayList<Apple>();
		Apple person = null;
		// 初始化arraylist容器 100个person对象
		for (int i = 0; i < 3; i++) {
			person = new Apple();
			person.setPrice(i);
			person.setName(i + ", name");
			arrayList.add(person);
		}

		// 将list集合变成json格式
		Gson gson = new Gson();
		String str = gson.toJson(arrayList);
		System.out.println(str);

		// 将str json格式变成 list格式
		List<Apple> list = gson.fromJson(str, new TypeToken<List<Apple>>() {}.getType());
		// 输出list集合
		for (int i = 0; i < 3; i++) {
			System.out.println(list.get(i).getName());
		}

	}
}
