package thread;
/**
 * 多线程访问同一资源进行等待
 * @author h154651
 *
 */
public class Demo2 {
	String lock = new String();
	int count = 1000;

	synchronized void save(int i) {
		count = count + i;
		try {
			Thread.sleep(10);// 模拟其它处理所需要的时间，比如刷新数据库等
		} catch (InterruptedException e) {
			// ignore
		}
	}

	synchronized void draw(int i) {
		count = count - i;
		try {
			Thread.sleep(10);// 模拟其它处理所需要的时间，比如刷新数据库等
		} catch (InterruptedException e) {
			// ignore
		}
	}

	public void start() {
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {

					System.out.println(this.toString());

					save(1);

					draw(1);

					System.out.println(count);

				}

			}).start();

		}

	}
}
