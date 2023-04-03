package basic;

public class IfAndThen {
    public static void main(String[] args) {
        boolean isAlien = false;
        if(!isAlien) {
            System.out.println("It is not and alien!");
        }

        int score = 100;
        // 100과 같다면
        if(score == 100) {
            System.out.println("You got the high score!");
        }
        // 100과 같거나 그 이상
        if(score >= 100) {
            System.out.println("You got the high score!");
        }
        // 100 보다 작거나 같다면
        if(score <= 100) {
            System.out.println("You got the high score!");
        }

        if(score > 100 && score != 100){
            System.out.println("You got the high score!");
        }

        if(score > 100 || score != 100){
            System.out.println("You got the high score!");
        }

        boolean isCar = false;
        if(isCar = true){
            System.out.println("This is not supposed to happen");
        }
        if(isCar){
            System.out.println("This is not supposed to happen");
        }

        String name = isCar ? "hong" : "woo";
    }
}
