package com.example.ds.segmenttree;

import java.util.Arrays;

public class RangeSumQuery {
    int[] tree;

    // input array and its size
    int[] arr;
    int N;

    RangeSumQuery(int[] arr){
        this.arr = arr;
        this.N = arr.length;
        tree = new int[getSize(N)];
        buildSumTree();
    }
    private int getSize(int N){
        int size = 1;
        while(N > 0){
            N>>=1;
            size<<=1;
        }
        return 2*size-1;
    }
    void buildSumTree(){
        build(0,N-1, 0);
        System.out.println("Segment Tree" + Arrays.toString(tree));
        System.out.println("Array "+ Arrays.toString(arr));
    }
    private int build(int l, int h, int si){
        if(l==h){
            tree[si] = arr[l];
            return tree[si];
        }
        int mid = l+ (h-l)/2;
        tree[si] = build(l, mid, 2*si+1) + build(mid+1, h, 2*si+2);
        return tree[si];

    }

    public int getSum(int l, int r){
        return getSum(l, r, 0, N-1, 0);
    }
    public int getSum(int qL, int qR, int ss, int se, int si){
        if(qL <= ss &&  qR >= se) return tree[si];
        if(qL > se || qR < ss) return 0;
        int mid = ss + (se-ss)/2;
        return getSum(qL, qR, ss, mid, 2*si+1) + getSum(qL, qR, mid+1, se, 2*si+2);
    }
    public void update(int p, int value){
        int delta = value -arr[p];
        arr[p] = value;
        update(0, N-1, 0, p, delta);
        System.out.println("SegmentTree "+ Arrays.toString(tree));
        System.out.println("Array"+ Arrays.toString(arr));
    }
    void update(int ss, int se, int si, int p, int delta){
        if(p<ss || p>se) return;
        tree[si] += delta;
        if(ss != se){
            int mid = ss + (se-ss)/2;
            update(ss,mid,2*si+1,p,delta);
            update(mid+1,se,2*si+2,p,delta);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,9,11};
        RangeSumQuery tree = new RangeSumQuery(arr);

        System.out.println("SUM(1,4)" + tree.getSum(1,4));
        System.out.println("SUM(2,5)" + tree.getSum(2,5));
        System.out.println("UPDATE(1,5)");
        tree.update(1,5);
        System.out.println("SUM(1,4)" + tree.getSum(1,4));
    }
}
