package InClass11;

public class DeadLockDemo {

//	Deadlock
//	Inter-thread communication
	public static void main(String[] args) throws InterruptedException {
//		Deadlock:
//		Deadlock occurs when two or more thread are blocked forever. each waiting for the other to release the lock

//		Object obj1 = new Object();
//		Object obj2 = new Object();
//
//		Thread t1 = new Thread(() -> {
//			System.out.println("Thread1 Trying to lock obj1...");
//			synchronized (obj1) {
//				System.out.println("Thread1 Locked obj1");
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//					System.out.println("Exception" + e);
//				}
//				System.out.println("Thread1 Trying to lock obj2...");
//				synchronized (obj2) {
//					System.out.println("Thread1 Locked obj2");
//				}
//			}
//		}, "Thread1");
//
//		Thread t2 = new Thread(() -> {
//			System.out.println("Thread2 Trying to lock obj1...");
//			synchronized (obj1) {
//				System.out.println("Thread2 Locked obj1");
//				try {
//					Thread.sleep(100);
//				} catch (Exception e) {
//					System.out.println("Exception" + e);
//				}
//				System.out.println("Thread2 Trying to lock obj2...");
//				synchronized (obj2) {
//					System.out.println("Thread2 Locked obj2");
//				}
//			}
//		}, "Thread2");
//
//		t1.start();
//		t2.start();

//		Object obj1 = new Object();
//		Thread t1 = new Thread(() -> {
//			synchronized (obj1) {
//				System.out.println("Thread1: Accuired lock of obj1");
//			}
//		}, "Thread1");
//		
//		t1.start();
//		
//		synchronized (obj1) {
//			System.out.println("Main thread accuired lock for obj1");
//			t1.join();
//		}
//		System.out.println("Mian thread ended.");

//		How to avoid this deadlock?
//		Always accuired obj in same order
//		Avoid unneccesary locks

//		Inter-thread communication
//		It Allows us to pause the execution and let other thread to take over.
//		wait() - it release the lock and go into waiting state until another thread calls notify() or notifyAll()
//		notify() - Wakes up one waiting thread (randomly)
//		notifyAll() - Wakes up all waiting thread

//		It belongs to the Object class

//		Kitchen kitchen = new Kitchen();
//		
//		Thread chef = new Thread(() -> {
//			try {
//				kitchen.prepareMeal();
//			}catch(Exception e) {
//				System.out.println("Exception");
//			}
//		}, "chef");
//		
//		Thread waiter = new Thread(() -> {
//			try {
//				kitchen.serveMeal();
//			}catch(Exception e) {
//				System.out.println("Exception");
//			}
//		}, "waiter");
//		
//		waiter.start();
//		chef.start();

//		SharedREsources rEsources = new SharedREsources();
//
//		for (int i = 0; i < 3; i++) {
//			String tName = "Thread-" + i;
//			Thread t = new Thread(() -> {
//				rEsources.isWait(tName);
//			}, tName);
//			t.start();
//		}
//
//		Thread t1 = new Thread(() -> {
//			try {
//				Thread.sleep(3000);
//				rEsources.sendSignal();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		});
//		t1.start();
		
//		join() vs wait/notify
//		join - It waits to completed the execution of the Thread
//		wait()/notify() - It waits until the condition satisfied
	}
}

class Kitchen {
	private boolean isFoodReady = false;

	public synchronized void prepareMeal() throws InterruptedException {
		System.out.println("Preparing the meal.. - " + Thread.currentThread().getName());
		Thread.sleep(2000);
		isFoodReady = true;
		System.out.println("Meal is ready - " + Thread.currentThread().getName());
		notify();
	}

	public synchronized void serveMeal() throws InterruptedException {
		while (!isFoodReady) {
			System.out.println("Waiting for meal to be ready... - " + Thread.currentThread().getName());
			wait();
		}
		System.out.println("Serving the meal - " + Thread.currentThread().getName());
	}

}

class SharedREsources {
	public synchronized void isWait(String threadName) {
		try {
			System.out.println(threadName + " is waiting...");
			wait();
			System.out.println(threadName + " is resumed");
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}

	public synchronized void sendSignal() {
		System.out.println("Notifying all threads");
		notifyAll();
	}
}