package com.example.amazon.tree;

import java.util.LinkedList;
import java.util.List;

public class PrintNodesAtDistanceKFromAnyNode {

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        Node target = root.left;
        List<Node> nodes = new LinkedList<>();
        getNodesAtDistance(root, target, 2, nodes);
        System.out.println(nodes);
    }

    static int getNodesAtDistance(Node root, Node target, int K, List<Node> nodes) {
        if(root == null) return -1;
        if(root == target){
            nodes.addAll(getNodesKDown(root,K));
            return 0;
        } else {
            int dLeft = getNodesAtDistance(root.left, target, K, nodes);
            if(dLeft != -1){
                if(dLeft + 1 == K){
                    nodes.add(root);
                } else if(K-dLeft-2>=0){
                    nodes.addAll(getNodesKDown(root.right,K-dLeft-2));
                }
                return 1+dLeft;
            }
            int dRight = getNodesAtDistance(root.right, target, K, nodes);
            if(dRight != -1){
                if(dRight + 1 == K){
                    nodes.add(root);
                }else if(K-dRight-2>=0){
                    nodes.addAll(getNodesKDown(root.left,K-dRight-2));
                }
                return 1 +dRight;
            }
            return -1;
        }
    }

    static List<Node> getNodesKDown(Node root, int K){
        LinkedList<Node> nodes = new LinkedList<>();
        getNodesKDown(root,K, nodes);
        return nodes;
    }

    static void getNodesKDown(Node root, int K, List<Node> nodes) {
        if(root == null) return;
        if(K == 0){
            nodes.add(root);
        } else {
            getNodesKDown(root.left,K-1,nodes);
            getNodesKDown(root.right,K-1,nodes);
        }
    }

}


