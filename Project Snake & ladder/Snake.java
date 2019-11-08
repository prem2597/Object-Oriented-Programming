import java.util.*;
/**
 * Snake implementation.
 * @author Prem
 */
class Snake {
    /**
     * where the snake starts.
     */
    private int start;
    /**
     * where the snake ends.
     */
    private int end;
    /**
     * gets the start values.
     * @return start integer number.
     */
    public int getStart() {
        return start;
    }
    /**
     * sets the value of the snake start.
     * @param start1 sets the value.
     */
    public void setStart(final int start1) {
        this.start = start1;
    }
    /**
     * where the snake ends.
     * @return end of the snake.
     */
    public int getEnd() {
        return end;
    }
    /**
     * sets the end value.
     * @param end1 sets the value.
     */
    public void setEnd(final int end1) {
        this.end = end1;
    }
    /**
     * constructor will start and end the snake.
     * @param start1 starting value.
     * @param end1 ending value.
     */
    Snake (final int start1, final int end1) {
        this.start = start1;
        this.end = end1;
    }
}