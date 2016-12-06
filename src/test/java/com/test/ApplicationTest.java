package com.test;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ApplicationTest {

    private GNode treeRoot = null;

    @Before
    public void setup() {
        GNode nodeE = new TreeNode("E");
        GNode nodeF = new TreeNode("F");
        GNode[] subNodes1 = new GNode[] {nodeE, nodeF};

        GNode nodeG = new TreeNode("G");
        GNode nodeH = new TreeNode("H");
        GNode nodeI = new TreeNode("I");
        GNode[] subNodes2 = new GNode[] {nodeG, nodeH, nodeI};

        GNode nodeJ = new TreeNode("J");
        GNode[] subNodes3 = new GNode[] {nodeJ};

        GNode nodeB = new TreeNode("B", subNodes1);
        GNode nodeC = new TreeNode("C", subNodes2);
        GNode nodeD = new TreeNode("D", subNodes3);
        GNode[] subNodes4 = new GNode[] {nodeB, nodeC, nodeD};

        treeRoot = new TreeNode("A", subNodes4);
    }


    @Test
    public void testWalkThroughGraph() {
        Application app = new Application();
        ArrayList<GNode> list = app.walkGraph(treeRoot);

        assert 10 == list.size();
    }

    @Test
    public void testGiveAllPaths() {
        Application app = new Application();
        ArrayList<List<GNode>> list = app.paths(treeRoot);

        assert 6 == list.size();
        list.stream().forEach(path -> {
            assert 3 == path.size();
        });
    }


}