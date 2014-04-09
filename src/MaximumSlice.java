/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 2014-04-03
 * Time: 11:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class MaximumSlice {


    public static long getMaximumSlice(int[] input) {
        long maxSum = 0;
        long currentSum = 0;

        for (int i = 0; i < input.length; i++) {
            currentSum = Math.max(0, currentSum + input[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
