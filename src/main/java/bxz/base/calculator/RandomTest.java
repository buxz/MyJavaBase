package bxz.base.calculator;

import java.util.Random;

public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random();
        // 在 0（包括）和指定值（不包括）之间均匀分布的 int 值。
        System.out.println(random.nextInt(10));
    }

}
