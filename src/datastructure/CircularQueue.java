package datastructure;

/**
 * Created by ByeongChan on 2018. 2. 26..
 *
 * 원형 큐 구현
 */

public class CircularQueue {
    private int front, rear;
    private int queueSize;
    private int[] queue;

    public CircularQueue(int queueSize){
        this.front = 0;
        this.rear = 0;
        this.queueSize = queueSize;

        queue = new int[queueSize];
    }

    public boolean isEmpty(){
        return (front == rear);
    }

    public boolean isFull(){
        return ((rear + 1) % this.queueSize == front);
    }

    public void enQueue(int data){
        if(isFull()){
            System.out.println("Queue is Full");
        } else{
            rear = (rear + 1) % this.queueSize;
            queue[rear] = data;
        }
    }

    public int deQueue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");

            return -1;
        } else{
            front = (front + 1) & queueSize;

            return queue[front];
        }
    }
}
