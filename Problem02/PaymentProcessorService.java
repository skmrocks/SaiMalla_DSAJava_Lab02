package com.saimalla.dsajava.lab02.problem02.services;

import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class PaymentProcessorService {

    private PaymentProcessorService() {
        System.out.println("Payment Processor Service Loaded....");
    }

    public static SortedMap<Integer, Integer> loadDenominations(List<Integer> currencyHolder, int amountToPay) {
        SortedMap<Integer, Integer> currencyMap = new TreeMap<>(Collections.reverseOrder());
        for (Integer item : currencyHolder) {
            if (currencyMap.containsKey(item)) {
                currencyMap.replace(item, currencyMap.get(item), (amountToPay / item) + currencyMap.get(item));
            } else {
                currencyMap.put(item, amountToPay / item);
            }
        }
        return currencyMap;
    }

    public static SortedMap<Integer, Integer> computeDenominations(SortedMap<Integer, Integer> currencyMap,
            int amountToPay) {
        int index = 0;
        int remainder = amountToPay;
        SortedMap<Integer, Integer> possibilities = new TreeMap<>(Collections.reverseOrder());
        List<Integer> keysList = currencyMap.keySet().stream().toList();
        do {
            int availableNoOfNotes = currencyMap.get(keysList.get(index));
            int note = keysList.get(index);
            SortedMap<Integer, Integer> remainderMap = getCurrentRemainder(note, availableNoOfNotes, remainder);
            if (!remainderMap.isEmpty() && remainderMap.firstKey() >= 0) {
                possibilities.put(note, remainderMap.get(remainderMap.firstKey()));
                remainder = remainderMap.firstKey();
            }
            if (remainder == 0) {
                break;
            }
            index++;
        } while (index < keysList.size());
        return possibilities;
    }

    public static void printDenominations(SortedMap<Integer, Integer> possibilities) {
        System.out.println();
        System.out.println("Your payment approach in order to give min no of notes will be:");
        possibilities.forEach(
                (k, v) -> System.out.println(String.format("%s : %s", k, v)));
    }

    private static SortedMap<Integer, Integer> getCurrentRemainder(int notes, int number, int remainder) {
        int count = 0;
        int currentRemainder = remainder;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        do {
            int remainderToMerge = currentRemainder - notes;
            if (remainderToMerge >= 0) {
                currentRemainder = remainderToMerge;
                count++;
            } else {
                break;
            }
        } while (count < number);
        if (count > 0) {
            map.put(currentRemainder, count);
        }
        return map;
    }

}
