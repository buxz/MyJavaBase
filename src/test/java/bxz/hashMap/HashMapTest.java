package bxz.hashMap;


import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * hashMap 概念：
 * 	1. 散列表（映射顺序无序），键值对形式存储
 * 	2. 非同步，非线程安全
 * 	3. hashMap通过“拉链法”实现哈希表
 *
 * 重要参数：
 * 	1. 初始容量，哈希表在创建时的容量
 * 	2. 加载因子，哈希表在其容量自动增加之前可以达到多满的一种尺度；
 * 	    当哈希表中的条目数超出加载因子与当前容量的乘积时，则要对该哈希表进行rehash操作（重构内部数据结构），
 * 	    从而哈希表将具有大约两倍的桶数
 *
 */
public class HashMapTest {

    private HashMap map;

    /**
     * hashMap的常用操作
     */
    @Test
    public void testHashMapAPIs() {
        // 初始化随机种子
        Random random = new Random();
        // 新建HashMap
        HashMap<String,Integer> map = new HashMap<>();
        // 添加操作
        map.put("one", random.nextInt(10));
        map.put("two", random.nextInt(10));
        map.put("three", random.nextInt(10));

        // 打印出map
        System.out.println("map:" + map);

        // 通过Iterator遍历key-value
        for (Object o : map.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println("next : " + entry.getKey() + " - " + entry.getValue());
        }

        // HashMap的键值对个数
        System.out.println("size:" + map.size());

        // containsKey(Object key) :是否包含键key
        System.out.println("contains key two : " + map.containsKey("two"));
        System.out.println("contains key five : " + map.containsKey("five"));

        // containsValue(Object value) :是否包含值value
        System.out.println("contains value 0 : " + map.containsValue(new Integer(0)));

        // remove(Object key) ： 删除键key对应的键值对
        map.remove("three");

        System.out.println("map:" + map);

        // clear() ： 清空HashMap
        map.clear();

        // isEmpty() : HashMap是否为空
        System.out.println((map.isEmpty() ? "map is empty" : "map is not empty"));
    }

    /**
     * 初始化 hashMap值
     */
    @Before
    public void setHashMap() {
        map = new HashMap();
        int val = 0;
        String key = null;
        Integer value = null;
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            // 随机获取一个[0,100)之间的数字
            key = String.valueOf(random.nextInt(100));
            value = random.nextInt(5);
            // 添加到HashMap中
            map.put(key, value);
            System.out.println(" key:" + key + " value:" + value);
        }
    }

    /*
     * 通过entry set遍历HashMap
     * 效率高!
     */
    @Test
    public void iteratorHashMapByEntryset() {
        System.out.println("\niterator HashMap By entryset");
        String key = null;
        Integer integ = null;
        for (Object o : map.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            key = (String) entry.getKey();
            integ = (Integer) entry.getValue();
            System.out.println(key + " -- " + integ.intValue());
        }
    }

    /*
     * 通过keyset来遍历HashMap
     * 效率低!
     */
    @Test
    public void iteratorHashMapByKeyset() {
        System.out.println("\niterator HashMap By keyset");
        String key = null;
        Integer integ = null;
        for (Object o : map.keySet()) {
            key = (String) o;
            integ = (Integer) map.get(key);
            System.out.println(key + " -- " + integ.intValue());
        }
    }

    /*
     * 遍历HashMap的values
     */
    @Test
    public void iteratorHashMapJustValues() {
        for (Object aC : map.values()) {
            System.out.println(aC);
        }
    }

    @Test
    public void hashMap() {
        System.out.println(1 << 30);
        System.out.println(2 ^ 30);
    }

}
