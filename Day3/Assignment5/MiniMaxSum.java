/**
 * Given an array of elements, return the String that has two values separated
 * by commans. The first value is the sum of all the elements except minimum
 * and the second value is the sum of all the elements except the maximum.
 *
 * Input : {1,2,3,4,5};
 * Output : 14,10
 *
 * Input : {1,2}
 * Output : 2,1
 *
 * @author Siva Sankar
 */
public final class MiniMaxSum {

    private MiniMaxSum() {

    }

    /**
     * This method returns the minimum element in the array.
     *
     * @param arr contains the elements in arr.
     * @return the minimum element in the arr. If there are no elements, then it
     *         should return -1.
     */
    public static int min(final int[] arr) {
        // Your code goes here...

        int minimum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (minimum > arr[i]) {
                minimum = arr[i];
            }
        }
        return minimum;
    }

    /**
     * This method returns the maximum element in the array.
     * @param arr contains the elements in arr.
     * @return the maximum element in the arr. If there are no elements, then
     * it should return -1.
     */
    public static int max(final int[] arr) {
        //  Your code goes here...
        int maximum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maximum < arr[i]) {
                maximum = arr[i];
            }
        }
        return maximum;
    }

    /**
     * This method returns the sum of all the elements in the array.
     * @param arr contains the elements in arr.
     * @return the sum of all the elements in the arr. returns -1 if there are
     * no elements.
     */
    public static int sum(final int[] arr) {
        //  Your code goes here...
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    /**
     * Make use of the functions defined for finding the
     * minimum element, maximum element and the sum of all the elements of the
     * array arr.
     *
     * @param arr the input array.
     * @return the string version of maxSum and minSum separated by commas.
     */
    public static String miniMaxSum(final int[] arr) {
        int a = sum(arr) - min(arr);
        int b = sum(arr) - max(arr);
        String answer =  a + "," + b;
        return answer;
    }
}
