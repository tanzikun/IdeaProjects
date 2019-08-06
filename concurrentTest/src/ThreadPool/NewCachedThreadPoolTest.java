package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewCachedThreadPoolTest {


    /**
     * 我们获取四次次线程，观察4个线程地址
     * @param args
     */
    public static  void main(String[]args)
    {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        System.out.println("****************************newCachedThreadPool*******************************");
        for(int i=0;i<30;i++)
        {
            final int index=i;
            newCachedThreadPool.execute(new ThreadForpools(index));
        }
    }
}
