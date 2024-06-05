package number.guessing.game;

import javax.swing.JOptionPane;

public class NumberGuessingGame {

    public static void main(String[] args) {
        // Declaration of range bounds
        int min = 1; // The lower bound of the range (inclusive)
        int max = 100; // The upper bound of the range (inclusive)

       
        int guess = 0; // Variable to store user's guess
        int attempts = 8; // Number of attempts allowed
        int score = 528;// Maximum score

        //Call the method for the game to start
        startGame(min, max, guess, attempts, score);
    }

    public static void startGame(int min, int max, int guess, int attempts, int score) {
         // Generate a random number between min and max (inclusive)
        int randomNumber = (int) (Math.random() * ((max - min) + 1)) + min;
        // Main game loop
        do {
            // Prompt the user to enter their guess
            guess = Integer.parseInt(JOptionPane.showInputDialog("Guess the Number Game!\nYou have " + attempts + " attempts remaining.\nEnter a number between " + min + " and " + max + ":"));
            attempts--; // Decrement the number of attempts
            score -= 66; // Decrement the number of points with each attempt

            // Check if the guess is too low
            if (guess < randomNumber) {
                JOptionPane.showMessageDialog(null, "Your guess is too low. Try again! You have " + attempts + " attempts left.");
            } 

            // Check if the guess is too high
            else if (guess > randomNumber) {
                JOptionPane.showMessageDialog(null, "Your guess is too high. Try again! You have " + attempts + " attempts left.");
            } 

            // Check if the guess is correct
            else {
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the correct number: " + randomNumber);
                break; // Exit the loop as the correct number is guessed
            }
            // Check if the user has run out of attempts
            if (attempts == 0) 
            {
                JOptionPane.showMessageDialog(null, "You've run out of attempts! The correct number was " + randomNumber + ".");
                break; // Exit the loop as no attempts are left
            }
        } while (guess != randomNumber); // Continue the loop until the correct number is guessed or attempts are exhausted
        

            //Ask the user if they'd like to add another round
            int response = JOptionPane.showConfirmDialog(null, "Would you like to add another round?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) 
            {
                attempts = 8; //Reset number of attempts
                score += 528;
                //Continue with the game
                startGame(min, max, guess, attempts, score);
            } else 
            {
                JOptionPane.showMessageDialog(null, "Your score is " + score);
            }
    }
}
