package basic;

public class MainGameBuilder {

    int score;
    int levelCompleted;
    int bonus;
    boolean gameOver;

    public MainGameBuilder (Builder builder){
        this.score = builder.score;
        this.levelCompleted = builder.levelCompleted;
        this.bonus = builder.bonus;
        this.gameOver = builder.gameOver;
    }

    /*
    - 각 인자의 의미를 알기 쉽다.
    - setter 메소드가 없으므로 변경 불가능(immutable) 객체를 만들 수 있다.
    - 한 번에 객체를 생성하므로 객체 일관성(consistency)이 깨지지 않는다.
    - build() 메소드에서 잘못된 값이 입력되었는지 검증할 수 있다.
     */
    public static final class Builder{
        private int score;
        private int levelCompleted;
        private int bonus;
        private boolean gameOver;

        public Builder score(int data) {
            score = data;
            return this;
        }
        public Builder levelCompleted(int data) {
            levelCompleted = data;
            return this;
        }
        public Builder bonus(int data) {
            bonus = data;
            return this;
        }
        public Builder gameOver(boolean data) {
            gameOver = data;
            return this;
        }

        public MainGameBuilder build() {
            return new MainGameBuilder(this);
        }
    }
}
