package com.example.ds.stack;

public class ExpressionTreeTest {
    public static void main(String[] args) {
        String expression = "5 9 + 2 * 3 +";
        ExpressionTree tree = new ExpressionTree(expression);
        System.out.print("Infix :");
        tree.infix();

        System.out.println();
        System.out.print("Prefix :");
        tree.prefix();

        System.out.println();
        System.out.println("Evaluate : " + tree.evaluate());
    }
}
