import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
public class multiThreadvsSingleThread {
    public static void main(String[] args) {
        singleThreadSolution();
        doubleThreadSolution();
        betterMultiThread();
    }

    public static void singleThreadSolution(){
        long startTime = System.currentTimeMillis();
        int count = 0;
        for(int i = 0; i < 1000000000; i++){
            count++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time For Single Threaded Solution :: " + (endTime-startTime) + " milliseconds.");
    }

    public static void doubleThreadSolution(){
        long startTime = System.currentTimeMillis();       
        int numThreads = 1000;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<Long>> futures = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            final int threadId = i;
            futures.add(executor.submit(new Callable<Long>() {
                @Override
                public Long call() {
                    long count = 0;
                    for (long i = threadId * 1000000; i < (threadId + 1) * 1000000; i++) {
                        count++;
                    }
                    return count;
                }
            }));
        }

        long totalCount = 0;
        for (Future<Long> future : futures) {
        }

        executor.shutdown();

        long endTime = System.currentTimeMillis();
        System.out.println("Time For Multi Threaded Solution :: " + (endTime-startTime) + " milliseconds.");
    }

    public static void betterMultiThread(){
        long startTime = System.currentTimeMillis();       
        int numThreads = 2; 
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<Long>> futures = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            final int threadId = i;
            futures.add(executor.submit(new Callable<Long>() {
                @Override
                public Long call() {
                    long count = 0;
                    for (long i = threadId * 1000000; i < (threadId + 1) * 1000000; i++) {
                        count++;
                    }
                    return count;
                }
            }));
        }

        long totalCount = 0;
        for (Future<Long> future : futures) {
        }

        executor.shutdown();

        long endTime = System.currentTimeMillis();
        System.out.println("Time For Multi Threaded Solution :: " + (endTime-startTime) + " milliseconds.");
    }
    
    // to make it faster you just lower the number of threads, so then you don't have unnecessary threads that take up more time
}