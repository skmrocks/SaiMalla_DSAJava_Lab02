package com.saimalla.dsajava.lab02.problem01.services;

import java.util.ArrayList;

public class PayMoneyService {

    private PayMoneyService() {
        System.out.println("Paymoney service initialized...");
    }

    public static void runSamples(int i, int[] transactions) {
        System.out.print(String.format("Enter the value of %s target: ", i));
        int targetsAchieved = getConstructTargetsCount(Integer.parseInt(System.console().readLine()), transactions);
        if (targetsAchieved <= 0) {
            System.out.println("Given target is not achieved.");
        } else {
            System.out.println(String.format("Target achieved after %s transactions.", targetsAchieved));
        }
    }

    private static int getConstructTargetsCount(int target, int[] transactions) {
        ArrayList<Integer> tempElements = new ArrayList<>();
        int index = 0;
        do {
            tempElements.add(index, transactions[index]);
            if (tempElements.stream().mapToInt(Integer::intValue).sum() >= target) {
                return tempElements.size();
            }
            index++;
        } while (index < transactions.length);
        return 0;
    }

}
