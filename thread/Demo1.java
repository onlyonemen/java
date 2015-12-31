package thread;

/**
 * 三线程打印ABC
 * 
 * @author h154651
 *
 */
public class Demo1 {
	Thread1 t1;
	Thread2 t2;
	Thread3 t3;

	int tag = 1;
	int count = 10;

	public void start() {
		t1 = new Thread1("A");
		t2 = new Thread2("B");
		t3 = new Thread3("C");

		t1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t3.start();

	}

	synchronized void printName(String name) {
		System.out.println(name);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class Thread1 extends Thread {
		public Thread1(String name) {
			this.name = name;
		}

		String name;

		@Override
		public void run() {
			while (true) {
				synchronized (this) {
					while (tag != 1) {
						try {
							wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(name);
					tag = 2;

				}
			}

		}
	}

	class Thread2 extends Thread {
		public Thread2(String name) {
			this.name = name;
		}

		String name;

		@Override
		public void run() {
			while (true) {
				synchronized (this) {
					while (tag != 2) {
						try {
							wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(name);
					tag = 3;
				}
			}
		}
	}

	class Thread3 extends Thread {
		public Thread3(String name) {
			this.name = name;
		}

		String name;

		@Override
		public void run() {

			while (true) {
				if (tag == 3) {
					System.out.println(name + "-" + count);
					tag = 1;
					count--;
				}
				
				synchronized (t1) {

					t1.notifyAll();
				}
				synchronized (t2) {

					t2.notify();
				}
				

			}
		}
	}
}
