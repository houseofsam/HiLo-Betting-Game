/**
 *Sameer Mohamed
 *HiLoSameerBet
 *A Hi-lo betting/guessing game (Modified W/out Cards)
 *Wednesday, May 28, 2014
 */

//class
public class HiLoSameerBet {
    //main method
    public static void main(String[] args) {
        //variables
        char playagain;
        String name; //user name

        //Pre-game/post-game code
        System.out.println("Hi there! Welcome to Modified Hi-Lo! What is your name?"); //greeting
        name = In.getString();
        System.out.println("Have fun, " + name + "!");
        lineBreak(); //prints a row of asteriks to break off first screen
        clearScreen(); //prints 4 blank lines
        System.out.println("Would you like too see the game instructions? (Please enter 'y'/'n')");
        char Instructions = In.getChar();
        if (Instructions == 'y') {
            lineBreak();
            UserGuide();
            lineBreak();
        } else {
            lineBreak();
            clearScreen();
        }

        Game();

        lineBreak();
        clearScreen();
        System.out.println("Would you like to play another NEW game, " + name + "? (y/n)"); //request to play again
        playagain = In.getChar();

        //if player wants to play again
        if (playagain == 'y') {
            clearScreen();
            clearScreen();
            Game();
        }
        //if player does NOT want to play again
        else if (playagain == 'n') {
            System.out.println();
            System.out.println("It's okay " + name + ", maybe next time! ;)");
        } else {
            System.out.println("Invalid Input!");
        }

        clearScreen();
        System.out.println("Thank you for playing, " + name + "! Goodbye! :)");
        System.out.println();
        System.out.println("If you liked my game, feedback will be greatly appreciated");
        System.out.println("Please send your feedback to sameerm1997@gmail.com");
        System.out.println();
        System.out.println("I am also kindly accepting donations ;) ---> Paypal: c4explo@hotmail.com");

    }


