import datastructure.ArrayQueue;

/**
 * Created by ByeongChan on 2017. 12. 2..
 */
public class algorithmTest {
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(5);

        q.enQueue(5);
        q.enQueue(4);

        q.printQueue();

        q.deQueue();
        q.deQueue();
        q.deQueue();

        q.printQueue();
    }
}
