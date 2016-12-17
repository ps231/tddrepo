package com.tdd.trees;

public class SymmetricBinaryTree {

    public static void main(String...args) {
        BinaryTreeNode root = BinaryTree.createSkewedSymmetricTree();
        System.out.println("Is tree symmetric? " + isSymmetric(root, root));

        root = BinaryTree.createSkewedAsymmetricTree();
        System.out.println("Is tree symmetric? " + isSymmetric(root, root));

        root = BinaryTree.createBalancedSymmetricTree();
        System.out.println("Is tree symmetric? " + isSymmetric(root, root));

        root = BinaryTree.createBalancedAsymmetricTree();
        System.out.println("Is tree symmetric? " + isSymmetric(root, root));
    }

    private static boolean isSymmetric(BinaryTreeNode leftRoot, BinaryTreeNode rightRoot) {
        if (leftRoot != null && rightRoot != null) {
            if (!isSymmetric(leftRoot.left, rightRoot.right)
                    || !isSymmetric(leftRoot.right, rightRoot.left)
                    || leftRoot.value != rightRoot.value) {
                return false;
            }
        }
        return true;
    }
}
