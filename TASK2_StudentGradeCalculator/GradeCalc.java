import java.util.*;
public class GradeCalc
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int sub_num = sc.nextInt();

        int tot = 0;

        for (int i = 1; i <= sub_num; i++)
        {
            System.out.print("Enter marks for subject " + i + ": ");
            int m = sc.nextInt();
            tot += m;
        }

        double avg = (double) tot / sub_num;

        String g;

        if (avg >= 90)
        {
            g = "A+";
        }
        else if (avg >= 80)
        {
            g = "A";
        }
        else if (avg >= 70)
        {
            g = "B";
        }
        else if (avg >= 60)
        {
            g = "C";
        }
        else if (avg >= 50)
        {
            g = "D";
        }
        else
        {
            g = "F";
        }

        System.out.println("Total Marks: " + tot);
        System.out.println("Average Percentage: " + avg + "%");
        System.out.println("Grade: " + g);

        sc.close();
    }
}