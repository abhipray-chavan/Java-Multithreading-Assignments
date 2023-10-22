
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
class Assignment1{
    public static void main(String[] args) {
        ExecutorService executorService  = Executors.newFixedThreadPool(5);
        for(int i=1;i<=10;i++){
            executorService.submit(new Task(i));
        }
        executorService.shutdown();

        try{
            executorService.awaitTermination(Long.MAX_VALUE,TimeUnit.NANOSECONDS);
        }
        catch(InterruptedException e){
            System.out.println("Error waiting for task completion"+e.getMessage());
        }
        System.out.println("All tasks have been completed");
    }
}

 class Task implements Runnable{

    private final int taskId;

    public Task(int taskId){
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task "+taskId+" is running on thread"+Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
           System.out.println("Error in task"+taskId+": "+e.getMessage());
        }
    }
}