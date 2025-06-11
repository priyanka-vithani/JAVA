package InClass3;

public class ThreadSyncExamples {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("--- HashCode Demo ---");

        HashCodeDemo.run();

        System.out.println("\n--- Wait/Notify Demo ---");

        WaitNotifyDemo.run();

        Thread.sleep(3000); // wait to finish above threads

        System.out.println("\n--- Wait with Timeout Demo ---");

        TimeoutWaitDemo.run();

        Thread.sleep(3000);

        System.out.println("\n--- NotifyAll Demo ---");

        new NotifyAllDemo().runDemo();

    }

}
