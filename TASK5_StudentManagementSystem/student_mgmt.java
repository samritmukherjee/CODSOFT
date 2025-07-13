import java.util.*;
import java.io.*;

public class student_mgmt
{
    static ArrayList<student> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws Exception
    {
        // Load data from file if exists
        File f = new File("students.txt");
        if (f.exists())
        {
            Scanner file = new Scanner(f);
            while (file.hasNextLine())
            {
                String line = file.nextLine();
                String[] p = line.split(",");
                if (p.length == 3)
                {
                    list.add(new student(p[0], p[1], p[2]));
                }
            }
            file.close();
        }

        while (true)
        {
            System.out.println("\n1. Add student");
            System.out.println("2. Remove student");
            System.out.println("3. Search student");
            System.out.println("4. Show all");
            System.out.println("5. Save to file");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1)
            {
                System.out.print("Enter name: ");
                String n = sc.nextLine();
                System.out.print("Enter roll: ");
                String r = sc.nextLine();
                System.out.print("Enter grade: ");
                String g = sc.nextLine();
                list.add(new student(n, r, g));
                System.out.println("Student added.");
            }
            else if (ch == 2)
            {
                System.out.print("Enter roll to remove: ");
                String r = sc.nextLine();
                boolean fnd = false;
                for (int i = 0; i < list.size(); i++)
                {
                    if (list.get(i).roll.equals(r))
                    {
                        list.remove(i);
                        System.out.println("Removed.");
                        fnd = true;
                        break;
                    }
                }
                if (!fnd)
                {
                    System.out.println("Student not found.");
                }
            }
            else if (ch == 3)
            {
                System.out.print("Enter roll to search: ");
                String r = sc.nextLine();
                boolean fnd = false;
                for (student s : list)
                {
                    if (s.roll.equals(r))
                    {
                        s.show();
                        fnd = true;
                        break;
                    }
                }
                if (!fnd)
                {
                    System.out.println("Student not found.");
                }
            }
            else if (ch == 4)
            {
                for (student s : list)
                {
                    s.show();
                    System.out.println("------");
                }
                if (list.size() == 0)
                {
                    System.out.println("No data.");
                }
            }
            else if (ch == 5)
            {
                FileWriter w = new FileWriter("students.txt");
                for (student s : list)
                {
                    w.write(s.name + "," + s.roll + "," + s.grade + "\n");
                }
                w.close();
                System.out.println("Saved to students.txt");
            }
            else if (ch == 6)
            {
                System.out.println("Exiting...");
                break;
            }
            else
            {
                System.out.println("Invalid choice.");
            }
        }
    }
}