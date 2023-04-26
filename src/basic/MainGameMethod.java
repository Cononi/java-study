package basic;

public class MainGameMethod {

    public static void main(String[] args) {
        calculateScore(800, 5, 100, true);
        MainGameBuilder mainGameBuilder = new MainGameBuilder
                .Builder()
                .score(800)
                .levelCompleted(8)
                .bonus(100)
                .gameOver(true)
                .build();
        builderFinalScore(mainGameBuilder);

        System.out.println("Your Builder and Result Final Score War " + builderFinalScoreResult(mainGameBuilder));
    }

    public static int builderFinalScoreResult(MainGameBuilder mainGameBuilder) {
        int finalScore = mainGameBuilder.score;
        if(mainGameBuilder.gameOver){
            finalScore += (mainGameBuilder.levelCompleted * mainGameBuilder.bonus);
        }
        return finalScore;
    }
    public static void builderFinalScore(MainGameBuilder mainGameBuilder) {
        int finalScore = mainGameBuilder.score;
        if(mainGameBuilder.gameOver){
            finalScore += (mainGameBuilder.levelCompleted * mainGameBuilder.bonus);
            System.out.println("Your Builder Final Score War " + finalScore);
        }
    }

    public static void calculateScore(int score, int levelCompleted, int bonus, boolean gameOver) {
        int finalScore = score;
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            System.out.println("Your final score war " + finalScore);
        }
    }
}
