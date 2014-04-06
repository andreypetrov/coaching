import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 2014-04-03
 * Time: 11:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class MaxDoubleSliceSumTest {
    @Test
     public void testSolution() throws Exception {
        MaxDoubleSliceSum sliceSum = new MaxDoubleSliceSum();

            int[] A = {3, 2, 6, -1, 4, 5, -1, 2};
        int result = sliceSum.solution(A);
        assertEquals(17, result);


    }

    @Test
        public void testSolutionSimple() throws Exception {
        MaxDoubleSliceSum sliceSum = new MaxDoubleSliceSum();

        int[] A = {3, -2, 6, 2};
        int result = sliceSum.solution(A);
        assertEquals(6, result);
    }





    @Test
    public void testSolutionAlterating() throws Exception {
        MaxDoubleSliceSum sliceSum = new MaxDoubleSliceSum();

        int[] A = {-1, 1, -3, 1, -1, 2, -1, 1, -1, 1};
        int result = sliceSum.solution(A);
        assertEquals(3, result);
    }




}
