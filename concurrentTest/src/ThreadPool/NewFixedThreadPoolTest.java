package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewFixedThreadPoolTest {

    /**
     * 我们获取四次次线程，观察4个线程地址
     * @param args
     */
    public static  void main(String[]args)
    {
        //线程池允许同时存在两个线程
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        System.out.println("****************************newFixedThreadPool*******************************");
        for(int i=0;i<30;i++)
        {
            final int index=i;
            newFixedThreadPool.execute(new ThreadForpools(index));
        }
    }

}
