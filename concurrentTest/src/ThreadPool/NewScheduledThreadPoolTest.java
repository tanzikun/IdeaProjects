package ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewScheduledThreadPoolTest {

    /**
     * 我们获取四次次线程，观察4个线程地址
     * @param args
     */
    public static  void main(String[]args)
    {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(2);
        System.out.println("****************************newFixedThreadPool*******************************");
        for(int i=0;i<30;i++)
        {
            final int index=i;
            //延迟三秒执行
            newScheduledThreadPool.schedule(new ThreadForpools(index),3, TimeUnit.SECONDS);
        }
    }

}
