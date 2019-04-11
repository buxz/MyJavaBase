package bxz.base.thread.thread_safe;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * SimpleDateFormat 线程不安全问题
 * DateTimeFormatter 线程安全
 */
public class ThreadSafe_SimpleDateFormat {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static String formatDate(LocalDateTime date) throws ParseException {
        return FORMAT.format(date);
    }

    public static LocalDateTime parse(String stringDate) throws ParseException {
        return LocalDateTime.parse(stringDate,FORMAT);
    }

    //    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    public static String formatDate(Date date) throws ParseException {
//        return FORMAT.format(date);
//    }
//
//    public static Date parse(String stringDate) throws ParseException {
//        return FORMAT.parse(stringDate);
//    }

    public static void main(String[] args) throws ParseException, InterruptedException {
//


    }

    // 单线程测试
    private void testSingleThread() throws ParseException {
//        System.out.println(formatDate(new Date()));
    }

    /**
     * 多线程的时候 会崩溃，部分线程获取的线程时间不对
     * 因为
     *
     * @throws InterruptedException
     */
    private void testMultiThread() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 20; i++) {
            service.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    try {
                        System.out.println(parse("2019-04-11 15:40:47"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);
    }


}
