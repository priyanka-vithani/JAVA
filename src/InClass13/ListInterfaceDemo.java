package InClass13;

import java.util.Stack;
import java.util.Vector;

public class ListInterfaceDemo {

	
//	ArrayList
//	LinkedList
//	Vector
//	Stack
	public static void main(String[] args) throws InterruptedException {
//		List - Interface -> ArrayList, LinkedList, Vector, Stack

//		ArrayList
//		Ordered
//		Resizable array
//		Non-Thread safe
//		index base access

//		Adavantage:
//		Fast random access

//		DisAdv:
//		Slow insertion in the middle

//		Thread safe arrayList
//		CopyOnArrayList
		
//		CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
////		List<Integer> list = Collections.synchronizedList(new ArrayList<>());
//
//		Runnable task = () -> {
//			for (int i = 0; i < 1000; i++) {
//				list.add(i);
//			}
//		};
//
//		Thread t1 = new Thread(task);
//		Thread t2 = new Thread(task);
//
//		try {
//			t1.start();
//			t2.start();
//
//			t1.join();
//			t2.join();
//		} catch (Exception e) {
//			System.out.println("Exception");
//		}
//
//		System.out.println("List size :: " + list.size());
		
		
//		LinkedList
		
//		Doubly linked list - implmentation of List and Queue
//		It is best for frequent insertion/deletion
//		Non-thread safe
		
//		List<String> list = new LinkedList<>();
//		list.add("A");
//		list.add("B");
//		list.add("C");
//		list.add("A");
//		
//		System.out.println(list.lastIndexOf("A"));
		
//		LinkedList<Ticket> ticektList = new LinkedList<>();
//		
// 		ticektList.addLast(new Ticket(1, "login issue"));  // [1]
//		ticektList.addLast(new Ticket(2, "payment issue")); // [2, 1]
//
//		ticektList.addFirst(new Ticket(3, "system error")); // [3,2,1]
//		
//		while (!ticektList.isEmpty()) {
//			Ticket current = ticektList.removeFirst(); // FIFO or priority
//			current.process();
//		}
		
//		Advantages:
//		Faster Insertion/deletion
//		Implement queue or Deque
		
//		DisAd:
//		Slower Element access
		
		
//		Vector:
//		Synchronized list - Thread safe
//		Legacy class
		
		
//		Vector<Integer> vectorList = new Vector<>();
		
//		ChatRoom chatRoom = new ChatRoom();
//		
//		Thread user1 = new Thread(() -> {
//			chatRoom.sendMessage("User1 - Hello");
//			chatRoom.sendMessage("User1 - How are you?");
//		});
//		
//		Thread user2 = new Thread(() -> {
//			chatRoom.sendMessage("User2 - Hello");
//			chatRoom.sendMessage("User2 - How are you?");
//		});
//		
//		user1.start();
//		user2.start();
//		
//		user1.join();
//		user2.join();
//		
//		chatRoom.showMesssages();
		
//		Thread-safe
//		Dynamic resizing
		
//		DisAd:
//		Slower than ArrayList
//		Esily replace with Collections.synchronized();
	
		
//		Stack
//		LIFO: Last In FIRST OUT
//		Legacy Class
//		Synchronized
		
//		Stack<String> stack = new Stack<>();
////		stack.push("");  // Add item to the top of the stack
////		stack.pop(); // It returns the top element & removes it
////		stack.peek(); // It return the top element without removing it
////		stack.search(""); // It return the position from top, -1 if not found
//		
//		stack.push("A");
//		stack.push("B");
//		stack.push("C");
//		
////		B - top
////		A - last
//		System.out.println(stack.peek());
//		System.out.println(stack.size());
//		System.out.println(stack.search("D"));
		
		String[] htmlTags = {"html", "body", "div", "/div", "/body", "/html"};
		String[] htmlTags2 = {"html", "body", "div", "/body", "/div", "/html"};
		
		System.out.println("Valid HTML - "+HTMLTagValidator.isValidHtmlTag(htmlTags));
		System.out.println("Valid HTML - "+HTMLTagValidator.isValidHtmlTag(htmlTags2));
		
//		Advantage:
//		LIFO order
//		Thread-safe - Internally extends the Vector
	}
}

class HTMLTagValidator{

	public static boolean isValidHtmlTag(String[] tags) {
		Stack<String> stack = new Stack<>();
		
		for(String tag : tags) {
			if(!tag.startsWith("/")) {
				stack.push(tag);
			} else {
//				div
//				body
//				html
				if(stack.isEmpty()) {
					return false;
				}
				
				String openTag = stack.pop(); // div
				
				if(!openTag.equals(tag.substring(1))) {
					return false;
				}
			}
		}
		
		return stack.isEmpty();
	}
}

class ChatRoom {
	private Vector<String> messages = new Vector<>();
	
	public void sendMessage (String message) {
		messages.add(message); // Thread safe add
		
		System.out.println("Message Sent: "+message);
	}
	
	public void showMesssages() {
		System.out.println("Chat log:");
		for(String msg : messages) {
			System.out.println(msg);
		}
	}
}

class Ticket {
	private int id;
	private String desc;

	public Ticket(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public void process() {
		System.out.println("Processing ticket Id  - " + id + ", desc - " + desc);
	}
}
