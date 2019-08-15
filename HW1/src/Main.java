/*
    Project: High Low Game w/ Attitude
    Developer: C2C David J. Thacker
    Date: 20190813
    Class: CS330
 */
import javax.swing.*;
import java.util.Random;
import java.util.Scanner;



public class Main {

    public static void main(String[] args){
        //gameOver acts as a check to reset the game after the user goes through the replay seesion
        Boolean gameOver= false;
        //name holds the users selected (or given) username from the userName() function.
        String name = userName();
        int totalGuesses = 0;
        //numberGames keeps track of the total number of games played and is updated at the end of the if else statement below
        int numberGames = 0;
        //keeps track of total guesses globaly and runs the first session of the game
        totalGuesses = guessingGame(name) + totalGuesses;
        numberGames++;
        while(!gameOver){
            String firstName = JOptionPane.showInputDialog("Would you like to play again " + name);
            firstName.toLowerCase();
            //checks for 'yes' or 'y' and any combination of upper or lower case to replay game
            if(firstName.equalsIgnoreCase("yes") || firstName.equalsIgnoreCase("y")){
                gameOver = false;
                numberGames++;
                totalGuesses = guessingGame(name) + totalGuesses;
            }
            //checks for 'no' or 'n' or any combination of upper or lower case to end the game and redirect to the end
            else if(firstName.equalsIgnoreCase("no") || firstName.equalsIgnoreCase("n")){
                System.out.println("Thank you for playing " + name);
                gameOver = true;
                gameFinish(totalGuesses, numberGames);
                break;
            }
            //User has input something other than yes or no
            else{
                System.out.println("Please Try Again");
            }
        }

    }

    //Conclusion
        //Optimal Number of Guesses for Win (log2(N))
        //4 Distinct Game Over Messages
    private static void gameFinish(int numGuesses, int numberGames){
        //Average Number of Correct Guesses for Win
        double optimalNumber = (Math.log(50) / Math.log(2));
        int average = (numGuesses / numberGames);
        System.out.println("\nIt took you " + average + " guesses on avg to win");
        System.out.println("The optimal number of guesses per game out have been " + optimalNumber);
        //The user achieved a better guess average than the optimal guess strat by 2
        if(optimalNumber - 2 >= average){
            System.out.println("What do you want an award? You must be pretty proud that your random guesses were right.");
        }
        //User achieved a better guess average than the optimal by 1 ish
        else if(optimalNumber - 1 > average){
            System.out.println("Wow you beat the optimal number by one, maybe try harder next time.");
        }
        //User achieved a equal or slightly worse guess average than optimal
        else if(optimalNumber == average || optimalNumber + 1 == average){
            System.out.println("You obviously missed the shoot for the moon land amongst the stars if you're that average");
        }
        //User achieved a worse guess average than optimal by 2 or more
        else{
            System.out.println("Did you not look up how to play this game before hand. Hard to imagine anyone could be off by more than 2 guesses.");
        }
        //Game over message
        System.out.println("The game will now stop");

    }

    //Prompt User for Name
    private static String userName(){
        String name = "";
        String firstName = JOptionPane.showInputDialog("Enter name please");
        //Check for valid input (AKA is it empty?)
        if(firstName.isEmpty()){
            name = "I Guess You Don't Have A Name\n";
            //Welcome the Player to the game
            System.out.print("Hi " + name);
            return name;
        }
        else{
            name = firstName;
            //Welcome the Player to the game
            System.out.print("Hi " + name + "\n");

            return name;
        }
    }

    //PLaying the Game
    private static int guessingGame(String name){
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int guesses = 0;
        //generates a random number between 0 and 50
        int N = rand.nextInt(50);
        //TODO remove the secret number from being printed
        System.out.println(N);
        System.out.println("Please enter a number " + name);
        int guess = 0;

        do {
            //checks to see if the user has input a int or something else
            //TODO .hasNextInt() fails if a non int is inserted
            if(input.hasNextInt()){
                guess = input.nextInt();
                //Validate User Input (Non int or out of range)
                if(guess == N){
                    break;
                }
                //Checks to see if the users guess was outside of the specified range
                if (guess > 50 || guess < 0) {
                    System.out.println("Your guess was out of range.");
                    //Increment Guess Counter
                    System.out.println("Please try again and enter a number");
                    guesses++;
                }
                //Checks to see if the user has guessed above the secret value
                if(guess > N && guess < 50){
                    System.out.println("Your number was 2 high");
                    //Increment Guess Counter
                    System.out.println("Please try again and enter a number");
                    guesses++;
                }
                //checks to see if the user guessed below the secret value
                if(guess < N && guess > 0){
                    System.out.println("Your number was 2 low");
                    //Increment Guess Counter
                    System.out.println("Please try again and enter a number");
                    guesses++;
                }
            }
            else{
                System.out.println("Please input a number");
            }

        }while(guess != N);

        //Increment Guess Counter
        guesses++;
        System.out.println("The correct number was " + N);
        System.out.println("It took you " + guesses + " guesses");

        return guesses;
    }


}
