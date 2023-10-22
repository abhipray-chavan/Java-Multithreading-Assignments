import java.util.LinkedList;
import java.util.Queue;

public class Assignment5 {
    private int currentFloor;
    private Queue<Integer> destinationQueue;

    public Assignment5() {
        currentFloor = 0;
        destinationQueue = new LinkedList<>();
    }

    public void addDestination(int floor) {
        destinationQueue.offer(floor);
    }

    public void operateLift() {
        while (!destinationQueue.isEmpty()) {
            int destination = destinationQueue.poll();
            System.out.println("Moving from floor " + currentFloor + " to floor " + destination);
            currentFloor = destination;
        }
    }

    public static void main(String[] args) {
        Assignment5 lift = new Assignment5();

        lift.addDestination(3);
        lift.addDestination(5);
        lift.addDestination(2);
        lift.addDestination(7);

        lift.operateLift();
    }
}