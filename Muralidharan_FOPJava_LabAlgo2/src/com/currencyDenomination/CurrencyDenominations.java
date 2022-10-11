package com.currencyDenomination;

public class CurrencyDenominations {
    public void calculateNotes(int money,int[] currencyDenominations,int sizeOfCurrencyDenomination) {
        if(money == 0)
        {
            System.out.println("No payment approach as the amount to pay is : "+money);
        }
        else {

            System.out.println("Your payment approach in order to give min no of notes will be");
            for( int i = 0; i < sizeOfCurrencyDenomination; i++ ) {
                int noOfNotes = (int) ( money / currencyDenominations[i] );
                if (noOfNotes != 0)
                    System.out.println( currencyDenominations[i] + " : " + noOfNotes );
                money = money - ( noOfNotes * currencyDenominations[i] );
            }
            if(money != 0 ) {
                System.out.println( "Not possible to pay for the rest of the amount : " + money);
            }
        }
    }
}