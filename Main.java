import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double balance = 2500.75;
        int password = 1234;
        byte choice;
        System.out.println("==== Welcome To Our Bank ====");
        System.out.println("Please Enter Your Name: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        int passInput;
        byte attempts = 0;
        //Password Validation
        do {
            System.out.println("Please Enter Your Password: ");
            passInput = input.nextInt();
            if (passInput != password) {
                System.out.println("Wrong Password");
                attempts++;
                if(attempts == 3) {
                    System.out.println("Your account is locked");
                    System.exit(0);
                }
            } else {
                System.out.println(" Welcome " + name);
            }
        }while(passInput != password);

        do{
        System.out.println("Your balance is " + balance);
        System.out.println("1- Withdraw ");
        System.out.println("2- Deposit");
        System.out.println("3- Transfer");
        System.out.println("4- Exit");
        System.out.println("Please Enter Your Choice: ");
        choice= input.nextByte();

        switch(choice){
            case 1:
                System.out.println("How much do you want to withdraw?");
                double amount = input.nextInt();
                if(amount > balance) {
                    System.out.println("You have not enough money");
                }
                else {
                    double remaining = balance - amount;
                    System.out.println("You have " + amount + " withdrawn");
                    System.out.println("Your balance is " + remaining);
                    balance = remaining;
                    System.out.println("=======================");
                }
                break;
            case 2:
                System.out.println("How much do you want to deposit?");
                double depositAmount = input.nextInt();
                if (depositAmount <=0){
                    System.out.println("Invalid Amount");
                }else {
                    double newBalance = balance + depositAmount;
                    System.out.println("You have deposited " + depositAmount);
                    System.out.println("Your new balance is " + newBalance);
                    balance = newBalance;
                }
                System.out.println("======================");
                break;
            case 3:
                System.out.println("How much do you want to transfer?");
                double transferAmount = input.nextInt();
                if(transferAmount > balance) {
                    System.out.println("You have not enough money Please Enter a different amount: ");
                }else{

                    double remainingAmount = balance - transferAmount;
                    System.out.println("You have transferred " + transferAmount);
                    System.out.println("Your new balance is " + remainingAmount);
                    balance = remainingAmount;
                    System.out.println("====================");
                }
                break;
            case 4:
                System.out.println("Thank you for using our bank");
                break;
            default:
                System.out.println("Invalid Choice");
        }

        }while(choice != 4);



    }
}