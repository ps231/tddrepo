package com.tdd.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConstructTreeBasedOnParentChildList {

    public static void main(final String[] args) {
        List<ParentChild> pcList = new ArrayList<>();
        pcList.add(new ParentChild(2, 3));
        pcList.add(new ParentChild(6, 5));
        pcList.add(new ParentChild(4, 6));
        pcList.add(new ParentChild(2, 1));
        pcList.add(new ParentChild(4, 2));
        pcList.add(new ParentChild(6, 7));
        BinaryTreeNode root = constructTree(pcList);
        System.out.println(root.value);
    }

    public static BinaryTreeNode constructTree(List<ParentChild> pcList) {
        BinaryTreeNode root = null;
        Map<Integer, BinaryTreeNode> nodeMap = new HashMap<>();

        Set<Integer> childSet = new HashSet<>();
        for (ParentChild p : pcList) {
            childSet.add(p.child);
        }

        for (ParentChild p : pcList) {
            BinaryTreeNode child;
            if (!nodeMap.containsKey(p.child)) {
                child = new BinaryTreeNode(p.child, null, null);
                nodeMap.put(p.child, child);
            } else {
                child = nodeMap.get(p.child);
            }

            BinaryTreeNode parent;
            if (!nodeMap.containsKey(p.parent)) {
                parent = new BinaryTreeNode(p.parent, child, null);
                nodeMap.put(p.parent, parent);
            } else {
                parent = nodeMap.get(p.parent);
                parent.right = child;
            }

            if (!childSet.contains(p.parent))
                root = parent;
        }

        return root;
    }

}

class ParentChild {
    int parent;
    int child;

    public ParentChild(int parent, int child) {
        this.parent = parent;
        this.child = child;
    }
}
