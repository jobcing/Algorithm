import datastructure.Heap;

/**
 * Created by ByeongChan on 2017. 12. 2..
 */
public class algorithmTest {
    public static void main(String[] args) {
        Heap heap = new Heap(10);

        heap.insert(5);
        heap.insert(7);
        heap.insert(8);
        heap.insert(9);
        heap.insert(4);
        heap.insert(2);
        heap.insert(3);
        heap.insert(1);

        heap.delete();
        heap.delete();
        heap.delete();

        heap.print();
    }
}
