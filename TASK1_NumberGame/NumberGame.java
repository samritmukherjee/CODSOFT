import java.util.*;
public class NumberGame
 {
    public static void main (String args[])
     {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int score=0;
        char replay;
        do{
            int random_num = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guesscheck = false;

            System.out.println("Guess the random number between 1 to 100. (5 Attempts) ");
            while(attempts<5)
             {
                System.out.print("Enter Your Guess: ");
                int guess=sc.nextInt();
                attempts++;

                if (guess == random_num)
                 {
                    System.out.println("Correct!!! You guessed it. Attempts : " + attempts);
                    score++;
                    guesscheck=true;
                    break;
                 }
                else if (guess < random_num)
                 {
                    System.out.println("Too Low!!");
                 }
                else
                 {
                    System.out.println("Too High!!");
                 }
             }

            if (!guesscheck)
             {
                System.out.println("Sorry! The correct number was " + random_num);
             }
           
            System.out.print("Do you want to play again? (Y/N): ");
            replay = sc.next().charAt(0);

        } while (replay == 'y' || replay == 'Y');
        
        System.out.println("Game Over. Your score: " + score);
        sc.close();
    }  
}