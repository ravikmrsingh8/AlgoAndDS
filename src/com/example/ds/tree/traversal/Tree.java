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
        if (order == Order.PRE_ORDER) {
            preOrder(root);
        } else if (order == Order.IN_ORDER) {
            inOrder(root);
        } else if (order == Order.POST_ORDER) {
            postOrder(root);
        } else if (order == Order.LEVEL_ORDER) {
            levelOrder();
        } else if (order == Order.ZIG_ZAG_ORDER) {
            zigZagOrder();
        } else if (order == Order.LEVEL_ORDER_LINE_BY_LINE) {
            levelOrderLineByLine();
        } else if (order == Order.LEVEL_ORDER_LINE_BY_LINE_2_QUEUES) {
            levelOrderLineByLineUsingQueues();
        } else if (order == Order.REVERSE_LEVEL_ORDER) {
            reverseLevelOrder();
        } else if (order == Order.VERTICAL_ORDER) {
            verticalOrder();
        } else if (order == Order.LEFT_VIEW) {
            leftView();
        } else if (order == Order.RIGHT_VIEW) {
            rightView();
        } else if (order == Order.TOP_VIEW) {
            topView();
        } else if(order == Order.BOTTOM_VIEW) {
            bottomView();
        } else if(order == Order.BOUNDARY) {
            boundaryTraversal();
        }
    }

    private void reverseLevelOrder() {
        if (root == null) return;
        Stack<Node> nodes = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        nodes.push(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.getRight() != null) {
                queue.offer(node.getRight());
                nodes.push(node.getRight());

            }
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
                nodes.push(node.getLeft());
            }
        }
        while (!nodes.isEmpty()) {
            System.out.print(nodes.pop() + "\t");
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

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.getLeft());
        System.out.print(node + "\t");
        inOrder(node.getRight());
    }

    private void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node + "\t");
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    private void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node + "\t");
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

    private void verticalOrder() {
        System.out.println();
        if (root == null) return;
        TreeMap<Integer, List<Node>> map = new TreeMap<>();
        verticalOrder(map, root, 0);
        map.forEach((key, value) -> {
            System.out.println(key + ":\t" + value);
        });
    }

    private void verticalOrder(TreeMap<Integer, List<Node>> map, Node node, int level) {
        if (node == null) return;
        List<Node> nodes = map.get(level);
        if (nodes == null) {
            nodes = new ArrayList<>();
        }
        nodes.add(node);
        map.put(level, nodes);
        verticalOrder(map, node.getLeft(), level - 1);
        verticalOrder(map, node.getRight(), level + 1);
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
        printLeft(root);
        printRight(root.getRight());
    }


    private void printLeft(Node node) {
        if(node == null) return;
        printLeft(node.getLeft());
        System.out.print(node+"\t");
    }

    private void printRight(Node node) {
        if(node == null) return;
        System.out.print(node+"\t");
        printRight(node.getRight());
    }

    private void bottomView(){

    }

    private void boundaryTraversal() {

    }

}
