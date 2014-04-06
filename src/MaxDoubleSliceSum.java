/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 2014-04-03
 * Time: 11:25 PM
 * Use the idea from http://en.wikipedia.org/wiki/Maximum_subarray_problem
 * http://stackoverflow.com/questions/20660989/max-double-slice-sum
 *
 */
public class MaxDoubleSliceSum {

    public int solution(int[] A) {
        int[] maxEndingHere = maxEndingHere(A);
        int[] maxStartingHere = maxStartingHere(A);
        int maxSlice = 0;
        for (int i = 1; i < A.length-1;i++) {
          maxSlice = Math.max(maxSlice, maxEndingHere[i-1]+maxStartingHere[i+1]);
        }
        return maxSlice;
    }


    /**
     * Precalculate ending subarrays. Take into account that first and last element are always 0
     * @param input
     * @return
     */
    public static int[] maxEndingHere(int[] input) {
        int[] result = new int[input.length];
        result[0] = result[input.length-1] = 0;
        for (int i = 1; i < input.length-1; i++) {
            result[i] = Math.max(0, result[i-1] + input[i]);
        }
        return result;
    }

    /**
     * Precalculate starting subarrays. Take into account that first and last element are always 0
     * @param input
     * @return
     */
    public static int[] maxStartingHere(int[] input) {
        int[] result = new int[input.length];
        result[0] = result[input.length-1] = 0;
        for (int i = input.length-2; i >= 1; i--) {
            result[i] = Math.max(0, result[i+1] + input[i]);
        }
        return result;
    }
}
