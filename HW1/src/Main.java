/**
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

    /**
     * Function Name: main()
     * @param args The terminal args
     */
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

    /**
     * Function Name: gameFinish()
     * @param numberGames The total number of games played in this instance of the game
     * @param numGuesses The total number of guesses made across all games in this instance
     * Return: N/A
     */
    public static void gameFinish(int numGuesses, int numberGames)
    {
        //Average Number of Correct Guesses for Win
        double optimalNumber = (Math.log(MAX_INT) / Math.log(2));
        int average = (numGuesses / numberGames);
        System.out.println("\nIt took you " + average + " guesses on avg to win");
        System.out.printf("The optimal number of guesses per game out have been %.2f %n", optimalNumber);
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

    /**
     * Function Name: userName()
     * Parameters: N/A
     * @return name The users selected or assigned name.
     */
    public static String userName()
    {
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

    /**
     * Function Name: randomNumber()
     * Parameters: N/A
     * @return N The random number generated from the system time.
     */
    public static int randomNumber()
    {
        Random rand = new Random();
        //generates a random number between 0 and 50
        int N = rand.nextInt(MAX_INT) + 1;
        return N;
    }

    /**
     * Function Name: guessingGame()
     * @param name The user name selected or assigned to the user.
     * @return guesses The total number of guesses made in that instance of the game.
     */
    public static int guessingGame(String name)
    {
        int randNum = randomNumber();
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number " + name);

        int guess = 0;

        int maxGuess = 0;
        boolean maxGuessBool = false;
        int minGuess = MAX_INT;
        boolean minGuessBool = false;
        int guesses = 0;
        do {
            if (input.hasNextInt()) {
                guess = input.nextInt();
                if (guess < randNum && guess > 1) {
                    if (guess <= minGuess) {
                        if (!minGuessBool) {
                            minGuessBool = true;
                            minGuess = guess;
                            System.out.println("That guess was 2 low");
                            guesses++;
                            System.out.println("Please input a number");
                        } else {
                            minGuess = guess;
                            System.out.println("Did you seriously input something lower than something that I already told you was low?\nTry something higher than " + minGuess);
                            guesses++;
                            System.out.println("Please input a number");
                        }
                    }
                } else if (guess < 1) {
                    System.out.println("You're gonna wanna reel that number back closer to between 1 and " + MAX_INT);
                    guesses++;
                    System.out.println("Please input a number");
                } else if (guess < randNum) {
                    System.out.println("That guess was 2 low");
                    guesses++;
                    System.out.println("Please input a number");

                }
                if (guess > randNum && guess < MAX_INT) {
                    if (guess >= maxGuess) {
                        if (!maxGuessBool) {
                            maxGuessBool = true;
                            maxGuess = guess;
                            System.out.println("That guess was 2 high");
                            guesses++;
                            System.out.println("Please input a number");
                        } else {
                            maxGuess = guess;
                            System.out.println("Did you seriously input something higher than something that I already told you was high?\n Try something lower than " + maxGuess);
                            guesses++;
                            System.out.println("Please input a number");
                        }

                    }
                } else if (guess > MAX_INT) {
                    System.out.println("You're gonna wanna reel that number back closer to between 1 and " + MAX_INT);
                    guesses++;
                    System.out.println("Please input a number");
                } else if (guess > randNum) {
                    System.out.println("That guess was 2 high");
                    guesses++;
                    System.out.println("Please input a number");
                }
            } else {
                input.nextLine();
                System.out.println("Please input a number between 1 and " + MAX_INT);
            }

        } while (guess != randNum);

        //Increment Guess Counter
        guesses++;
        System.out.println("The correct number was " + randNum);
        System.out.println("It took you " + guesses + " guesses");

        return guesses;
    }
}
