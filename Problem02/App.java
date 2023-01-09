package com.saimalla.dsajava.lab02.problem02;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import com.saimalla.dsajava.lab02.problem02.services.PaymentProcessorService;

/**
 * App main class for Payment processor services.
 */
public class App {

    private static List<Integer> currencyHolder = new ArrayList<>();

    /**
     * main method for payment processor services.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.print("Enter the size of currency denominations: ");
        int sizeOfCurrencyDenominations = Integer.parseInt(System.console().readLine());
        for (int i = 0; i < sizeOfCurrencyDenominations; i++) {
            System.out.print(String.format("Enter the %s currency denominations value: ", i + 1));
            currencyHolder.add(Integer.parseInt(System.console().readLine()));
            System.out.println();
        }
        System.out.print("Enter the amount you want to pay: ");
        int amountToPay = Integer.parseInt(System.console().readLine());
        SortedMap<Integer, Integer> currencyMap = PaymentProcessorService.loadDenominations(currencyHolder,
                amountToPay);
        SortedMap<Integer, Integer> possibilities = PaymentProcessorService.computeDenominations(currencyMap,
                amountToPay);
        PaymentProcessorService.printDenominations(possibilities);
    }

}
