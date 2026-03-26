package Hangman;
import java.util.Random;

public class Hangman {
        /* The domain class called Hangman, will have a
        private String variable called secretWord, and another
        String variable called usersGuess.
         */
        private String secretWord;
        private String userGuess;

        //Create a Constructor with a random generator
        public Hangman () {
            Random myRan = new Random();
            int num = myRan.nextInt(5) + 1;

            if (num == 1){
                secretWord = "blue skies";
            } else if (num ==2){
                secretWord = "java code";
            } else if (num == 3){
                secretWord = "music vibes";
            } else if (num == 4){
                secretWord = "hangman game";
            } else{
                secretWord = "fiu";
            }
            // creating the spaces and underscores to help the user
            userGuess = "";
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == ' ') {
                    userGuess += " ";
                } else {
                    userGuess += "_";
                }

            }

        }
        // creating the getter and setters along with the string

    public String getSecretWord() {
        return secretWord;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    public String getUserGuess() {
        return userGuess;
    }

    public void setUserGuess(String userGuess) {
        this.userGuess = userGuess;
    }

    @Override
    public String toString() {
        return "Hangman{" +
                "secretWord='" + secretWord + '\'' +
                ", userGuess='" + userGuess + '\'' +
                '}';
    }
}

