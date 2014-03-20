/**
 * https://codility.com/train/
 * 1. Triangle
 * Determine whether a triangle can be built from a given set of edges.
 * <p/>
 * <p/>
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 2014-03-18
 * Time: 9:26 PM
 * To change this template use File | Settings | File Templates.
 */
// you can also use imports, for example:
// import java.math.*;
class Solution {
    public int solution(int[] A) {
        if (A.length < 3) return 0;

        //Important observation: if a..b..c are not consecutive triangle triplet then there is a triplet a'bc' that is consecutive and for it the triangular rule is true too
        sort(A);
        for (int i = 0; i < A.length - 2; i++) {
            if (isTriange(A[i], A[i + 1], A[i + 2])) return 1;
        }
        return 0;
    }

    public static boolean isTriange(long a, long b, long c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public static void sort(int[] input) {
        if (input == null || input.length == 0) return;
        quicksort(input, 0, input.length - 1);
    }

    public static void quicksort(int[] input, int low, int high) {
        if (low >= high) return;

        int medium = low + (high - low) / 2;
        int pivot = input[medium];
        int i = low;
        int j = high;

        while (i <= j) {
            while (input[i] < pivot) i++;
            while (input[j] > pivot) j--;
            if (i <= j) {
                swap(input, i, j);
                i++;
                j--;
            }
        }
        quicksort(input, i, high);
        quicksort(input, low, j);
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}

