import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable
{
	private String name;
	public Task(String name)
	{
		this.name = name;
	}
	
	public void run()
	{
		try
        { 
            for (int i = 0; i<=5; i++) 
            { 
                if (i==0)
                { 
                    Date d = new Date(); 
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss"); 
                    System.out.println("Initialization Time for" + " task name - "+ name +" = " +ft.format(d));    
                    //prints the initialization time for every task  
                } 
                else
                { 
                    Date d = new Date(); 
                    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss"); 
                    System.out.println("Executing Time for task name - "+ name +" = " +ft.format(d));    
                    // prints the execution time for every task  
                } 
                Thread.sleep(1000); 
            } 
            System.out.println(name+" complete"); 
        } 
          
        catch(InterruptedException e) 
        { 
            e.printStackTrace(); 
        } 
	}
}


public class Problem
{
	public static void main(String[] args) throws InterruptedException
	{
		
		Runnable r1 = new Task("Task 1");
		Runnable r2 = new Task("Task 2");
		Runnable r3 = new Task("Task 3");
		Runnable r4 = new Task("Task 4");
		Runnable r5 = new Task("Task 5");
		
//		ExecutorService pool = Executors.newFixedThreadPool(3);
//		ExecutorService pool = Executors.newCachedThreadPool();
		ExecutorService pool = Executors.newSingleThreadExecutor();
		
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);
		
		
		pool.shutdown();
	}
}


//	1. Create a task(Runnable Object) to execute
//	2. Create Executor Pool using Executors
//	3. Pass tasks to Executor Pool
//	4. Shutdown the Executor Pool