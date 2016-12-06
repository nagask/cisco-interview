package com.test;

public class TreeNode implements GNode {

    private final String name;
    private GNode[] children;

    public TreeNode(String name, GNode[] children) {
        this.name = name;
        this.children = children;
    }

    public TreeNode(String name) {
        this(name, new GNode[0]);
    }

    public String getName() {
        return name;
    }

    public GNode[] getChildren() {
        return children;
    }

}
