package com.binary.tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeserializeBinaryTree {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("binary-tree/src/main/resources/serializedBinaryTree.txt"));
        String line = reader.readLine();
        if (line == null || line.equals("null")) return;
        Tree root = new Tree(Integer.valueOf(line).intValue(), null, null);
        List<Tree> parents = Arrays.asList(root);
        DeserializeBinaryTree deserializeBinaryTree = new DeserializeBinaryTree();
        while ((line = reader.readLine()) != null) {
            parents = deserializeBinaryTree.createBinaryTree(parents, line);
        }

        new PrintBinaryTree().printBinaryTree(Arrays.asList(root));
    }

    public List<Tree> createBinaryTree(List<Tree> parents, String childrenStr) {
        String[] children = childrenStr.split(" ");
        List<Tree> childrenTrees = new ArrayList<>();
        int index = 0;
        for (Tree parent : parents) {
            if (!children[index].equals("null")) {
                Tree leftChild = new Tree(Integer.valueOf(children[index]).intValue(), null, null);
                parent.setLeft(leftChild);
                childrenTrees.add(leftChild);
            }
            index++;

            if (!children[index].equals("null")) {
                Tree rightChild = new Tree(Integer.valueOf(children[index]).intValue(), null, null);
                parent.setRight(rightChild);
                childrenTrees.add(rightChild);
            }
            index++;
        }
        return childrenTrees;
    }
}
