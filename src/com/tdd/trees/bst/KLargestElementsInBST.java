package com.tdd.trees.bst;

import com.tdd.trees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

//find the k largest elements in BST and print them in desc order
public class KLargestElementsInBST {

    public static void main(final String... args) {
        final BinaryTreeNode root = CreateBST.createBinarySearchTree();
        List<Integer> kLargest = new ArrayList<>();
        getLargestNodes(root, 4, kLargest);
        printList(kLargest);
    }

    private static void printList(List<Integer> kLargest) {
        kLargest.stream().forEach((final Integer k) -> {
            System.out.println(k);
        });
    }

    private static void getLargestNodes(BinaryTreeNode root, int noOfNodes, List<Integer> kLargest) {
        if (root == null || kLargest.size() == noOfNodes)
            return;

        getLargestNodes(root.right, noOfNodes, kLargest);
        if (kLargest.size() < noOfNodes) {
            kLargest.add(root.value);
        }
        getLargestNodes(root.left, noOfNodes, kLargest);
    }
}
