package com.example.amazon.array;


import java.util.Arrays;

/**
 * Given a 2D array, find the maximum sum subarray in it.
 * For example, in the following 2D array, the maximum sum sub array is left = 1, right = 3, top = 1, bottom = 3 max sum = 29
 *  {1,  2, -1, -4, -20},
 *  {-8, -3, 4,  2,  1},
 *  {3,   8, 10, 1,  3},
 *  {-4, -1, 1,  7, -6}
 *
 *
 *  Idea is to consider every possible rectangle
 *
 */
public class RectangleWithMaxSum {
    public static void main(String[] args) {
        int[][] rectangle = new int[][] {
                {1,   2, -1, -4, -20},
                {-8, -3, 4,  2,   1},
                {3,   8, 10, 1,   3},
                {-4, -1, 1,  7,  -6}
        };
        Rectangle rect = findLargestRectangle(rectangle);
        System.out.println(rect);
    }

    static Rectangle findLargestRectangle(int[][] rect){
        int R = rect.length;
        int C = rect[0].length;
        int maxSum = Integer.MIN_VALUE;
        Rectangle rectangle = new  Rectangle(0,0,0,0);
        rectangle.setSum(rect[0][0]);

        for(int c1 =0; c1 < C;c1++){
            int[] sumArr =  new int[R];
            for(int c2 = c1; c2 < C; c2++){
                for(int r = 0;r<R;r++){
                    sumArr[r] += rect[r][c2];
                }
                //System.out.println(Arrays.toString(sumArr));
                Kadane kadane = findMaxSumContiguousSubArray(sumArr);
                if(kadane.maxSum > maxSum){
                    maxSum = kadane.maxSum;
                    rectangle = new Rectangle(kadane.left, c1, c2, kadane.right);
                    rectangle.setSum(kadane.maxSum);
                }

            }
        }
        return rectangle;
    }
    static Kadane findMaxSumContiguousSubArray(int[] arr){
        int sum =0;
        int max= 0;
        int left=0;
        int right=0;
        boolean allNeg = true;
        Kadane kadane = new Kadane(0,0,0);
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(sum < 0) {
                sum = 0;
                left = i+1;
            } else if(sum > max) {
                right = i;
                kadane.left = left;
                kadane.right = right;
                kadane.maxSum = sum;
                max = sum;
                allNeg = false;
            }
        }

        if(!allNeg) {
            return kadane;
        }

        max = arr[0];
        for(int i=1;i<arr.length;i++){
            max = Math.max(max, arr[i]);
            left = right = i;
        }
        return new Kadane(max, left, right);
    }

    static class Kadane {
        int left;
        int right;
        int maxSum;

        public Kadane(int left, int right, int maxSum) {
            this.left = left;
            this.right = right;
            this.maxSum = maxSum;
        }
    }
    static class Rectangle {
        int sum;
        int top;
        int left;
        int right;
        int bottom;

        public Rectangle(int top, int left, int right, int bottom) {
            this.top = top;
            this.left = left;
            this.right = right;
            this.bottom = bottom;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "Rectangle[" +
                    "sum=" + sum +
                    ", top=" + top +
                    ", left=" + left +
                    ", right=" + right +
                    ", bottom=" + bottom +
                    ']';
        }
    }
}
