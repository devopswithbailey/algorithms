package com.binary.tree;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SerializeBinaryTree {
    public static void main(String[] args) throws IOException {
        SerializeBinaryTree serializeBinaryTree = new SerializeBinaryTree();
        StringBuilder str = new StringBuilder();
        serializeBinaryTree.printBinaryTree(Arrays.asList(serializeBinaryTree.createBinaryTree()), str);
        BufferedWriter writer = new BufferedWriter(new FileWriter("binary-tree/src/main/resources/serializedBinaryTree.txt"));
        writer.write(str.toString());
        writer.close();
    }

    public Tree createBinaryTree() {
        Tree eight = new Tree(8, null, null);
        Tree seven = new Tree(7, null, null);
        Tree six = new Tree(6, null, null);
        Tree five = new Tree(5, seven, eight);
        Tree third = new Tree(3, five, six);
        Tree four = new Tree(4, null, null);
        Tree second = new Tree(2, four, null);
        Tree root = new Tree(1, second, third);
        return root;
    }

    public void printBinaryTree(List<Tree> trees, StringBuilder str) {
        if (!trees.isEmpty()) {
            str.append(trees.stream().map(item -> {
                if (item != null) return item.getElement() + "";
                else return "null";
            }).collect(Collectors.joining(" ")));
            str.append("\n");
            List<Tree> children = new ArrayList<>();
            trees.stream().forEach(tree -> {
                if(tree!=null){
                    if (tree.getLeft() != null) children.add(tree.getLeft());
                    else children.add(null);
                    if (tree.getRight() != null) children.add(tree.getRight());
                    else children.add(null);
                }
            });
            printBinaryTree(children, str);
        }
    }
}
