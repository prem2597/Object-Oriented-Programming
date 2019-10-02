/**
 * Clock data type. Write a data type Clock.java that
 * represents time on a 24-hour clock, such as 00:00, 13:30, or
 * 23:59. Time is measured in hours (00–23) and minutes (00–59). 
 * To do so, implement the following public API:
 * 
 * @author Siva Sankar
 */

public class Clock {
    // Creates a clock whose initial time is h hrs and m min.
    /**
     * The parameterised constructor will instatiates the object with the values of
     * the parameters h and m to the respective hrs nad min.
     * @param h
     * @param m
     */
    int h,m;
    public Clock(int h, int m) {
        this.h = h;
        this.m = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.

    public Clock(String s) {
        if (s.length() == 5) {
            String[] c = s.split(":");
            this.h = Integer.parseInt(c[0]);
            this.m = Integer.parseInt(c[1]);
        }
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return String.format("%02d:%02d",h,m);

    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if(this.h==that.h) {
            if (this.m < that.m) {
                return true;
            }
        }
        if(this.h<that.h) {
            return true;
        }
        return false;
    }

    private void check() {
        if(m>59) {
            m=00;
            h++;
        }
        if(h>23) {
            h=00;
        }
        
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        // if (this.m == 59) {
        //     if(this.h == 23) {
        //         this.h = 00;
        //     }
        //     else {
        //         this.h = this.h + 1;
        //     }
        //     this.m = 00;
        // }
        // else {
        //     this.m = this.m +1;
        // }
        toc(1);
        
    }

    // Adds Δ min to the time on this clock.
    public void toc(int delta) {
        // this.m = this.m + delta ;
        // if (this.m > 59) {
        //     this.h = this.h + 1;
        //     int x = this.m % 60;
        //     this.m = x;
        // }
        // if (this.m <= 59) {
        //     this.m = this.m;
        //     this.h = this.h;
        // }
        int i=0;
        while(i<delta) {
            m= m+1;
            check();
            i++;
        }
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock clock = new Clock("13:01");
        clock.toc(660);
        System.out.println(clock);
    }
}