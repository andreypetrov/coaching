/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 2014-03-22
 * Time: 11:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class Nesting {


    public int solution(String S) {
        int stackSize = 0; //counts how many

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') stackSize++;
            else stackSize--;

            if (stackSize < 0) return 0;
        }


        return stackSize == 0 ? 1 : 0;
    }

}
