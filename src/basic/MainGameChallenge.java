package basic;

public class MainGameChallenge {
    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 10000;
        int levelCompleted = 8;
        int bonus = 200;
        int finalScore = score;

        if(gameOver){
            finalScore += (levelCompleted * bonus);
            System.out.println("Your final score war " + finalScore);
        }
    }
}
