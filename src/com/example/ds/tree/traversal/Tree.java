package com.example.ds.tree.traversal;

import com.example.ds.tree.node.Node;

import java.util.*;

public class Tree {
    private Node root;

    public void add(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Node node = new Node(data);
        addNode(root, node);
    }

    private void addNode(Node root, Node node) {
        if (root.getData() > node.getData()) {
            if (root.getLeft() == null) {
                root.setLeft(node);
            } else {
                addNode(root.getLeft(), node);
            }
        } else {
            if (root.getRight() == null) {
                root.setRight(node);
            } else {
                addNode(root.getRight(), node);
            }
        }
    }

    public void traverse(Order order) {
        switch (order) {
            case IN_ORDER:inOrder(root);break;
            case ITERATIVE_IN_ORDER:iterativeInOrder();break;
            case PRE_ORDER:preOrder(root);break;
            case ITERATIVE_PRE_ORDER:iterativePreOrder();break;
            case POST_ORDER:postOrder(root);break;
            case ITERATIVE_POST_ORDER:iterativePostOrder();break;
            case LEVEL_ORDER:levelOrder();break;
            case LEVEL_ORDER_LINE_BY_LINE:levelOrderLineByLine();break;
            case LEVEL_ORDER_LINE_BY_LINE_2_QUEUES:levelOrderLineByLineUsingQueues();break;
            case REVERSE_LEVEL_ORDER:reverseLevelOrder();break;
            case ZIG_ZAG_ORDER:zigZagOrder();break;
            case LEFT_VIEW:leftView();break;
            case RIGHT_VIEW:rightView();break;
            case TOP_VIEW:topView();break;
            case BOTTOM_VIEW:bottomView();break;
            case VERTICAL_ORDER:verticalOrder();break;
            case BOUNDARY:boundaryTraversal();break;
        }
    }

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.getLeft());
        System.out.print(node + "\t");
        inOrder(node.getRight());
    }
    private void iterativeInOrder() {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while(node != null) {
            stack.push(node);
            node = node.getLeft();
        }
        while(!stack.isEmpty()) {
            Node node1 = stack.pop();
            System.out.print(node1+"\t");
            if(node1.getRight() != null) {
                Node node2 = node1.getRight();
                while(node2 != null) {
                    stack.push(node2);
                    node2 = node2.getLeft();
                }
            }
        }
    }

    private void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node + "\t");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    private void iterativePreOrder() {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node+"\t");
            if(node.getRight() != null) {
                stack.push(node.getRight());
            }
            if(node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }

    private void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node + "\t");
    }

    private void iterativePostOrder() {
        if (root == null) return;
    }
    private void levelOrder() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node + "\t");
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
        }
    }

    private void levelOrderLineByLine() {
        System.out.println();
        if (root == null) return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                System.out.println();
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            } else {
                System.out.print(node + "\t");
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
        }
    }
    private void levelOrderLineByLineUsingQueues() {
        System.out.println();
        if (root == null) return;
        Queue<Node> lToR = new LinkedList<>();
        Queue<Node> rToL = new LinkedList<>();
        lToR.offer(root);
        while (!lToR.isEmpty() || !rToL.isEmpty()) {
            while (!lToR.isEmpty()) {
                Node node = lToR.poll();
                System.out.print(node + "\t");
                if (node.getLeft() != null) {
                    rToL.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    rToL.offer(node.getRight());
                }
            }
            System.out.println();
            while (!rToL.isEmpty()) {
                Node node = rToL.poll();
                System.out.print(node + "\t");
                if (node.getLeft() != null) {
                    lToR.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    lToR.offer(node.getRight());
                }
            }
            System.out.println();
        }
    }


    private void reverseLevelOrder() {
        if (root == null) return;
        Stack<Node> nodes = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            nodes.push(node);
            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
        }
        while (!nodes.isEmpty()) {
            System.out.print(nodes.pop() + "\t");
        }
    }



    private void zigZagOrder() {
        if (root == null) return;
        Stack<Node> lToR = new Stack<>();
        Stack<Node> rToL = new Stack<>();
        lToR.push(root);
        while (!lToR.isEmpty() || !rToL.isEmpty()) {
            while (!lToR.isEmpty()) {
                Node node = lToR.pop();
                System.out.print(node + "\t");
                if (node.getLeft() != null) {
                    rToL.push(node.getLeft());
                }
                if (node.getRight() != null) {
                    rToL.push(node.getRight());
                }
            }

            while (!rToL.isEmpty()) {
                Node node = rToL.pop();
                System.out.print(node + "\t");
                if (node.getRight() != null) {
                    lToR.push(node.getRight());
                }
                if (node.getLeft() != null) {
                    lToR.push(node.getLeft());
                }
            }
        }
    }

    private void leftView() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        System.out.print(root + "\t");
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                if (!queue.isEmpty()) {
                    System.out.print(queue.peek() + "\t");
                    queue.offer(null);
                }
            } else {
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
            }
        }
    }

    private void rightView() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        System.out.print(root + "\t");
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                if (!queue.isEmpty()) {
                    System.out.print(queue.peek() + "\t");
                    queue.offer(null);
                }
            } else {
                if (node.getRight() != null) {
                    queue.offer(node.getRight());
                }
                if (node.getLeft() != null) {
                    queue.offer(node.getLeft());
                }
            }
        }
    }

    private void topView() {
        if (root == null) return;
        Map<Integer, Node> map = new TreeMap<>();

        Queue<XNode> queue = new LinkedList<>();
        XNode xRoot = new XNode(root);
        queue.offer(xRoot);
        while(!queue.isEmpty()) {
            XNode xNode = queue.poll();
            map.putIfAbsent(xNode.getX(), xNode.getNode());
            if(xNode.getNode().getLeft() != null) {
                queue.offer(new XNode(xNode.getNode().getLeft(),xNode.getX()-1));
            }
            if(xNode.getNode().getRight() != null) {
                queue.offer(new XNode(xNode.getNode().getRight(), xNode.getX()+1));
            }
        }
        map.forEach((key, value) -> {
            System.out.print(value + "\t");
        });
    }

    private void bottomView() {
        if (root == null) return;
        Map<Integer, Node> map = new TreeMap<>();

        Queue<XNode> queue = new LinkedList<>();
        XNode xRoot = new XNode(root);
        queue.offer(xRoot);
        while(!queue.isEmpty()) {
            XNode xNode = queue.poll();
            map.put(xNode.getX(), xNode.getNode());
            if(xNode.getNode().getLeft() != null) {
                queue.offer(new XNode(xNode.getNode().getLeft(),xNode.getX()-1));
            }
            if(xNode.getNode().getRight() != null) {
                queue.offer(new XNode(xNode.getNode().getRight(), xNode.getX()+1));
            }
        }

        map.forEach((key, value) -> {
            System.out.print(value + "\t");
        });
    }

    private void verticalOrder() {
        System.out.println();
        if (root == null) return;
        TreeMap<Integer, List<Node>> map = new TreeMap<>();
        verticalOrder(map, root, 0);
        map.forEach((key, value) -> {
            System.out.println(key + ":\t" + value);
        });
    }

    private void verticalOrder(TreeMap<Integer, List<Node>> map, Node node, int x) {
        if (node == null) return;
        List<Node> nodes = map.get(x);
        if (nodes == null) {
            nodes = new ArrayList<>();
        }
        nodes.add(node);
        map.put(x, nodes);
        verticalOrder(map, node.getLeft(), x - 1);
        verticalOrder(map, node.getRight(), x + 1);
    }


    private void boundaryTraversal() {
        if (root == null) return;
        System.out.print(root + "\t");
        if(root.getLeft() != null) {
            printLeftBoundary(root.getLeft());
        }
        printLeaf(root);
        if(root.getRight() != null) {
            printRightBoundary(root.getRight());
        }

    }

    private void printLeftBoundary(Node node) {
        if (node.getLeft() != null) {
            System.out.print(node + "\t");
            printLeftBoundary(node.getLeft());
        } else if (node.getRight() != null) {
            System.out.print(node + "\t");
            printLeftBoundary(node.getRight());
        }
    }

    private void printRightBoundary(Node node) {
        if (node.getRight() != null) {
            printRightBoundary(node.getRight());
            System.out.print(node + "\t");
        } else if (node.getLeft() != null) {
            printRightBoundary(node.getLeft());
            System.out.print(node + "\t");
        }
    }

    private void printLeaf(Node node) {
        if (node == null) return;
        printLeaf(node.getLeft());
        if (node.getRight() == null && node.getLeft() == null) {
            System.out.print(node + "\t");
        }
        printLeaf(node.getRight());
    }
}
