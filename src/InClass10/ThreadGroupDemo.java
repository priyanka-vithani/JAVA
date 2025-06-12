package InClass10;

public class ThreadGroupDemo {

    public static void main(String[] args) throws InterruptedException {

//		ThreadGroup:
//		It allows us to manage multiple threads as single unit

//		Example:
//		ThreadGroup childGrp = new ThreadGroup(Thread.currentThread().getThreadGroup() ,"thread-group");
//
//
//		Thread t1 = new Thread(childGrp, () -> {
//			System.out.println(Thread.currentThread().getName() + "is running");
//		}, "thread-1");
//
//		Thread t2 = new Thread(childGrp, () -> {
//			System.out.println(Thread.currentThread().getName() + "is running");
//		}, "thread-2");
//
//
//		childGrp.setMaxPriority(Thread.MAX_PRIORITY);
//		childGrp.setDaemon(true);
//		t1.start();
//		t2.start();
//
//		t1.join();
//		t2.join();
//		childGrp.stop();
//
//		ThreadGroup parentGroup = childGrp.getParent();
//		System.out.println(parentGroup);
//		childGrp.list();
//
//		System.out.println(childGrp.activeCount());
//		System.out.println(Thread.currentThread().getThreadGroup().activeCount());
//
//		System.out.println("Active threads - "+ group.activeCount());

//		System.out.println(Thread.currentThread().getThreadGroup());
//
//		Thread t1 = new Thread(() -> {
//			System.out.println("Group - "+Thread.currentThread().getThreadGroup());
//		}, "t1");

//		t1.start();
//		t1.join();

//		Advantages:
//		Collectively Manage
//		Hierarchy Support
//		Categorization

//		Synchronization: it is a process of controlling the access of multiple threads to shared resource
//		methods
//		block
//		static

//		Example:
//		Counter counter = new Counter();
//
//		Thread t1 = new Thread(() -> {
//			for (int i = 0; i < 1000; i++) {
//				counter.increament();
//			}
//		});
//
//		Thread t2 = new Thread(() -> {
//			for (int i = 0; i < 1000; i++) {
//				counter.increament();
//			}
//		});
//
//		t1.start();
//		t2.start();
//
//		t1.join();
//		t2.join();
//
//		System.out.println("Counter - " + counter.counter);

//		Bank b = new Bank();
//		Thread person1 = new Thread(() -> {
//			for (int i = 0; i < 2; i++) {
//				try {
//					Thread.sleep(50);
//					b.withdraw(500);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}, "person1");
//
//		Thread person2 = new Thread(() -> {
//			for (int i = 0; i < 2; i++) {
//				try {
//					Thread.sleep(50);
//					b.withdraw(50);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}, "person2");
//
//		person1.start();
//		person2.start();
//
//		person1.join();
//		person2.join();
//
//		System.out.println(b.getBalance());

//		P1 - called withdraw() - 1000 - 500
//		P1 - called withdraw() - 1000 - 500 - 500

//		Advantages:
//		Thread safety
//		Data Integrity

//		RunTime Class
//		Singleton class
//		It allows to executer external command
//		Get memory details
//		Request to call to GC
//		Exit the JVM

        Runtime runtime = Runtime.getRuntime();
//		System.out.println("Total memory- " + runtime.totalMemory() / (1024 * 1024));
//		System.out.println("Total memory- " + runtime.freeMemory() / (1024 * 1024));

//		call GC
        runtime.gc();


//		Java Shutdown Hook
        runtime.addShutdownHook(new Thread() {
            public void run() {
                System.out.println("Shutdown hook1 is running");
            }
        });

        runtime.addShutdownHook(new Thread() {
            public void run() {
                System.out.println("Shutdown hook2 is running");
            }
        });

        System.out.println("All process completed");
    }

}

class Bank {
    //	shared resource
    private int balance = 1000;

    //	Not Thread safe
    void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " - Withdraw successfull - " + amount);
        } else {
            System.out.println(Thread.currentThread().getName() + "Insufficient Balance");
        }
    }

    int getBalance() {
        return balance;
    }
}

