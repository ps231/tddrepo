package com.tdd.trees;

import static com.sun.tools.doclint.Entity.not;

/**
 * Created by shindikp on 10/21/16.
 */
public class HeightBalancedTree {

    public static void main(String... args) {

        BinaryTreeNode root = BinaryTree.createUnbalancedTree();

        int leftHeight = getSubTreeHeight(root.left, 1);
        int rightHeight = getSubTreeHeight(root.right, 1);

        if(!(leftHeight - rightHeight == 1 || leftHeight - rightHeight == 0)) {
            System.out.println("Height compared at node " + root.value + ": Tree not height balanced");
        } else {
            System.out.println("Height compared at node " + root.value + ": Tree is balanced");
        }
    }

    private static int getSubTreeHeight(BinaryTreeNode node, int height) {
        if(node.left != null) {
            height = getSubTreeHeight(node.left, height + 1);
        }
        if(node.right != null) {
            height = getSubTreeHeight(node.right, height + 1);
        }
        return height;
    }
}
