import java.util.*;
import java.net.*;
import java.io.*;

public class currency
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        String[] codes = {"USD", "INR", "EUR", "GBP", "JPY"};
        String from = "", to = "";

        System.out.println("Choose Base Currency:");
        for (int i = 0; i < codes.length; i++)
        {
            System.out.println((i + 1) + ". " + codes[i]);
        }
        System.out.println("6. Other");

        System.out.print("Enter choice (1-6): ");
        int base = sc.nextInt();
        sc.nextLine();

        if (base >= 1 && base <= 5)
        {
            from = codes[base - 1];
        }
        else if (base == 6)
        {
            System.out.print("Enter custom base currency code: ");
            from = sc.nextLine().toUpperCase();
        }
        else
        {
            System.out.println("Invalid base currency selection.");
            sc.close();
            return;
        }

        System.out.println("Choose Target Currency:");
        for (int i = 0; i < codes.length; i++)
        {
            System.out.println((i + 1) + ". " + codes[i]);
        }
        System.out.println("6. Other");

        System.out.print("Enter choice (1-6): ");
        int target = sc.nextInt();
        sc.nextLine();

        if (target >= 1 && target <= 5)
        {
            to = codes[target - 1];
        }
        else if (target == 6)
        {
            System.out.print("Enter custom target currency code: ");
            to = sc.nextLine().toUpperCase();
        }
        else
        {
            System.out.println("Invalid target currency selection.");
            sc.close();
            return;
        }

        System.out.print("Enter amount to convert: ");
        double amt = sc.nextDouble();
        sc.close();

        URI uri = new URI("https://api.exchangerate.host/convert?from=" + from + "&to=" + to + "&amount=" + amt);
        HttpURLConnection con = (HttpURLConnection) uri.toURL().openConnection();
        con.setRequestMethod("GET");

        BufferedReader r = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String l, res = "";

        while ((l = r.readLine()) != null)
        {
            res += l;
        }

        r.close();

        System.out.println("API Response: " + res);

        int i = res.indexOf("\"result\":") + 9;
        int j = res.indexOf("}", i);
        if (i == 8 || j == -1)
        {
            System.out.println("Invalid currency code entered.");
            return;
        }

        String val = res.substring(i, j).trim();
        System.out.println("Converted Amount: " + val + " " + to);
    }
}