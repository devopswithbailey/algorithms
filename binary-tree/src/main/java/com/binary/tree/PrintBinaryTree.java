package com.binary.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintBinaryTree {
    public static void main(String[] args) {
        PrintBinaryTree printBinaryTree = new PrintBinaryTree();
        //printBinaryTree.printBinaryTree(Arrays.asList(printBinaryTree.createBinaryTree()));
        printBinaryTree.printBinaryTreeWithRowNum(Arrays.asList(printBinaryTree.createBinaryTree()), 1);
    }

    public void printBinaryTree(List<Tree> trees) {
        if (!trees.isEmpty()) {
            System.out.println(trees.stream().map(item -> item.getElement() + "").collect(Collectors.joining(" ")));
            List<Tree> children = new ArrayList<>();
            trees.stream().forEach(tree -> {
                if (tree.getLeft() != null) children.add(tree.getLeft());
                if (tree.getRight() != null) children.add(tree.getRight());
            });
            printBinaryTree(children);
        }
    }

    public void printBinaryTreeWithRowNum(List<Tree> trees, int rowNum) {
        if (!trees.isEmpty()) {
            System.out.print("row#" + rowNum + " ");
            System.out.println(trees.stream().map(item -> item.getElement() + "").collect(Collectors.joining(" ")));
            List<Tree> children = new ArrayList<>();
            trees.stream().forEach(tree -> {
                if (tree.getLeft() != null) children.add(tree.getLeft());
                if (tree.getRight() != null) children.add(tree.getRight());
            });
            printBinaryTreeWithRowNum(children, ++rowNum);
        }
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
}
