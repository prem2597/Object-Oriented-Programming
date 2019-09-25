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
import java.util.Arrays;
import java.util.Collections; 
public class MiniMaxSum {

    /**
     * This method returns the minimum element in the array.
     * @param arr, contains the elements in arr.
     * @return the minimum element in the arr. If there are no elements, then
     * it should return -1.
     */
    public static int min(int[] arr) {
        //  Your code goes here...

        int minimum = 0;
        if (arr.length<1)
        {
            return -1;
        } 
        else{
            minimum = Collections.min(Arrays.asList(arr));
        }
        return minimum;
    }

    /**
     * This method returns the maximum element in the array.
     * @param arr, contains the elements in arr.
     * @return the maximum element in the arr. If there are no elements, then
     * it should return -1.
     */
    public static int max(int[] arr) {
        //  Your code goes here...
        int maximum = 0;
        if (arr.length<1)
        {
            return -1;
        }
        else
        {
            maximum = Collections.max(Arrays.asList(arr));
        }
        return maximum;
    }

    /**
     * This method returns the sum of all the elements in the array.
     * @param arr, contains the elements in arr.
     * @return the sum of all the elements in the arr. returns -1 if there are
     * no elements.
     */
    public static int sum(int[] arr) {
        //  Your code goes here...
        int sum=0;
        if (arr.length<1)
        {
            return -1;
        }
        else
        {
            for (int i=0;i<arr.length;i++)
            {
                sum = sum + arr[i];
            }
        }
        return sum;
    }

    
    /**
     * Make use of the functions defined for finding the 
     * minimum element, maximum element and the sum of all the elements of teh 
     * array arr.
     * 
     * @param arr, the input array.
     * @return the string version of maxSum and minSum separated by commas.
     */
    public static String miniMaxSum(int[] arr) {
        //  Your code goes here...
        // for (int i = 0; i < arr.length; i++) 
        // {
        //     for (int j=i;j<arr.length;j++)
        //     {
        //         if (arr[i] > arr[j]) 
        //         {
        //             temp = arr[i];
        //             arr[i] = arr[j];
        //             arr[j] = temp;                
        //         }
        //     }
 
        // } 
        String a = (String) (sum(arr) - min(arr)) ;
        String b = (String) (sum(arr) - max(arr)) ;
        String answer =  a+","+b ;
        return answer;
    }
}