package bxz.spring.aop;

/**
 * 横切关注点，这里是打印时间
 */
public class TimeHandler
{
	public void printTime()
    {
        System.out.println("CurrentTime = " + System.currentTimeMillis());
    }
}