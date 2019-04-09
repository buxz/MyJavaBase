package bxz.base.statics;

public class StaticDemo {
    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类非静态代码块");
    }

    void show(){
        System.out.println("父类方法");
    }

    public StaticDemo() {
        System.out.println("父类构造方法");
    }
}
