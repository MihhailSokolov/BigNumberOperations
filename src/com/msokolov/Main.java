package com.msokolov;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first big number:");
        String strN1 = input.nextLine();
        System.out.println("Enter second big number:");
        String strN2 = input.nextLine();
        Number n1 = new Number(strN1);
        Number n2 = new Number(strN2);
        Number sum = NumberOperations.add(n1, n2);
        System.out.println("The sum is:");
        System.out.println(sum.toString());
    }
}
