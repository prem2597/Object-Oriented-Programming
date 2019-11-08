import java.util.*;
/**
 * Snake implementation.
 * @author Prem
 */
class Snake {
    private int start;
    private int end;
    public int getStart() {
        return start;
    }
    public void setStart(final int start1) {
        this.start = start1;
    }
    public int getEnd() {
        return end;
    }
    public void setEnd(final int end1) {
        this.end = end1;
    }
    Snake (final int start1, final int end1) {
        this.start = start1;
        this.end = end1;
    }
}