import datastructure.SimpleLinkedList;

public class exercise {
    public static void main(String[] args) {
        SimpleLinkedList linkedList = new SimpleLinkedList();

        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(1);

        for (int i = 0; i < linkedList.getSize(); i++) {
            System.out.println(linkedList.getData(i));
        }

        linkedList.reverse();

        for (int i = 0; i < linkedList.getSize(); i++) {
            System.out.println(linkedList.getData(i));
        }
    }
}