    //clear screen method
    public static void clearScreen() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }


    public static void lineBreak() {
        int row;
        int column;

        for (row = 1; row <= 1; row++) //row
        {
            for (column = 1; column <= 80; column++) //column
            {
                System.out.print("*"); //prints asteriks
            }

            System.out.println(); // new line
        }
    }


    //Rules Method
    public static void UserGuide() {
        System.out.println();
        System.out.println("How to play:");
        System.out.println("--------------------");
        System.out.println("Before each round starts, you will be opted to place a bet");
        System.out.println();
        System.out.println("A number between 0-15 will be displayed and you will have to guess");
        System.out.println("whether it will be higher (a), lower (b) or the same (c).");
        System.out.println();
        System.out.println("For each correct answer, you will gain money with respect to the amount of your bet");
        System.out.println();
        System.out.println("Due to the low chances of the next number being the same, if you were to guess");
        System.out.println("that the next number will be the same and you happen to be correct, you will gain");
        System.out.println("4X the amount you bet!");
        System.out.println();
        System.out.println("If you get an answer wrong or enter an invalid answer, you will lose the money you");
        System.out.println("placed in the bet but the game will continue.");
        System.out.println();
        System.out.println("Game will end when player decides to stop playing or when player goes down to $0.");
        System.out.println();
        System.out.println("With that being said... Good luck!");
        System.out.println();
    }


    //Game method
    public static void Game() {
        //initial variables
        boolean tf = true; //<----- loop
        int money = 20; //<---- counter

        //game while loop
        while (money > 0 && tf == true) {

            //Number Generator Variables & Array Declared
            int RandomNum = ((int)(16 * Math.random()));
            int array[] = new int[16];

            //For statement for index/array
            for (int i = 0; i < 16; i++) {
                array[i] = i;
            }

            //random number chosen from array
            int num = array[RandomNum];

            //initial score (money) output
            System.out.println("--------------->     Money: $" + money + "     <---------------");

            //Start of game ---> Number is printed & asks user if "Next" number will be greater or lesser
            System.out.println("How much would you like to bet on this round?");
            System.out.print("$");
            int bet = In.getInt();

            //betting loop... if you enter an invalid integer
            while (bet < 0 || bet > money) {
                System.out.println("Please enter a valid bet with a positive integer value");
                bet = In.getInt(); //bug: when user does not enter an integer
            }

            System.out.println();
            System.out.println("(From 0-15) Will the next number be higher or lower than: [" + num + "]");
            System.out.println("(a) = higher");
            System.out.println("(b) = lower");
            System.out.println("(c) = same");
            char answer = In.getChar();
            System.out.println();



            //Number generator for "Next" number / output
            int RandomNum2 = ((int)(16 * Math.random()));
            System.out.println("The next number is... " + RandomNum2 + "!");

            //if statements for different situations depending on user response/input
            //If user inputs "a" (greater) and is correct
            if (answer == 'a' && RandomNum <= RandomNum2) {
                System.out.println();
                System.out.println("You are correct!");
                money = money + bet;
                System.out.println("You gain $" + bet + "! :D");
                System.out.println();
                System.out.println("--------------->     Money: $" + money + "     <---------------");
                System.out.println();
                System.out.println("Would you like to play another round? (y/n)");
                char nextround = In.getChar();
                System.out.println();

                if (nextround == 'y') {
                    tf = true;
                } else if (nextround == 'n') {
                    System.out.println("Game over! You've finished with $" + money + "! Wow!");
                    tf = false; //ends loop
                } else {
                    System.out.println("Invalid input! Please enter either 'y' or 'n'");
                    nextround = In.getChar();
                    if (nextround == 'y') {
                        tf = true;
                    } else if (nextround == 'n') {
                        System.out.println("Game over! You've finished with $" + money + "! Wow!");
                        tf = false; //ends loop
                    } else {
                        System.out.println("Invalid input!!!!!!! Game over. Follow instructions next time!");
                        tf = false;
                    }
                }
            }
            //If user inputs "b" (lesser) and is correct
            else if (answer == 'b' && RandomNum >= RandomNum2) {
                System.out.println();
                System.out.println("You are correct!");
                money = money + bet;
                System.out.println("You gain $" + bet + "! :D");
                System.out.println();
                System.out.println("--------------->     Money: $" + money + "     <---------------");
                System.out.println();
                System.out.println("Would you like to play another round? (y/n)");
                char nextround = In.getChar();
                System.out.println();
                if (nextround == 'y') {
                    tf = true;
                } else if (nextround == 'n') {
                    System.out.println("Game over! You've finished with $" + money + "! Wow!");
                    tf = false; //ends loop
                } else {
                    System.out.println("Invalid input! Please enter either 'y' or 'n'");
                    nextround = In.getChar();
                    if (nextround == 'y') {
                        tf = true;
                    } else if (nextround == 'n') {
                        System.out.println("Game over! You've finished with $" + money + "! Wow!");
                        tf = false; //ends loop
                    } else {
                        System.out.println("Invalid input!!!!!!! Game over. Follow instructions next time!");
                        tf = false;
                    }
                }
            }
            //If user inputs "c" (same) and is correct
            else if (answer == 'c' && RandomNum == RandomNum2) {
                System.out.println();
                System.out.println("You are correct!");
                money = ((money + bet) * 4);
                System.out.println("You gain $" + bet + "! :D");
                System.out.println();
                System.out.println("--------------->     Money: $" + money + "     <---------------");
                System.out.println();
                System.out.println("Would you like to play another round? (y/n)");
                char nextround = In.getChar();
                System.out.println();
                if (nextround == 'y') {
                    tf = true;
                } else if (nextround == 'n') {
                    System.out.println("Game over! You've finished with $" + money + "! Wow!");
                    tf = false; //ends loop
                } else {
                    System.out.println("Invalid input! Please enter either 'y' or 'n'");
                    nextround = In.getChar();
                    if (nextround == 'y') {
                        tf = true;
                    } else if (nextround == 'n') {
                        System.out.println("Game over! You've finished with $" + money + "! Wow!");
                        tf = false; //ends loop
                    } else {
                        System.out.println("Invalid input!!!!!!! Game over. Follow instructions next time!");
                        tf = false;
                    }
                }
            }
            //If user is wrong or inputs any other letter than the first 3
            else {
                System.out.println();
                System.out.println("You're wrong! :(");
                money = money - bet;
                System.out.println("You lose $" + bet + "! :/");
                System.out.println();
                System.out.println("--------------->     Money: $" + money + "     <---------------");
                System.out.println();
                if (money > 0) {
                    System.out.println("Would you like to play another round? (y/n)");
                    char nextround = In.getChar();
                    System.out.println();

                    if (nextround == 'y') {
                        tf = true;
                    } else if (nextround == 'n') {
                        System.out.println("Game over! You've finished with $" + money + "! Wow!");
                        tf = false; //ends loop
                    } else {
                        System.out.println("Invalid input! Please enter either 'y' or 'n'");
                        nextround = In.getChar();
                        if (nextround == 'y') {
                            tf = true;
                        } else if (nextround == 'n') {
                            System.out.println("Game over! You've finished with $" + money + "! Wow!");
                            tf = false; //ends loop
                        } else {
                            System.out.println("Invalid input!!!!!!! Game over. Follow instructions next time!");
                            tf = false;
                        }
                    }
                } else {
                    System.out.println();
                    System.out.println("Game over! You've finished with $" + money + "! :("); //If player goes broke
                }
            }
        }
    }
}
//End Code