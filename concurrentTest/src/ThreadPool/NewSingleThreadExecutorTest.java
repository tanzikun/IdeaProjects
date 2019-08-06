package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewSingleThreadExecutorTest {

    /**
     * 我们获取四次次线程，观察4个线程地址
     * @param args
     */
    public static  void main(String[]args)
    {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        System.out.println("****************************NewSingleThreadExecutor*******************************");
        for(int i=0;i<10;i++)
        {
            final int index=i;
            newSingleThreadExecutor.execute(new ThreadForpools(index));
        }
    }

}
