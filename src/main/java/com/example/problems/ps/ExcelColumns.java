package com.example.problems.ps;

public class ExcelColumns {
    public static void main(String[] args) {

        int[] arr = {2133, 676, 26, 52, 48};

        for(int i: arr) {
            String title = mapToTitle(i);
            System.out.println("Title :" + title);
            int num = mapToNumber(title);
            System.out.println("Number :"+num);
            System.out.println();
        }

    }

    static int mapToNumber(String title){
        int num = 0;
        for(char ch : title.toCharArray()) {
            num *= 26;
            num += (int)(ch - 'A' + 1);
        }
        return num;
    }

    static String mapToTitle(int num) {
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            int r = 0;
            if(num%26 == 0) {
                r = 26;
                num = num/26 - 1 ;
            } else {
                r = num%26;
                num = num/26;
            }
            sb.append((char)(65 - 1 + r));
        }

        return new String(sb.reverse());
    }
}
