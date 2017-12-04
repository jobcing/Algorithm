package datastructure;

/**
 * Created by ByeongChan on 2017. 12. 4..
 *
 * 선형 큐 구현 (Java)
 */
public class ArrayQueue {
    private int size;
    private int[] queue;
    private int front, rear;

    public ArrayQueue(int size){
        this.size = size;
        queue = new int[size];

        front = -1;
        rear = -1;
    }

    public void enQueue(int value){
        if(isFull()){ // 큐 포화상태 검사
            System.out.println("Queue is FULL !!");
        } else{
            queue[++rear] = value;
            System.out.println("enqueue : " + queue[rear]);
        }
    }

    public int deQueue(){
        if(isEmpty()){ // 큐 공백 검사
            System.out.println("Queue is EMPTY !!");
            return -1;
        } else{
            System.out.println("dequeue : " + queue[++front]);
            return queue[front];
        }
    }

    public boolean isFull(){
        return rear == size - 1 ? true : false;
    }

    public boolean isEmpty(){
        return front == rear ? true : false;
    }

    public void printQueue(){
        System.out.println("--- QUEUE LIST ---");
        for (int i = (front + 1); i <= rear ; i++) {
            System.out.println(queue[i]);
        }
    }
}
