/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 2014-04-03
 * Time: 11:25 PM
 *
 *
 * Keep max slice minus the min element within that slice
 */
public class MaxDoubleSliceSum {

    public int solution(int[] A) {
        int maxSlice = 0;

        int currentSlice = 0;
        int currentMin = A[1];

        for (int i = 2; i < A.length-1; i++) {
            if(A[i] < currentMin){
                currentSlice = currentSlice + currentMin;
                currentMin = A[i];
            } else {
                currentSlice = currentSlice + A[i];
            }
            currentSlice = Math.max(0, currentSlice);
            maxSlice = Math.max(maxSlice, currentSlice);
        }
        return maxSlice;
    }
}
