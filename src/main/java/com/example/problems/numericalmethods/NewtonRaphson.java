package com.example.problems.numericalmethods;

/*===================================================
Using Newton-Raphson Method
X1 = X0 - f(X0)/f'(X0)
for f(X) = X^2 - D
We have equation as X1 =  X0 - X^2 - D/2*X0


Cube Root
X1 = X0 - (X^3 - D)/(3*X^2);
==================================================== */
public class NewtonRaphson {
    public static void main(String[] args)  {
        System.out.println("SquareRoot(5):\t"+getSquareRoot(5));
        System.out.println("SquareRoot(4):\t"+getSquareRoot(4));
        System.out.println("CubeRoot(8):\t"+getCubeRoot(8));
        System.out.println("CubeRoot(10):\t"+getCubeRoot(10));
    }
    public static double getSquareRoot(double d) {
        double X0 = 1;
        double X1;
        double precision = 0.0000001;
        double dX = 1;
        do {
            X1 = X0 - (X0*X0 - d)/(2*X0);
            dX = Math.abs(X0-X1);
            X0 = X1;
        }while(dX > precision);
        return X1;
    }
    public static double getCubeRoot(double d) {
        double X0 = 1;
        double X1;
        double precision = 0.0000001;
        double dX = 1;
        do {
            X1 = X0 - (X0*X0*X0 - d)/(3*X0*X0);
            dX = Math.abs(X0-X1);
            X0 = X1;
        }while(dX > precision);
        return X1;
    }
}
