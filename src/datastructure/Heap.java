package datastructure;

/**
 * Created by ByeongChan on 2017. 12. 11..
 *
 * 힙 구현 (Java)
 */
public class Heap {
    private int size;
    private int usedSize;
    private int[] heapArray;

    public Heap(int size){
        this.size = size;
        heapArray = new int[size];
        usedSize = 0;
    }

    public void insert(int data){
        int curIndex = usedSize;
        int parentIndex = getParentIndex(curIndex);

        // 용량 초과
        if(usedSize == size){
            System.out.println("Heap is FULL !");
            return;
        }

        // 힙의 가장 최고 깊이 왼쪽부터 채웠을 경우, 맨 오른쪽에 삽입
        heapArray[curIndex] = data;

        // 루트노드 & 부모노드가 더 작을때까지 반복
        while(curIndex > 0 && heapArray[curIndex] < heapArray[parentIndex]){
            swap(heapArray, curIndex, parentIndex);
            curIndex = parentIndex;
            parentIndex = getParentIndex(curIndex);
        }

        usedSize++;
    }

    public void delete(){
        // 힙에 데이터가 없을 경우
        if(usedSize == 0){
            System.out.println("Heap is EMPTY !");
            return;
        }

        int curIndex = 0;
        int leftChildIndex = getLeftChildIndex(curIndex);
        int rightChildIndex = getRightChildIndex(curIndex);

        heapArray[curIndex] = 0; // 루트노드 삭제
        swap(heapArray, curIndex, usedSize); // 가장 마지막에 있는 노드를 루트노드로 이동

        // 리프노드가 되거나, 양쪽 자식보다 작은 값을 가질 때까지 작업을 반복
        while(true){

        }

        usedSize--;
    }

    private int getParentIndex(int curIndex){
        return curIndex / 2;
    }

    private int getLeftChildIndex(int curIndex){

    }

    private int getRightChildIndex(int curIndex){

    }

    private void swap(int[] heapArray, int curIndex, int parentIndex){
        int temp;

        temp = heapArray[curIndex];
        heapArray[curIndex] = heapArray[parentIndex];
        heapArray[parentIndex] = temp;
    }
}
