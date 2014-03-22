/**
 * Time complexity O(n)
 * Space complexity O(n)
 */
public class Beta2010 {


    public int solution(int[] a) {
        int result = 0;

        int[] left = new int[a.length];    //discs left border
        int[] right = new int[a.length];   //discs right border

        for (int i = 0; i < a.length; i++) {
            left[Math.max(0, i - a[i])]++;

            if (a.length - 1 < a[i] || a.length - 1 < i + a[i]) right[a.length - 1]++;  //to avoid int overflow because of the summing of i+a[i]
            else right[i + a[i]]++;

            //right[Math.min(a.length - 1, i + a[i])]++;
        }

        int active = 0;
        for (int i = 0; i < a.length; i++) {
            if (left[i] > 0) {
                result += active * left[i];             // discs starting at i intersect with currently still active discs that started earlier but haven't finished
                result += left[i] * (left[i] - 1) / 2;  //discs starting at i intersect amongst each-other (e.g. 5 discs would intersect 5*4*3*2*1 times)
                active += left[i];
            }
            active -= right[i];
        }


        return result <= 10000000 ?  result : -1;
    }
}