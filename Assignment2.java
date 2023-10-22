import java.util.LinkedList;
import java.util.Queue;

public class Assignment2 {
     static final int BUFFER_SIZE = 5;
     static final int NUM_ITEMS_TO_PRODUCE = 10;

    public static void main(String[] args) {
        Buffer buffer = new Buffer(BUFFER_SIZE);

        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All items have been produced and consumed.");
    }
}

class Buffer {
    private final Queue<Integer> queue;
    private final int maxSize;

    public Buffer(int maxSize) {
        this.queue = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public synchronized void produce(int item) throws InterruptedException {
        while (queue.size() == maxSize) {
            wait();
        }

        queue.offer(item);
        System.out.println("Produced: " + item);

        notifyAll();
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }


        int item = queue.poll();
        System.out.println("Consumed: " + item);

        notifyAll();

        return item;
    }
}

class Producer implements Runnable {
    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= Assignment2.NUM_ITEMS_TO_PRODUCE; i++) {
                buffer.produce(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= Assignment2.NUM_ITEMS_TO_PRODUCE; i++) {
                 buffer.consume();
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}