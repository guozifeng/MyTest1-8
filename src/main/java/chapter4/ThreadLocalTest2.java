package chapter4;

public class ThreadLocalTest2 {
	// ��ͨ�������ڲ��า��ThreadLocal��initialValue()������ָ����ʼֵ
	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
		public Integer initialValue() {
			return 0;
		}
	};

	// �ڻ�ȡ��һ������ֵ
	public int getNextNum() {
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}

	public static void main(String[] args) {
		ThreadLocalTest2 sn = new ThreadLocalTest2();
		// �� 3���̹߳���sn�����Բ������к�
		TestClient t1 = new TestClient(sn);
		TestClient t2 = new TestClient(sn);
		TestClient t3 = new TestClient(sn);
		t1.start();
		t2.start();
		t3.start();
	}

	private static class TestClient extends Thread {
		private ThreadLocalTest2 sn;

		public TestClient(ThreadLocalTest2 sn) {
			this.sn = sn;
		}

		public void run() {
			for (int i = 0; i < 3; i++) {
				// ��ÿ���̴߳��3������ֵ
				System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn[" + sn.getNextNum() + "]");
			}
		}
	}
}