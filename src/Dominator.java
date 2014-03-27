/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 2014-03-26
 * Time: 11:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class Dominator {


    /**
     * @param args
     */
    public static int getLeaderIndex(int[] input) {
        if (input.length < 1) return -1;

        int size = 1;
        int value = input[0];
        int valueIndex = 0;

        for (int i = 1; i < input.length; i++) {
            if (size == 0) {
                value = input[i];
                valueIndex = i;
                size++;
            } else if (value != input[i]) size--;
            else size++;
        }

        if (size > 0) {
            int candidate = value;
            int candidateCount = 0;
            for (int i = 0; i < input.length; i++) {
                if (input[i] == candidate) candidateCount++;
            }
            if (candidateCount > input.length / 2) return valueIndex;

        }
        return -1;
    }

}
