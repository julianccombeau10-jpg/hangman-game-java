package Hangman;
import javax.swing.JOptionPane;


public class PlayGame {
    static  int gamesWon = 0;
    static int gamesLost = 0;
    public static void main (String [] args){

        /*
        The driver class called PlayGame will call the following methods
        within a do-while loop (use a boolean playAgain variable for loop):
         */

        boolean playAgain;


        do {
            Hangman aGame = new Hangman();
            processGuesses(aGame);
            determineWinner(aGame);
            int response = JOptionPane.showConfirmDialog(
                    null,
                    "Play again",
                    "Hangman",
                    JOptionPane.YES_NO_OPTION
            );

            playAgain = (response == JOptionPane.YES_OPTION);

        } while (playAgain);
        summarize ();

        //Creating my method for processGuesses

    }
    public static void processGuesses(Hangman aGame){

        String secretWord = aGame.getSecretWord();
        String guess = aGame.getUserGuess();

        int secretWordLength = secretWord.length();
        int chances = 3 * secretWordLength;
        int usedChances = 0;
        int loc = -1;

        while (usedChances < chances && !(secretWord.equalsIgnoreCase(guess))) {

            usedChances++;

            //Ask user for a letter

            String input = JOptionPane.showInputDialog(
                    "Current guess " + guess +
                            "\nChances left: " + (chances - usedChances + 1) +
                            "\nEnter a letter:"
            );

            if (input == null) {
                break;
            }
            char useLetter = input.toLowerCase().charAt(0);

            loc = -1;

            do {
                loc = secretWord.indexOf(useLetter, loc + 1);

                if (loc >= 0){
                    //substring before + Letter + substring after
                    guess = guess.substring(0, loc)
                            +useLetter
                            +guess.substring(loc + 1);
                    aGame.setUserGuess(guess);
                }
            } while (loc >= 0);

            JOptionPane.showMessageDialog(null, "Updated guess " + guess);

        }

        // Do- While To find all occurrences

    }
    public static void determineWinner(Hangman aGame){
        if (aGame.getUserGuess().equals(aGame.getSecretWord())){
            JOptionPane.showMessageDialog(null, "You Win!");
            gamesWon++;
        }else {
            JOptionPane.showMessageDialog(null, "You Lost!");
            gamesLost++;
        }
    }
    //Sum all wins and losses
    public static void summarize() {
        JOptionPane.showMessageDialog(
                null,
                "Game Summary:\nWins: " + gamesWon + "\nLosses: " + gamesLost
        );
    }
}
