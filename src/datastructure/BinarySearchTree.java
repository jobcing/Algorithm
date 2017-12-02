package datastructure;

/**
 * Created by ByeongChan on 2017. 11. 7..
 *
 * 이진 탐색 트리 구현 (Java)
 */

public class BinarySearchTree {
    private class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        // setter, getter
        public int getData() {
            return this.data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return this.left;
        }

        public void setLeft(Node node) {
            this.left = node;
        }

        public Node getRight() {
            return this.right;
        }

        public void setRight(Node node) {
            this.right = node;
        }
    }

    private Node root;

    public BinarySearchTree() { // 이진탐색트리 생성자
        this.root = null;
    }

    // 탐색연산
    public boolean searchKey(int key) {
        Node cur = root; // 루트부터 탐색

        while (cur != null) {
            if (cur.getData() == key) { // 탐색 키 값과 같다면 true 리턴
                return true;
            } else if (cur.getData() > key) { // 탐색키가 작으면 왼쪽 서브트리로 이동
                cur = cur.getLeft();
            } else { // 탐색키가 크면 오른쪽 서브트리로 이동
                cur = cur.getRight();
            }
        }

        // 탐색을 다 마쳤는데 찾지 못하면 false 리턴
        return false;
    }

    // 삽입연산
    public void insertKey(int key) {
        Node newNode = new Node(key); // 삽입될 키를 노드로 생성
        // 이제 알맞은 위치를 찾아 이 노드를 삽입해주면 된다.

        if (root == null) { // 만약 루트가 없다면 이 노드가 루트가 된다.
            root = newNode;
            return;
        }

        Node cur = root; // 탐색할 노드. 탐색은 루트부터 시작
        Node parent = null; // 이 노드 자식 노드로 삽입될 것임

        while (true) {
            parent = cur; // 부모 노드를 현재 노드로 설정하고 cur노드는 탐색을 진행

            if (cur.getData() < key) { // 키값이 크다면
                cur = cur.getRight(); // 오른쪽 서브트리로 이동

                if (cur == null) { // 오른쪽 서브트리가 null 이라면
                    parent.setRight(newNode); // 오른쪽 서브트리에 삽입
                    return;
                }
            } else if (cur.getData() > key) {
                cur = cur.getLeft(); // 왼쪽 서브트리로 이동

                if (cur == null) {
                    parent.setLeft(newNode);
                    return;
                }
            } else { // 만약 삽입하려던 key와 값다면 삽입이 되면 안된다. 이진탐색트리엔 중복된 key값이 존재하지 않는다.
                return;
            }
        }
    }

    // 삭제연산
    public boolean deleteKey(int key) {
        Node cur = root;
        Node parent = null; // 삽입삭제와 마찬가지로 삭제 시에 부모 노드에서 연결을 끊어주어야 한다.
        boolean isLeftChild = false; // 삭제할 노드가 부모노드의 왼쪽노드인지 아닌지를 확인해줄 변수

        while (cur.getData() != key) {
            parent = cur;

            if (cur.getData() > key) {
                isLeftChild = true; // 현재 노드의 왼쪽 노드이므로
                cur = cur.getLeft();
            } else {
                isLeftChild = false; // 오른쪽 노드로 이동한다면 false로 다시 변경
                cur = cur.getRight();
            }

            if (cur == null) { // 키가 존재하지 않으면
                return false;
            }
        }

        // Case 1 : 자식노드가 없는 단말 노드의 경우
        if (cur.getLeft() == null && cur.getRight() == null) {
            if (cur == root) { // 루트 노드라면 이진탐색트리를 null
                root = null;
            }

            if (isLeftChild) { // 삭제할 노드가 부모노드의 왼쪽 노드라면
                parent.setLeft(null); // 부모 노드의 왼쪽 노드를 삭제
            } else {
                parent.setRight(null);
            }
        }

        // Case 2 : 하나의 자식 노드를 갖는 경우
        else if (cur.getRight() == null) { // 오른쪽 노드가 없는 경우
            if (cur == root) {
                root = cur.getLeft(); // 왼쪽 노드를 루트로 변경
            }

            if (isLeftChild) { // 삭제할 노드가 부모노드의 왼쪽 노드라면
                parent.setLeft(cur.getLeft()); // 부모노드의 왼쪽 노드를 삭제할 노드의 왼쪽 노드로 대체
            } else {
                parent.setRight(cur.getLeft());
            }
        } else if (cur.getLeft() == null) {
            if (cur == root) {
                root = cur.getRight();
            }

            if (isLeftChild) {
                parent.setLeft(cur.getRight());
            } else {
                parent.setRight(cur.getRight());
            }
        }

        // Case 3 : 두개의 자식 노드를 갖는 경우
        else if (cur.getLeft() != null && cur.getRight() != null) {
            // 오른쪽 서브트리에서 최소값을 찾는 방법과
            // 왼쪽 서브트리에서 최대값을 찾는 방법 두 가지 방법이 존재한다.

            // 오른쪽 서브트리에서 최소값을 찾는 방법을 선택
            Node rightMin = getRightMin(cur);

            if (cur == root) {
                root = rightMin;
            }

            if (isLeftChild) {
                parent.setLeft(rightMin);
            } else {
                parent.setRight(rightMin);
            }

            rightMin.setLeft(cur.getLeft()); // 왼쪽 서브트리 연결. 오른쪽 서브트리는 연결되어있음
        }

        return true;
    }

    public Node getRightMin(Node deleteNode) {
        Node cur = deleteNode.getRight();
        Node rightMinParent = null;

        while (cur.getLeft() != null) {
            rightMinParent = cur;
            cur = cur.getLeft(); // 오른쪽 서브트리에서 제일 왼쪽에 있는 노드가 최소값이므로 탐색
        }

        if (cur != deleteNode.getRight()) { // 만약 오른쪽 서브트리 최소값이 삭제할 노드 오른쪽 자식이 아니라면
            rightMinParent.setLeft(cur.getRight());
            cur.setRight(deleteNode.getRight()); // 오른쪽 서브 트리를 연결
            // 왼쪽 서브트리도 연결시켜야하는데 이 함수에서 연결시키기 까다로움
            // 왼쪽 서브트리는 위에서 연결
        }

        return cur;
    }

    // print method
    public void inorder(Node root){
        if(root != null){
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }

    public void preorder(Node root){
        if(root != null){
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void postorder(Node root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.data);
        }
    }

    // print
    public void printBST(){
        inorder(root);
        System.out.println();
    }
}
