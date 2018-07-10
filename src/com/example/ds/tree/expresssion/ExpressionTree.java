package com.example.ds.tree.expresssion;

import java.util.*;
import java.util.function.BiFunction;

public class ExpressionTree {
    private Node root;

    private Stack<Node> nodes = new Stack<>();

    public ExpressionTree(String expression) {
        parseExpression(expression);
    }

    private static Map<String, BiFunction<Integer, Integer, Integer>> operators = new HashMap<>();

    static {
        operators.put("+", (a,b)-> a+b);
        operators.put("-", (a,b)-> a-b);
        operators.put("*", (a,b)-> a*b);
        operators.put("/", (a,b)-> a/b);
        operators.put("**",(a,b)-> (int)Math.pow(a,b));
    }

    private void parseExpression(String expression) {
        String[] tokens = expression.split("\\s+");
        for (String token : tokens) {
            add(token);
        }

        if (nodes.isEmpty() || nodes.size() > 1) throw new RuntimeException("Invalid Prostfix");
        root = nodes.pop();

    }


    private void add(String token) {
        token = token.trim();
        if (isInteger(token)) {
            nodes.add(new Node(token));
        } else if (isOperator(token)) {
            if (nodes.size() < 2) throw new RuntimeException("Invalid Postfix");
            Node a = nodes.pop();
            Node b = nodes.pop();

            Node operator = new Node(token);
            operator.right = a;
            operator.left = b;
            nodes.push(operator);
        }
    }

    public void infix() {
        infix(root);
    }

    private void infix(Node root) {
        if (root == null) return;
        infix(root.left);
        System.out.print(root.value + " ");
        infix(root.right);
    }

    public void prefix() {
        prefix(root);
    }

    public void prefix(Node root) {
        if (root == null) return;
        System.out.print(root.value + " ");
        prefix(root.left);
        prefix(root.right);
    }

    private boolean isOperator(String token) {
        return operators.containsKey(token);
    }

    private boolean isInteger(String token) {
        try {
            Integer.valueOf(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public int evaluate() {
       return  evaluate(root);
    }

    private int evaluate(Node root) {
        if(root == null ) return 0;
        //if(isInteger(root.value)) return Integer.valueOf(root.value);
        //Leaf Node  must be an operand
        if(root.left == null || root.right == null) return Integer.valueOf(root.value);

        //We encountered an operator Node
        int left = evaluate(root.left);
        int right = evaluate(root.right);
        return operators.get(root.value).apply(left, right);
    }

}
