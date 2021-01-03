package com.binary.tree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Tree {
    private int element;
    private Tree left;
    private Tree right;
}
