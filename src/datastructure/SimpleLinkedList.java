package datastructure;

/**
 * Created by ByeongChan on 2017. 12. 7..
 *
 * 단순 연결리스트 구현 (Java)
 */
public class SimpleLinkedList {

    private class Node{
        private Object data; // 데이터가 저장될 필드
        private Node nextNode; // 다음 노드를 가르키는 필드

        public Node(Object data){
            this.data = data;
            this.nextNode = null;
        }

        public String toString(){
            return String.valueOf(this.data);
        }
    }

    private Node head;
    private int size;

    public SimpleLinkedList(){
        head = new Node(null);
        size = 0;
    }

    public Node getNode(int index){ // index 위치에 있는 노드를 반환
        if(index < 0 || index >= size){ // 예외처리
            throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
        }

        Node node = head.nextNode;

        for (int i = 0; i < index; i++) {
            node = node.nextNode;
        }

        return node;
    }

    public Object getData(int index){ // index 위치에 있는 데이터를 반환
        return getNode(index).data;
    }

    public Object getFirst(){ // 첫번째 데이터를 반환
        return getData(0);
    }

    public int getNodeIndex(Object data){ // 해당 데이터 index 위치를 반환
        if(size <= 0){ return -1; }

        Node node = head.nextNode;
        int index = 0;

        while(node != null){
            if(data.equals(node.data)){
                return index;
            }

            node = node.nextNode;
            index++;
        }

        return -1; // 해당 데이터가 존재하지 않으면 -1 리턴
    }

    public void addFirst(Object data){ // 첫번째 위치에 데이터를 삽입
        Node newNode = new Node(data);
        newNode.nextNode = head.nextNode;
        head.nextNode = newNode;

        size++;
    }

    public void add(int index, Object data){ // index 위치에 데이터를 삽입
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
        }

        if(index == 0){
            addFirst(data);
            return;
        }

        Node prevNode = getNode(index - 1); // getNode 메소드 활용
        Node nextNode = prevNode.nextNode;
        Node newNode = new Node(data);

        // 새로운 노드 연결
        prevNode.nextNode = newNode;
        newNode.nextNode = nextNode;
        size++;
    }

    public Object removeFirst(){ // 첫번째 노드를 삭제하고 데이터를 반환
        Node delNode = getNode(0);
        head.nextNode = delNode.nextNode;

        size--;

        return delNode.data;
    }

    public Object remove(int index){ // index에 해당하는 노드를 제거하고 데이터를 반환
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
        }

        if(index == 0){
            return removeFirst();
        }

        Node prevNode = getNode(index - 1);
        Node delNode = getNode(index);

        prevNode.nextNode = delNode.nextNode;

        size--;

        return delNode.data;
    }

    public void reverse(){
        Node nextNode = head.nextNode;
        Node curNode = null;
        Node prevNode = null;

        while(nextNode != null){
            prevNode = curNode;
            curNode = nextNode;
            nextNode = nextNode.nextNode;
            curNode.nextNode = prevNode;
        }

        head.nextNode = curNode;
    }

    public int getSize(){ // 연결리스트의 사이즈를 반환
        return size;
    }
}
