package com.example.ds.segmenttree;

import java.util.Arrays;

public class RangeMaxQuery {
    int[] tree;

    // input array and its size
    int[] arr;
    int N;

    RangeMaxQuery(int[] arr){
        this.arr = arr;
        this.N = arr.length;
        tree = new int[getSize(N)];
        buildTree();
    }
    private int getSize(int N){
        int p =1;
        while(p<N)p<<=1;
        return 2*p-1;
    }

    void buildTree(){
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
        tree[si] = Math.max(build(l, mid, 2*si+1) , build(mid+1, h, 2*si+2));
        return tree[si];

    }

    public int getMax(int l, int r){
        return getMax(l, r, 0, N-1, 0);
    }
    public int getMax(int qL, int qR, int ss, int se, int si){
        if(qL <= ss &&  qR >= se) return tree[si];
        if(qL > se || qR < ss) return 0;
        int mid = ss + (se-ss)/2;
        return Math.max(getMax(qL, qR, ss, mid, 2*si+1),  getMax(qL, qR, mid+1, se, 2*si+2));
    }

    public void update(int p, int value){

        arr[p] = value;
        update(0, N-1, 0, p, value);
        System.out.println("SegmentTree "+ Arrays.toString(tree));
        System.out.println("Array"+ Arrays.toString(arr));
    }
    void update(int ss, int se, int si, int p, int value){
        if(p<ss || p>se) return;
        if(ss == se){
            tree[si]= value;
            return;
        }
        tree[si] = Math.max(tree[si], value);
        int mid = ss + (se-ss)/2;
        update(ss,mid-1,2*si+1,p, value);
        update(mid+1, se, 2*si+2, p, value);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,9,11};
        RangeMaxQuery tree = new RangeMaxQuery(arr);

        System.out.println("max(1,4)" + tree.getMax(1,4));
        System.out.println("max(2,5)" + tree.getMax(2,5));
        System.out.println("update(1,10)");tree.update(1,10);
        System.out.println("max(0,3)" + tree.getMax(0,3));
    }
}
