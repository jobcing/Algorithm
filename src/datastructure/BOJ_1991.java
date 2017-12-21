package datastructure;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by ByeongChan on 2017. 9. 22..
 *
 * 백준 알고리즘 1991번 풀이 (https://www.acmicpc.net/problem/1991)
 *
 * HashMap을 이용한 BinaryTree 구현
 */
public class BOJ_1991 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        HashMap<String, BinaryTree> binaryTree = new HashMap<>();

        scan.nextLine();
        for (int i = 0; i < N; i++) {
            String[] line = scan.nextLine().split(" ");

            binaryTree.put(line[0], new BinaryTree(line[1], line[2]));
        }

        preorder("A", binaryTree);
        System.out.println();
        inorder("A", binaryTree);
        System.out.println();
        postorder("A", binaryTree);
    }

    private static class BinaryTree{
        private String leftNode;
        private String rightNode;

        public BinaryTree(String leftNode, String rightNode){
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }

    private static void preorder(String key, HashMap<String, BinaryTree> binaryTree){
        BinaryTree node = binaryTree.get(key);

        if(node != null){
            System.out.print(key);
            preorder(node.leftNode, binaryTree);
            preorder(node.rightNode, binaryTree);
        }
    }

    private static void inorder(String key, HashMap<String, BinaryTree> binaryTree){
        BinaryTree node = binaryTree.get(key);

        if(node != null){
            inorder(node.leftNode, binaryTree);
            System.out.print(key);
            inorder(node.rightNode, binaryTree);
        }
    }

    private static void postorder(String key, HashMap<String, BinaryTree> binaryTree){
        BinaryTree node = binaryTree.get(key);

        if(node != null){
            postorder(node.leftNode, binaryTree);
            postorder(node.rightNode, binaryTree);
            System.out.print(key);
        }
    }
}
