package com.currencyDenomination;

import java.util.Scanner;

public class DriverClass {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Size of Currency Denominations :");
        int size = scanner.nextInt();
        int currencyDenominations[] = new int[size];
        System.out.println("Enter the Currency Denominations Value : ");
        for(int i=0;i<size;i++) {
            currencyDenominations[i] = scanner.nextInt();
            if(currencyDenominations[i] == 0) {
                System.out.println("Please enter the denomination other than 0!");
                i--;
            }
        }
        System.out.println("Enter the Amount you want to Pay : ");
        int amount=scanner.nextInt();
        MergeSort sort = new MergeSort();
        sort.mergesort(currencyDenominations,0,size-1);
        CurrencyDenominations denominations = new CurrencyDenominations();
        denominations.calculateNotes(amount,currencyDenominations,size);
        scanner.close();

    }

}