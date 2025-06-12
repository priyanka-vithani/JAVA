package InClass8;

public class ThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        // Thread - lightweight process
//		System.out.println(Thread.currentThread().getName());
//		myMethod();
//		System.out.println("Completed metod execution");
        // How to create the Thread
        // 1. Thread class 2. Runnable interface
//		MyThread myThread = new MyThread();
//		myThread.start();
//
//		Thread runnable = new Thread(new MyRunnable());
//		runnable.start();

//		==================Thread Constructors==========
//		Thread t1 = new Thread();
//		System.out.println(t1.getName());
//		Thread t2 = new Thread(new MyRunnable());
//		System.out.println(t2.getName());
//		Thread t3 = new Thread("thread-3");
//		System.out.println(t3.getName());
//		Thread t4 = new Thread(new MyRunnable(), "thread-4");
//		System.out.println(t4.getName());

//		====================Thread methods=================
//		start(); - It will start the thread and runs the run() method
//		run() - It will execute the run() method

//		t2.start();
//		t2.run();

//		sleep() - Pause method
//		Thread t1 = new Thread();
//		t1.start();
//		System.out.println("Processing started");
//		t1.sleep(5000);
//		System.out.println("Processing completed");

//		join() - it will wait untill the thread complets the process
//		setName() - It will set the thread name
//		getName()

//		setPriority() - It will set the priority of the thread
//		setDaemon() -
//		t1.setName("t1-demo");
//		t1.start();
//		System.out.println(t1.getName());
//
//		join()

//		MyThread t = new MyThread();
//		t.start();
//		System.out.println("Waiting for thread to complete the processing - " + Thread.currentThread().getName());
////		t.join();
//		System.out.println("Thread processing completed - " + Thread.currentThread().getName());


//		setPriority()

//		MyThread t = new MyThread();
//		t.setName("high-p");
//		t.setPriority(Thread.MAX_PRIORITY);
//
//		MyThread t2 = new MyThread();
//		t2.setName("low-p");
//		t2.setPriority(Thread.NORM_PRIORITY);
//
//		t.start();
//		t2.start();

//		Multi-Threading
//		Task1 task1 = new Task1();
//		Task2 task2 = new Task2();
//		task1.start();
//		task2.start();


        // Synchronous
//		task1.run();
//		Task1 - main
//		Task1 - main
//		Task1 - main
//		Task1 - main
//		Task1 - main
//		Task2 - main
//		Task2 - main
//		Task2 - main
//		Task2 - main
//		Task2 - main
//		task2.run();

        // Asynchronous
//		task1.start();
//		task2.start();


//		Thread life-cycle
//		NEW
//		RUNNABLE
//		BLOCKED
//		TIMEED_WAITING
//		TERMINATED

//		Task1 t1 = new Task1();
//		System.out.println(t1.getState()); // NEW
//
//		Task1 t2 = new Task1();
//		t1.start();
//
//		System.out.println(t1.getState()); // RUNNABLE
//		t1.sleep(1000);

//		t1.start();
//		System.out.println(t1.getState());
//		t1.join();
//		System.out.println(t1.getState());


//		Thread scheduler
//		FCFS - First come first serve
//		Preemptive priority - Highest priority thread runs first

//		Daemon Thread - Threads which are running in the background is called daemon thread. Example: garbage collection

//		Runnable daemonTask = () -> {
//			while(true) {
//				try {
//					Thread.sleep(1000);
//					System.out.println("Daemon thread is running");
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		};
//
//		Thread t = new Thread(daemonTask);
//		t.setDaemon(true);
//
//		t.start();
//		t.join();
//		Thread.sleep(5000);
//		System.out.println("Main thread finished - "+Thread.currentThread().getName());


//		BLOCKED
        Resource resource = new Resource();
        Thread t1 = new Thread(() -> resource.method());
        Thread t2 = new Thread(() -> resource.method());

        t1.start();
        t2.start();
        System.out.println(t1.getState());
        System.out.println(t2.getState());
    }

//	private static void myMethod() throws InterruptedException {
//		Thread.sleep(1000L);
//		System.out.println("Inside the method - "+Thread.currentThread().getName());
//	}
}

class MyThread extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread Processing - " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Running Thread with Runnable - " + Thread.currentThread().getName());
    }
}

class Task1 extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Task1 - " + Thread.currentThread().getName());
//			method();
        }
    }
}

class Task2 extends Thread {

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Task2 - " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Resource {
    public synchronized void method() {
        try {
            Thread.sleep(5000);
            System.out.println("state - " + Thread.currentThread().getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
