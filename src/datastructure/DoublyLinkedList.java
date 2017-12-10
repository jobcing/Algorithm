package datastructure;

/**
 * Created by ByeongChan on 2017. 12. 9..
 *
 * 이중 연결 리스트 구현 (Java)
 */
public class DoublyLinkedList {

    private class Node{
        private Object data;
        private Node prevNode;
        private Node nextNode;

        public Node(Object data){
            this.data = data;
            prevNode = null;
            nextNode = null;
        }
    }

    private Node head;
    private int size;

    public DoublyLinkedList(){
        head = new Node(null);
        size = 0;
    }

    public Node getNode(int index){ // index 위치에 있는 노드를 반환
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
        }

        Node node = head;

        if(index <= (size / 2)){ // index 값이 리스트 size의 중간보다 앞에 있다면 앞에서부터 순차적으로 탐색한다.
            for (int i = 0; i <= index; i++) {
                node = node.nextNode;
            }
        } else{ // index 값이 리스트 size의 중간보다 뒤에 있다면 뒤에서부터 역으로 탐색한다
            for (int i = size; i > index; i--) {
                node = node.prevNode;
            }
        }

        return node;
    }

    public Object getData(int index){ return getNode(index).data; } // index 위치에 있는 데이터를 반환

    public Object getFirst(){ return getData(0); } // 첫번째 위치에 있는 노드의 데이터를 반환

    public int getNodeIndex(Object data){ // 해당 데이터 index 위치를 반환
        if(size <= 0){ return -1; }

        Node node = head.nextNode;

        /*
        int index = 0;

        while(node != null) {
            if (data.equals(node.data)) {
                return index;
            }

            node = node.nextNode;
            index++;
        }
        */

        for (int i = 0; i < size; i++) {
            if(data.equals(node.data)){
                return i;
            }

            node = node.nextNode;
        }

        return -1;
    }

    public void addFirst(Object data){ // 첫번째 위치에 노드를 삽입
        Node newNode = new Node(data);

        // 리스트 연결작업
        newNode.nextNode = head.nextNode;

        if(head.nextNode != null){ // 리스트가 비어있지 않다면
            head.nextNode.prevNode = newNode;
        } else{
            head.prevNode = newNode;
        }

        head.nextNode = newNode;
        //

        size++;
    }

    public void add(int index, Object data){ // index 위치에 데이터 삽입
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
        }

        if(index == 0){
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node prevNode = getNode(index - 1);
        Node nextNode = prevNode.nextNode;

        prevNode.nextNode = newNode;
        newNode.prevNode = prevNode;

        newNode.nextNode = nextNode;
        if(newNode.nextNode != null){ // 삽입 위치가 리스트의 마지막이 아니라면
            newNode.prevNode = newNode;
        } else{
            head.prevNode = newNode;
        }

        size++;
    }

    public Object removeFirst(){ // 첫번째 노드를 제거하고 데이터를 반환
        Node resultNode = getNode(0);

        head.nextNode = resultNode.nextNode;

        if(head.nextNode != null){ // 리스트가 비어있지 않은 경우
            resultNode.nextNode.prevNode = null; // 두번째 노드가 가르키는 앞 노드는 null
        } else{
            head.prevNode = null; // 헤드가 가르키는 마지막 노드는 null
        }

        size--;
        return resultNode.data;
    }

    public Object remove(int index){ // index 위치의 노드를 제거하고 데이터 반환
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
        }

        if(index == 0){
            return removeFirst();
        }

        Node resultNode = getNode(index);
        Node prevNode = resultNode.prevNode;

        if(resultNode.nextNode != null){ // 삭제하는 노드의 위치가 마지막이 아니라면
            Node nextNode = resultNode.nextNode;

            prevNode.nextNode = nextNode;
            nextNode.prevNode = prevNode;
        } else{
            prevNode.nextNode = null;
            head.prevNode = prevNode;
        }

        size--;
        return resultNode.data;
    }

    public int getSize(){ // 리스트의 사이즈를 반환
        return size;
    }
}
