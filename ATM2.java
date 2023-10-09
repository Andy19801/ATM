import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double InitialBalance) 
    {
        this.balance = InitialBalance;
    }

    public double getBalance() 
    {
        return balance;
    }

    public void deposit(double amount)
    {
        balance = balance + amount;
    }

    public boolean withdraw(double amount) 
    {
        if (balance >= amount)
        {
            balance = balance - amount;
            return true;
        } else
        {
            return false;
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account)
    {
        this.account = account;
    }

    public void displayMenu()
    {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processOption(int option) 
    {
        Scanner sc = new Scanner(System.in);

        switch (option)
        {
            case 1:
                System.out.println("Your balance is:-  $" + account.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = sc.nextDouble();
                account.deposit(depositAmount);
                System.out.println("Deposit successful.");
                break;
            case 3:
                System.out.print("Enter withdrawal amount: $");
                double withdrawalAmount = sc.nextDouble();
                if (account.withdraw(withdrawalAmount)) 
                {
                    System.out.println("Withdrawal successful.");
                } 
                else
                {
                    System.out.println("Insufficient funds.");
                }
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}

public class ATM2
{
    public static void main(String[] args)
    {
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);

        while (true)
        {
            atm.displayMenu();

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            atm.processOption(choice);
        }
    }
}
