/*
    Project: High Low Game w/ Attitude
    Author: C2C David J. Thacker
    Date: 20190813
    Class: CS330
 */

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;


public class Main {
    private static int MAX_INT = 100;

    public static void main(String[] args) {
        //gameOver acts as a check to reset the game after the user goes through the replay seesion
        Boolean gameOver = false;
        //name holds the users selected (or given) username from the userName() function.
        String name = userName();
        int totalGuesses = 0;
        //numberGames keeps track of the total number of games played and is updated at the end of the if else statement below
        int numberGames = 0;
        //keeps track of total guesses globaly and runs the first session of the game
        totalGuesses = guessingGame(name) + totalGuesses;
        numberGames++;
        while (!gameOver) {
            String firstName = JOptionPane.showInputDialog("Would you like to play again " + name);
            firstName.toLowerCase();
            //checks for 'yes' or 'y' and any combination of upper or lower case to replay game
            if (firstName.equalsIgnoreCase("yes") || firstName.equalsIgnoreCase("y")) {
                gameOver = false;
                numberGames++;
                totalGuesses = guessingGame(name) + totalGuesses;
            }
            //checks for 'no' or 'n' or any combination of upper or lower case to end the game and redirect to the end
            else if (firstName.equalsIgnoreCase("no") || firstName.equalsIgnoreCase("n")) {
                System.out.println("Thank you for playing " + name);
                gameOver = true;
                gameFinish(totalGuesses, numberGames);
                break;
            }
            //User has input something other than yes or no
            else {
                System.out.println("Please Try Again");
            }
        }

    }

    //Conclusion
    //Optimal Number of Guesses for Win (log2(N))
    //4 Distinct Game Over Messages
    private static void gameFinish(int numGuesses, int numberGames) {
        //Average Number of Correct Guesses for Win
        double optimalNumber = (Math.log(MAX_INT) / Math.log(2));
        int average = (numGuesses / numberGames);
        System.out.println("\nIt took you " + average + " guesses on avg to win");
        System.out.println("The optimal number of guesses per game out have been " + optimalNumber);
        //The user achieved a better guess average than the optimal guess strat by 2
        if (optimalNumber - 2 >= average) {
            System.out.println("What do you want an award? You must be pretty proud that your random guesses were right.");
        }
        //User achieved a better guess average than the optimal by 1 ish
        else if (optimalNumber - 1 > average) {
            System.out.println("Wow you beat the optimal number by one, maybe try harder next time.");
        }
        //User achieved a equal or slightly worse guess average than optimal
        else if (optimalNumber == average || optimalNumber + 1 == average) {
            System.out.println("You obviously missed the shoot for the moon land amongst the stars if you're that average");
        }
        //User achieved a worse guess average than optimal by 2 or more
        else {
            System.out.println("Did you not look up how to play this game before hand. Hard to imagine anyone could be off by more than 2 guesses.");
        }
        //Game over message
        System.out.println("The game will now stop");

    }

    //Prompt User for Name
    private static String userName() {
        String name = "";
        String firstName = JOptionPane.showInputDialog("Enter name please");
        //Check for valid input (AKA is it empty?)
        if (firstName.isEmpty()) {
            name = "I Guess You Don't Have A Name\n";
            //Welcome the Player to the game
            System.out.print("Hi " + name);
            return name;
        } else {
            name = firstName;
            //Welcome the Player to the game
            System.out.print("Hi " + name + "\n");

            return name;
        }
    }

    //PLaying the Game
    private static int guessingGame(String name) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int guesses = 0;
        //generates a random number between 0 and 50
        int N = rand.nextInt(MAX_INT);
        System.out.println(N);
        System.out.println("Please enter a number " + name);
        int guess = 0;
        int maxGuess = 0;
        int minGuess = MAX_INT;
        boolean loopThrough = false;

        do {
            if (input.hasNextInt()) {
                guess = input.nextInt();
                if (guess == N) {
                    break;
                }
                if(guess > maxGuess && !loopThrough){
                    maxGuess = guess;
                }
                if(guess < minGuess && !loopThrough){
                    minGuess = guess;
                }
            }
            //Checks to see if the users guess was outside of the specified range
            if((guess > maxGuess || guess < minGuess) && loopThrough){
                if (guess > maxGuess && guess > N) {
                    System.out.println("Did you seriously guess something higher after I told you to go lower?");
                    //Increment Guess Counter
                    System.out.println("Please try again and enter a number");
                    guesses++;
                }
                if (guess < minGuess && guess < N) {
                    System.out.println("Did you seriously guess something lower after I told you to go higher?");
                    //Increment Guess Counter
                    System.out.println("Please try again and enter a number");
                    guesses++;
                }
            }
            else {

                if (guess > MAX_INT || guess < 1) {
                    System.out.println("Your guess was out of range.");
                    //Increment Guess Counter
                    System.out.println("Please try again and enter a number");
                    guesses++;
                }
                //Checks to see if the user has guessed above the secret value
                else if (guess > N && guess < MAX_INT) {
                    System.out.println("Your number was 2 high");
                    //Increment Guess Counter
                    System.out.println("Please try again and enter a number");
                    guesses++;
                    loopThrough = true;
                }
                //checks to see if the user guessed below the secret value
                else if (guess < N && guess > 1) {
                    System.out.println("Your number was 2 low");
                    //Increment Guess Counter
                    System.out.println("Please try again and enter a number");
                    guesses++;
                    loopThrough = true;
                } else {
                    input.nextLine();
                    System.out.println("Please input a number");
                }
            }
        } while (guess != N);

        //Increment Guess Counter
        guesses++;
        System.out.println("The correct number was " + N);
        System.out.println("It took you " + guesses + " guesses");

        return guesses;
    }


}
