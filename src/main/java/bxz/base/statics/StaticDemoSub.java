package bxz.base.statics;

public class StaticDemoSub extends StaticDemo {
    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类非静态代码块");
    }

    public StaticDemoSub() {
        System.out.println("子类构造方法");
    }

    public static void main(String[] args) {
        System.out.println("main函数");
        new StaticDemoSub();
    }

}
