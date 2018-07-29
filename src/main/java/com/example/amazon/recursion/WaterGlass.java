package com.example.amazon.recursion;

/**
 * There is a stack of water glasses in a form of pascal triangle
 * and a person wants to pour the water at the topmost glass,
 * but the capacity of each glass is 1 unit .
 * Overflow takes place in such a way that after 1 unit,
 * 1/2 of remaining unit gets into bottom left glass and other half in bottom right glass.
 * <p>
 * Now he pours K units of water in the topmost glass and wants to know how much water is there in the jth glass of the ith row.
 */
public class WaterGlass {

    static double[][] glass;

    public static void main(String[] args) {
        glass = new double[11][11];
        //fill top glass with 10 litre water
        fillGlass(10);
        System.out.println("Water in Glass[4][1] = " + glass[4][1]);
        System.out.println("Glasses :");
        showGlasses();
    }


    static void fillGlass(int K) {
        fillGlass(K, 1, 1);
    }

    static void fillGlass(double K, int i, int j) {
        if (glass[i][j] + K <= 1) {
            glass[i][j] += K;
            return;
        }

        K += glass[i][j];
        glass[i][j] = 1;

        fillGlass((K - 1) / 2, i + 1, j);
        fillGlass((K - 1) / 2, i + 1, j + 1);
    }

    static void showGlasses() {
        for (double[] g : glass) {
            StringBuilder sb = new StringBuilder();
            for (double gl : g) {
                if (gl == 0) sb.append("|0 ");
                else sb.append("|" + gl);
            }
            sb.append("|");
            System.out.println(sb);
        }
    }
}

