package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Application {

    public ArrayList walkGraph(GNode root) {
        if (root == null) throw new IllegalArgumentException();

        ArrayList<GNode> resultList = new ArrayList<>();

        List<GNode> stack = new ArrayList<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            GNode node = stack.remove(0);
            stack.addAll(Arrays.asList(node.getChildren()));
            resultList.add(node);
        }

        return resultList;
    }


    public ArrayList paths(GNode root) {
        if (root == null) throw new IllegalArgumentException();

        final ArrayList<List<GNode>> resultList = new ArrayList<>();

        final List<LinkedList<GNode>> stack = new ArrayList<>();
        stack.add(new LinkedList<>(Arrays.asList(root)));

        while (!stack.isEmpty()) {
            final LinkedList<GNode> path = stack.remove(0);
            GNode[] children = path.getLast().getChildren();
            Arrays.stream(children)
                    .forEach(child -> {
                        LinkedList<GNode> list = new LinkedList<>(path);
                        list.add(child);
                        stack.add(list);
                    });
            if (children.length == 0) {
                resultList.add(path);
            }
        }

        return resultList;
    }


}
