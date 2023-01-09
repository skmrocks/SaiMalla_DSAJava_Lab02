package com.saimalla.dsajava.lab02.problem01;

import java.util.Arrays;

import com.saimalla.dsajava.lab02.problem01.services.PayMoneyService;

/**
 * App main class for Pay money services.
 */
public class App {

    /**
     * main method for pay money services.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.print("Enter the size of transaction array: ");
        int size = Integer.parseInt(System.console().readLine());
        System.out.println();
        System.out.print("Enter the values of array: ");
        int[] transactions = Arrays.stream(System.console().readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        if (transactions.length != size) {
            System.out.println("Transactions found to be not valid.");
        }
        System.out.println();
        System.out.print("Enter the total no of targets that needs to be achieved: ");
        int noOfTargets = Integer.parseInt(System.console().readLine());
        System.out.println();
        for (int i = 1; i <= noOfTargets; i++) {
            PayMoneyService.runSamples(i, transactions);
        }
    }
}
