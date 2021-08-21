package model.ball;

public class Ball {
    private final int position;
    private final BaseballNumber number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = new BaseballNumber(number);
    }

    public boolean isEqualNumberInDifferentPosition(Ball otherBall) {
        return this.number.equals(otherBall.number) && this.position != otherBall.position;
    }

    public boolean isEqualNumberInSamePosition(Ball otherBall) {
        return this.number.equals(otherBall.number) && this.position == otherBall.position;
    }
}
