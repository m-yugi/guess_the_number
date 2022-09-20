import java.util.Objects;
import java.util.Scanner;
import java.util.Random;
public class guess_the_number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random re = new Random();
        int score = 0, high_score = 0, rounds = 1;
        System.out.println("hello!, welcome to guess the number");
        System.out.println("you will have total 10 moves to guess the number");
        System.out.print("before we start the game please set the highest bound of the numbers from where we can pick a random number: ");
        int high_bound = sc.nextInt();
        System.out.println();
        while (true) {
            System.out.println("*************** round-" + rounds + " *****************");
            int n = re.nextInt(high_bound);
            int limit = 10;
            while (limit > 0) {
                System.out.print("please enter the number you are guessing: ");
                int res = sc.nextInt();
                System.out.println();
                if (res < n) {
                    System.out.println("the number you have entered is smaller then the original one\n");
                    System.out.println("you have " + --limit + " moves left\n");
                } else if (res > n) {
                    System.out.println("the number you have entered is greater then the original one\n");
                    System.out.println("you have " + --limit + " moves left\n");
                } else {
                    System.out.println("yes!, your guess is right congratulations\n");
                    rounds++;
                    score += limit;
                    if (high_score < score) high_score = score;
                    break;
                }
            }
            if (limit != 0) {
                System.out.println("you have scored " + score);
            } else {
                System.out.println("your high_scored is " + high_score);
                System.out.println();
                System.out.println("do you wanna play again\n Yes[y]/no[n]");
                String s = sc.next();
                if (Objects.equals(s, "n")) {
                    System.out.println("thanks for playing the game");
                    break;
                }
                rounds=1;
                score=0;
            }
        }
    }
}
