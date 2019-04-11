package bxz.base.calculator;

public class MathTest {
    public static void main(String[] args) {
        double a = 3.24234;
        double b = 4.444;
        System.out.println(Math.abs(a)); // 绝对值
        System.out.println(Math.ceil(a)); // 返回最小的（最接近负无穷大）double 值，该值大于等于参数，并等于某个整数。
        System.out.println(Math.floor(a)); // 返回最大的（最接近正无穷大）double 值，该值小于等于参数，并等于某个整数。
        System.out.println(Math.max(a,b));
        System.out.println(Math.min(a,b));
        System.out.println(Math.round(a));// 返回最接近参数的 long。
        System.out.println(Math.random());// 返回带正号的 double 值，该值大于等于 0.0 且小于 1.0。
    }
}
