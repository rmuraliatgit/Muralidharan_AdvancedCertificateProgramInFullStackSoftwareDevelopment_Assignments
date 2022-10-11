package com.payMoney;

import java.util.Scanner;

public class Transaction {

    public static void main(String[] args) throws Exception{

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the Size of com.payMoney.Transaction Array : ");
        int TransactionSize = sc.nextInt();
        if(TransactionSize > 0)
        {
            System.out.println("Enter the Values of Array : ");
            int array[] = new int[TransactionSize];
            for(int i=0;i<TransactionSize;i++)
                array[i] = sc.nextInt();
            System.out.println("Enter the Total no of Targets that needs to be Achieved : ");
            int TargetSize = sc.nextInt();
            while(TargetSize > 0)
            {
                System.out.println("Enter the Value of Target : ");
                int target = sc.nextInt();
                int sum = 0;
                boolean flag = false;
                for(int i=0;i<TransactionSize;i++)
                {
                    sum = sum + array[i];
                    if(sum >= target )
                    {
                        System.out.println("Target Achieved after "+(i+1)+" com.payMoney.Transaction \n");
                        flag = true;
                        break;
                    }
                }
                if(!flag)
                    System.out.println("Given target is not achieved");
                TargetSize--;
            }
        }
        else {
            System.out.println("Please enter transaction size gretaer than 0.");
        }
    }
}