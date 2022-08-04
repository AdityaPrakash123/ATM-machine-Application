import java.util.Scanner;

public class BankAccount {
    // create the details
    private String name;
    private int pin;
    private double balance;
    private double previousTransaction;

    public BankAccount(String name){
        this.name = name;
        this.balance = 0;
    }

    public void setPin(int pin){
        this.pin = pin;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        this.balance+=amount;
        previousTransaction = amount;
        System.out.println("Your available balance is "+this.balance);
    }

    public void withdraw(double amount,int pin){
        if (this.pin==pin){
            if (amount<=balance){
                this.balance-=amount;
                previousTransaction = -amount;
                System.out.println("The available balance is "+this.balance);
            }
            else {
                System.out.println("Insufficient balance available");
            }
        }
        else {
            System.out.println("Incorrect pin entered");
        }

    }

    public void transfer(double amount,BankAccount accountName){
        if (this.balance<amount){
            System.out.println("Transfer fails");
        }
        else {
            this.balance-=amount;
            accountName.balance+=amount;
            System.out.println("The account balance of "+this.name+" is "+this.balance);
            System.out.println("The account balance of "+accountName.name+" is "+accountName.balance);
        }
    }

    public void getPreviousTranscation(){
        if (previousTransaction>0){
            System.out.println("Deposited: "+previousTransaction);
        }
        else if (previousTransaction<0){
            System.out.println("Withdrawn: "+Math.abs(previousTransaction));
        }
        else {
            System.out.println("No previous transaction to show");
        }
    }


    public void showMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome, "+name+"!");
        System.out.println("What would you like to do?");
        System.out.println("A.Check your balance");
        System.out.println("B.Deposit to your account");
        System.out.println("C.Withdraw from your account");
        System.out.println("D.View previous transaction");
        System.out.println("F.Exit");
        char option = 0;
        do {
            System.out.println("Enter the option: ");
            option = sc.next().charAt(0);

            switch (option) {
                case 'A':
                    System.out.println("Your available balance is " + balance);
                    break;
                case 'B':
                    System.out.println("Enter the amount of money to deposit: ");
                    double amount = sc.nextDouble();
                    deposit(amount);
                    break;

                case 'C':
                    System.out.println("Enter the amount of money you would like to withdraw: ");
                    double amount1 = sc.nextDouble();
                    System.out.println("Enter pin: ");
                    int pin = sc.nextInt();
                    withdraw(amount1, pin);

                case 'D':
                    System.out.println("Your previous transaction is: ");
                    getPreviousTranscation();

                case 'E':
                    System.out.println("Successfully exited");
                    break;

                default:
                    System.out.println("Enter a valid character");
                    break;
            }
        }
        while (option!='E');
        System.out.println("Thank you for using our services");
    }








}
