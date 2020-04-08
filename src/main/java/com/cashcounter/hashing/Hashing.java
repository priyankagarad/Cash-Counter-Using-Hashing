package com.cashcounter.hashing;
import java.util.Scanner;
public class Hashing                //created classs
{
    int front;
    int size;
    int hashCode;
    int nextHashCode;
    int array[];
    Hashing()                       //created default constructor
    {
        size=3;
        front=0;
        hashCode=0;
        nextHashCode=0;
        array=new int[3];
    }
    public void put(int data)          //put method for add value in array
    {
        hashCode=data%size;
        if(array[hashCode]==0)
        {
            array[hashCode]=data;
        }
        else
        {
            nextHashCode=((data%size)+1);
            if(array[nextHashCode]==0)
            {
                array[nextHashCode]=data;
            }
        }
    }
    public void remove()                //remove value one by one from array
    {
        int data=array[front];
        front=front+1;
    }
    public void display()              //display method,display key and value
    {
        for(int i=0;i<array.length;i++)
        {
            System.out.println(array[i]+" :"+i);
        }
    }
    public static void main(String args[]) {                // main method
        System.out.println("welcome to Banking Cash Counter");
            /*
            created object of stack class for accessing method of class
            scanner class object created for taking value from user
            1.first ask how many people in line for cash withdraw or deposit
            2.then select choice if user want to 0)Deposit money then press 0
                                                  1)Withdraw money then press 1
             */
        Hashing hash=new Hashing();
        Bank bank=new Bank();
        Scanner sc = new Scanner(System.in);
        System.out.println("how many people in queue");
        int peopleCount = sc.nextInt();
        while (peopleCount > 0)
        {
            peopleCount--;
            System.out.println("enter amount user want");
            int amountWant = sc.nextInt();
            System.out.println("ask for choice");
            System.out.println("0.Deposit money");
            System.out.println("1.withdraw money");
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    hash.put(amountWant);
                    bank.depositAmount(amountWant);
                    hash.remove();
                    break;
                case 1:
                    hash.put(amountWant);
                    bank.withdraw(amountWant);
                    hash.remove();
                    break;
                default:
                    System.out.println("invalid option");
            }
            hash.display();
        }
    }
}



