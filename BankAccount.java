public class BankAccount {
    // create the details
    private String name;
    private int pin;
    private double balance;

    public BankAccount(String name){
        this.name = name;
        this.balance = 0;
    }

    public void setPin(int pin){
        this.pin = pin;
    }

    public void deposit(double amount){
        this.balance+=amount;
        System.out.println("Your available balance is "+this.balance);
    }

    public void withdraw(double amount,int pin){
        if (this.pin==pin){
            if (amount<=balance){
                this.balance-=amount;
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






}
