package datastructure;

import java.util.*;

/**
 * Created by ByeongChan on 2018. 2. 27..
 *
 * 스택을 이용해서 큐 구현하기
 */

public class QueueMakeUsingStack {

    private Stack inBox = new Stack();
    private Stack outBox = new Stack();

    public void enQueue(int data){
        inBox.add(data);
    }

    public int deQueue(){
        if(outBox.isEmpty()){
            while(!inBox.isEmpty()){
                outBox.push(inBox.pop());
            }
        }

        return (int)outBox.pop();
    }
}
