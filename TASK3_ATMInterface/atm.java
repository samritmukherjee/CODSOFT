import java.util.*;
class ATMInterface
{
    int bal;

    ATMInterface(int amt)
    {
        bal = amt;
    }

    void dep(int amt)
    {
        bal += amt;
        System.out.println("Amount Deposited: " + amt);
        System.out.println("Current Balance: " + bal);
    }

    void wit(int amt)
    {
        if (amt > bal)
        {
            System.out.println("Insufficient Balance");
        }
        else
        {
            bal -= amt;
            System.out.println("Amount Withdrawn: " + amt);
        }
        System.out.println("Current Balance: " + bal);
    }

    int get_bal()
    {
        return bal;
    }
}

public class atm
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        ATMInterface a = new ATMInterface(5000);
        int ch;

        do
        {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");
            ch = sc.nextInt();

            if (ch == 1)
            {
                System.out.println("Current Balance: " + a.get_bal());
            }
            else if (ch == 2)
            {
                System.out.print("Enter Amount To Deposit: ");
                int amt = sc.nextInt();
                a.dep(amt);
            }
            else if (ch == 3)
            {
                System.out.print("Enter Amount To Withdraw: ");
                int amt = sc.nextInt();
                a.wit(amt);
            }
            else if (ch == 4)
            {
                System.out.println("Thank You For Using ATM. Goodbye!");
            }
            else
            {
                System.out.println("Invalid Input. Please Try Again.");
            }

        } while (ch != 4);

        sc.close();
    }
}