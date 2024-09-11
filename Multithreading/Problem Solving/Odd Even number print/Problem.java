public class Problem {
	static int i;
	public static void main(String[] args) throws InterruptedException {
		i = 0;
		Object lock = new Object();

		Thread t1 = new Thread() {
			public void run() {
				for(; i<=10;)
				{
					if(i%2==0 && Thread.currentThread().getName().equals("Even")) {
						synchronized(lock)
						{
							System.out.println(Thread.currentThread().getName() + " : " + i);
							i += 1;
							try {
								lock.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		};
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for(; i<=10;)
				{
					if(i%2==1 && Thread.currentThread().getName().equals("Odd"))
					{
						synchronized(lock)
						{
							System.out.println(Thread.currentThread().getName() + " : " + i);
							i += 1;
							lock.notify();
						}
					}
				}
			}
		});
		
		t1.setName("Even");
		t2.setName("Odd");
		
		t1.start();
		t2.start();

	}
}