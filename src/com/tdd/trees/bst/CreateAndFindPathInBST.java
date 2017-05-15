package com.tdd.trees.bst;

import com.tdd.trees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class CreateAndFindPathInBST {

    public static void main(final String... arsg) {
        final List<Integer> nodes = new ArrayList<Integer>();
        nodes.add(7);
        nodes.add(1);
        nodes.add(8);
        nodes.add(5);
        nodes.add(3);
        nodes.add(6);

        System.out.println(new CreateAndFindPathInBST().findPathLength(nodes, 3, 8));
    }


    private int findPathLength(final List<Integer> nodes, final int n1, final int n2) {

        if (!nodes.contains(n1) || !nodes.contains(n2))
            return -1;

        final BinaryTreeNode head = createBST(nodes);

        return findPath(head, n1, n2);
    }

    private int findPath(final BinaryTreeNode head, final int n1, final int n2) {
        int path = -1;
        final BinaryTreeNode lca = findLCA(head, n1, n2);
        if (lca != null) {
            if (lca.value == n1) {
                path = calculatePath(lca, n2);
            } else if (lca.value == n2) {
                path = calculatePath(lca, n1);
            } else {
                path = calculatePath(lca, n1);
                path += calculatePath(lca, n2);
            }
        }
        return path;
    }

    private int calculatePath(BinaryTreeNode node, final int n) {
        int path = 0;

        while (node != null) {
            if (n > node.value) {
                node = node.right;
                path++;
            } else if (n < node.value) {
                node = node.left;
                path++;
            } else {
                break;
            }
        }
        return path;
    }

    private BinaryTreeNode findLCA(BinaryTreeNode head, final int n1, final int n2) {
        if (head == null)
            return null;

        if (n1 < head.value && n2 < head.value)
            head = findLCA(head.left, n1, n2);
        else if (n1 > head.value && n2 > head.value)
            head = findLCA(head.right, n1, n2);
        return head;
    }

    private BinaryTreeNode createBST(final List<Integer> nodes) {
        BinaryTreeNode head = null;

        for (int node : nodes) {
            head = addNodeToBST(head, node);
        }
        return head;
    }

    private BinaryTreeNode addNodeToBST(BinaryTreeNode head, final int node) {
        BinaryTreeNode temp = head;
        if (temp == null) {
            temp = new BinaryTreeNode(node, null, null);
            head = temp;
        } else {
            while (true) {
                if (node < temp.value) {
                    if (temp.left == null) {
                        temp.left = new BinaryTreeNode(node, null, null);
                        break;
                    } else
                        temp = temp.left;
                } else {
                    if (temp.right == null) {
                        temp.right = new BinaryTreeNode(node, null, null);
                        break;
                    } else
                        temp = temp.right;
                }
            }
        }
        return head;
    }
}
