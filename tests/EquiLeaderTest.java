import static junit.framework.TestCase.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 2014-04-02
 * Time: 5:30 PM
 * To change this template use File | Settings | File Templates.
 */


public class EquiLeaderTest {
     @org.junit.Test
    public void testSolution() throws Exception {
         EquiLeader equiLeader = new EquiLeader();

         int[] A = {};
         assertEquals(0, equiLeader.solution(A));
    }
}
