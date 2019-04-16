package bxz.base.hashmap;

import java.util.HashMap;

public class HashMapTest {
    /**
     * Keys, 重写 hashCode()/ equals() 方法，
     * @param args
     */
    public static void main(String[] args) {
        Keys k1 = new Keys(1);
        Keys k2 = new Keys(1);
        System.out.println(k1.hashCode());
        System.out.println(k2.hashCode());
        HashMap<Keys,String> hashMap = new HashMap<>();
        hashMap.put(k1,"Key with id is 1");
        System.out.println(hashMap.get(k2));
        System.out.println(hashMap.get(k1));
    }
}
