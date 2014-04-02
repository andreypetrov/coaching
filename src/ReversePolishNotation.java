import java.util.Scanner;
/**
 *
 *
 * A correct tree should always have x-es as leaves only. And all intermediate nodes should be stars.
 *
 *        *
 *    *       *
 *  *   *   *   *
 * x x x x x x x x
 *
 * DepthFirstSearch the tree.
 * When you reach x, backtrack. In the end
 *
 *
 *
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 2014-04-02
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReversePolishNotation {

    private static int[][] cache;

    private static boolean[] visited;
    private static char[] input;

    public static void findEditDistance(Scanner scanner) throws Exception {

        int testCount = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < testCount; i++) {
            input = scanner.nextLine().toCharArray();
            initCache(input.length + 1);
            System.out.println(cost(0, input.length));
        }
    }

    private static void initCache(int length) {
        cache = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                cache[i][j] = -1;
            }
        }

    }

    private static int cost(int i, int j) {
//		System.out.println("i" + i);
//		System.out.println("j" + j);
        if (cache[i][j] >= 0) return cache[i][j];
        if (i + 1 == j) return (input[i] == 'x' ? 0 : 1); // 1 element.
        if (i == j) return 1; // no elements

        int minCost = Integer.MAX_VALUE;


        if (input[j - 1] == '*') { // keep last, costs us nothing
            for (int k = i; k <= j - 1; k++) {
                int currentCost = cost(i, k) + cost(k, j - 1);
                minCost = Math.min(minCost, currentCost);
            }
        } else { // replace
            for (int k = i; k <= j - 1; k++) {
                int currentCost = cost(i, k) + cost(k, j - 1) + 1;
                minCost = Math.min(minCost, currentCost);
            }
        }
        minCost = Math.min(minCost, cost(i, j - 1) + 1); // delete

        for (int k = i+1; k < j; k++) { // insert
            int currentCost = cost(i, k) + cost(k, j) + 1;
            minCost = Math.min(minCost, currentCost);
        }
        cache[i][j] = minCost;
        return minCost;
    }


}
