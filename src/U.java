/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 2014-04-06
 * Time: 7:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class U {

    public static void log(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i].toString() + ", ");
        }
        System.out.println();
    }


    public static void log(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }
}
