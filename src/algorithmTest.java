import datastructure.DoublyLinkedList;

/**
 * Created by ByeongChan on 2017. 12. 2..
 */
public class algorithmTest {
    public static void main(String[] args) {
        DoublyLinkedList dlist = new DoublyLinkedList();

        dlist.addFirst(5);
        dlist.addFirst(4);
        dlist.addFirst(2);
        dlist.addFirst(1);

        System.out.println(dlist.getData(2));
        System.out.println(dlist.getData(4));
    }
}
