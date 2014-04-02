/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 2014-04-02
 * Time: 5:22 PM
 * <p/>
 * <p/>
 * The leader of two subarrays can be only the same leader as for the whole array.
 * First we find the leader.
 * Then starting from the first element check on every index if the array before and the array after have more leaders than anything else.
 * If yes, increment the equiLeaders count.
 * <p/>
 * O(n) time, O(1) space
 */
public class EquiLeader {
    public int leaderIndex;
    public int leaderCount;
    public int leader;


    public int solution(int[] A) {
        if (!findLeaderIndex(A)) return 0;
        int runningLeaderCount = 0;
        int equiLeaderCount = 0;

        for (int i = 0; i < A.length-1; i++) {
            if (A[i] == leader) runningLeaderCount++;
            if (runningLeaderCount > (i + 1) / 2 && leaderCount - runningLeaderCount > (A.length - i - 1) / 2) equiLeaderCount++;
        }

        return equiLeaderCount;
    }


    public boolean findLeaderIndex(int[] input) {
        int stackSize = 1;

        int stackValueIndex = 0;
        int stackValue = input[0];
        for (int i = 1; i < input.length; i++) {
            if (stackSize == 0) {
                stackValue = input[i];
                stackValueIndex = i;
                stackSize++;
            } else if (input[i] == stackValue) stackSize++;
            else stackSize--;
        }

        if (stackSize > 0) {
            int candidate = stackValue;
            int candidateCount = 0;
            for (int i = 0; i < input.length; i++) {
                if (input[i] == candidate) candidateCount++;
            }
            if (candidateCount > input.length / 2) {
                leaderIndex = stackValueIndex;
                leaderCount = candidateCount;
                leader = candidate;
                return true;
            }
        }
        return false;
    }
}
