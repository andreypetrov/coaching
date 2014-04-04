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

    public int solution(int[] A) {
        int candidateIndex = findCandidateIndex(A);
        int candidate = A[candidateIndex];
        int candidateCount = 0;
        if (candidateIndex == -1) return 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) candidateCount++;
        }

        int equiLeaderCount = 0;

        if (candidateCount > A.length / 2) {   //he is a real leader
             int runningLeaderCount = 0;
             for (int i = 0; i < A.length-1; i++) {
                if (A[i] == candidate) runningLeaderCount++;
                if (runningLeaderCount > (i + 1) / 2 && candidateCount - runningLeaderCount > (A.length - i - 1) / 2) equiLeaderCount++;
            }
        }
        return equiLeaderCount;
    }


    public int findCandidateIndex(int[] input) {
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

        if (stackSize > 0) return stackValueIndex;
        else return -1;
    }
}
