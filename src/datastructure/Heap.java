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

        usedSize--;

        int curIndex = 0;
        int leftChildIndex = getLeftChildIndex(curIndex);
        int rightChildIndex = getRightChildIndex(curIndex);

        heapArray[curIndex] = 0; // 루트노드 삭제
        swap(heapArray, curIndex, usedSize); // 가장 마지막에 있는 노드를 루트노드로 이동

        // 리프노드가 되거나, 양쪽 자식보다 작은 값을 가질 때까지 작업을 반복
        while(true){
            // 오른쪽, 왼쪽 자식 노드 중 선택될 노드 위치 저장
            int selectChildIndex = 0;

            // 왼쪽 자식 노드 위치가 사용 크기보다 같거나 크다면 리프노드이다.
            if(leftChildIndex >= usedSize){ break; }
            // 오른쪽 자식 노드 위치가 사용 크기보다 같거나 크다면 자식 노드는 왼쪽 노드 뿐이다.
            if(rightChildIndex >= usedSize){
                // 왼쪽 노드를 선택
                selectChildIndex = leftChildIndex;
            } else{ // 자식 노드가 양쪽에 존재하기 때문에 더 작은 쪽을 선택
                if(heapArray[leftChildIndex] > heapArray[rightChildIndex]){
                    selectChildIndex = rightChildIndex;
                } else{
                    selectChildIndex = leftChildIndex;
                }
            }

            // 선택된 자식 노드이 부모 노드보다 작다면 바꿔준다.
            if(heapArray[selectChildIndex] < heapArray[curIndex]){
                swap(heapArray, selectChildIndex, curIndex);
                curIndex = selectChildIndex;
            } else{
                break;
            }

            // 자식 노드 업데이트
            leftChildIndex = getLeftChildIndex(curIndex);
            rightChildIndex = getRightChildIndex(curIndex);
        }
    }

    private int getParentIndex(int curIndex){
        // k번째 인덱스 위치에서 부모노드 인덱스는 (k - 1) / 2
        return (int) ((curIndex - 1) / 2);
    }

    private int getLeftChildIndex(int curIndex){
        // k번째 인덱스 위치에서 왼쪽 자식 노드 인덱스는 2k + 1
        return 2 * curIndex + 1;
    }

    private int getRightChildIndex(int curIndex){
        // k번째 인덱스 위치에서 오른쪽 자식 노드 인덱스는 2k + 2
        return 2 * curIndex + 2;
    }

    private void swap(int[] array, int index1, int index2){
        int temp;

        temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public void print(){
        int depth = 0;
        int index = 0;

        for (int i = 0; i < usedSize; i++) {
            if(index == i){
                if(index != 0) {
                    System.out.println("");
                }

                System.out.println("Depth : " + depth);
                index = index + (int) Math.pow(2, depth);
                depth++;
            }
            System.out.println(heapArray[i] + " ");
        }
        System.out.println("");
    }
}
