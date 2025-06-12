package InClass9;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {
        // ThreadPool

        // How it works?
//		fixed amount threads are created and kept alive.
//		tasks are submitted to the thread pool
//		threads are pick up from the thread pool and execute that task
//		once task has been completed then threads returns to the thread pool

//		Why we need to use that?
//		it improves the performance.

//		Types of ThreadPool
//		FixedThreadPoolExecutor - Fixed number of threads

//		When to use this?
//
//		Example:

//		ExecutorService executor = Executors.newFixedThreadPool(5);
//		for (int i = 0; i < 10; i++) {
//			executor.execute(() -> {
//				try {
//					System.out.println("Uploading started by - " + Thread.currentThread().getName());
//					Thread.sleep(3000);
//					System.out.println("File uploaded by - " + Thread.currentThread().getName());
//				} catch (Exception e) {
//					System.out.println("Error");
//				}
//			});
//		}
//
////		No new task can be created after shutdown
//		executor.shutdown();

//		CachedThreadPool - It creates new thread as need.
//		If any threads is in the ideal state for 60 seconds then it will automatically terminate

//		When to use this?
//		It will be used to execute small tasks
//
//		Example:
//		ExecutorService executor = Executors.newCachedThreadPool();
//		for(int i=0;i<10;i++) {
//			executor.submit(() -> {
//				try {
//					System.out.println("Sending an email by - "+Thread.currentThread().getName());
//					Thread.sleep(1000);
//					System.out.println("Sent an email by - "+Thread.currentThread().getName());
//				} catch(Exception e) {
//					System.out.println("Error");
//				}
//			});
//		}
//		Thread.sleep(5000);
//		for(int i=0;i<5;i++) {
//			executor.submit(() -> {
//				try {
//					System.out.println("Sending an email by - "+Thread.currentThread().getName());
//					Thread.sleep(1000);
//					System.out.println("Sent an email by - "+Thread.currentThread().getName());
//				} catch(Exception e) {
//					System.out.println("Error");
//				}
//			});
//		}
//
//		executor.shutdown();

//		SingleThreadPoolExecutor - Only one thread will be there in pool

//		When to use this?
//		If we want to perform tasks in the sequentcially.
//		If ordering is matter
//		Thread safety

//		Real-time ex: Logs printing

//		ExecutorService executor = Executors.newSingleThreadExecutor();
//
//		for (int i = 0; i < 10; i++) {
//			int x = i;
//			executor.submit(() -> {
//				try {
//					Thread.sleep(1000);
//				} catch (Exception e) {
//					System.out.println("Error");
//				}
//				System.out.println("Log " + x + " - " + Thread.currentThread().getName());
//			});
//		}
//		executor.shutdown();
//
//		Benefits
//		Thread safety
//		FIFO execution


//		ScheduledThreadPool - for scheduling tasks
//		- scheduledAtFixedRate
//		- schedulerAtFixedDelay


        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
//		Real-time exmaple - healthcheck

//		scheduler.scheduleAtFixedRate(null, 0, 0, null)


//		scheduler.scheduleWithFixedDelay(null, 0, 0, null)

        Runnable service = new HealthCheckService();
        Runnable service2 = new HealthCheckService();


        System.out.println("Before executing the scheduled task - "+ LocalDateTime.now());
//		scheduler.scheduleAtFixedRate(service, 2, 5, TimeUnit.SECONDS);
//		scheduler.scheduleAtFixedRate(service, 0, 2, TimeUnit.SECONDS);
        scheduler.scheduleWithFixedDelay(service, 0, 2, TimeUnit.SECONDS);

//		0 - 10 seconds
//		5
//		10
//		15
//		...

//		No overlap
//		scheduler.scheduleAtFixedRate
//		Task1 - at - 30 sec
//		Task1 - at - 30 sec

//		scheduleWithFixedDelay
//		Task1 - at - 30 sec
//		Task1 - at - 32 sec


    }
}


class HealthCheckService implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("Health of service at - "+java.time.LocalDateTime.now());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
