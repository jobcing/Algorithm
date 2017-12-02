import datastructure.BinarySearchTree;

/**
 * Created by ByeongChan on 2017. 12. 2..
 */
public class algorithmTest {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insertKey(10);
        bst.insertKey(7);
        bst.insertKey(5);
        bst.insertKey(3);
        bst.insertKey(8);
        bst.insertKey(9);

        System.out.println("Is There 5 ?");
        if(bst.searchKey(5)){
            System.out.println("Search Success");
        } else{
            System.out.println("Search Fail");
        }

        bst.deleteKey(5);
        System.out.println("Delete 5");

        System.out.println("Is There 5 ?");
        if(bst.searchKey(5)){
            System.out.println("Search Success");
        } else{
            System.out.println("Search Fail");
        }

        bst.printBST();
    }
}
