package bxz.base.calculator;

import java.util.Objects;

public class TestEquals {
    public static void main(String[] args) {
        String s2 = "a" +"b";
        String s3 = "a";
        String s4 = "b";
        String s5 = s3 + s4;
        System.out.println(s5 == s2); // false, 比较的内存地址，
        System.out.println(s5.equals(s2));// treu，不仅比较地址，还比较内容
    }
}
