public class student
{
    String name, roll, grade;

    student(String name, String roll, String grade)
    {
        this.name = name;
        this.roll = roll;
        this.grade = grade;
    }

    void show()
    {
        System.out.println("Name: " + name);
        System.out.println("Roll: " + roll);
        System.out.println("Grade: " + grade);
    }
}