package com.example.ds.tree.traversal;


public class Traversal {
    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] marks = new int[]{25, 24, 26, 10, 80, 40, 35, 6, 20};
        for (int mark: marks) {
            tree.add(mark);
        }
        display(tree,Order.PRE_ORDER);
        display(tree,Order.POST_ORDER);
        display(tree,Order.IN_ORDER);
        display(tree,Order.LEVEL_ORDER);
        display(tree,Order.REVERSE_LEVEL_ORDER);
        display(tree,Order.LEFT_VIEW);
        display(tree,Order.RIGHT_VIEW);
        display(tree,Order.TOP_VIEW);
        display(tree,Order.BOTTOM_VIEW);
        display(tree,Order.ZIG_ZAG_ORDER);
        display(tree,Order.LEVEL_ORDER_LINE_BY_LINE);
        display(tree,Order.LEVEL_ORDER_LINE_BY_LINE_2_QUEUES);
        display(tree,Order.VERTICAL_ORDER);
        display(tree,Order.BOUNDARY);

    }

    private static void display(Tree tree, Order order) {
        System.out.print(order+" [ ");
        tree.traverse(order);
        System.out.println("\b]");
    }
}
