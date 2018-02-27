package datastructure;

/**
 * Created by ByeongChan on 2017. 12. 3..
 *
 * 스택 구현 (Java)
 */
public class StackImple {
    int[] stack;
    int size;
    int top;

    public StackImple(int size){
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public void peek(){
        if(top == -1){
            System.out.println("STACK is EMPTY !!");
        } else {
            System.out.println("PEEK : " + stack[top]);
        }
    }

    public void push(int value){
        if((top + 1) == size){
            System.out.println("STACK is FULL");
        } else{
            stack[++top] = value;
            System.out.println(stack[top] + " PUSH !");
        }
    }

    public int pop(){
        if(top == -1){
            System.out.println("STACK is EMPTY !!");
            return -1;
        } else{
            System.out.println(stack[top] + " POP !");
            return stack[top--];
        }
    }

    public void printStack(){
        System.out.println("--- STACK LIST ---");

        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
