/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 2014-03-22
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class Sigma2012 {

    public int solution(int[] H) {
        int blocks = 1;
        Stack stack = new Stack(H.length);
        stack.push(H[0]);

        for (int i = 1; i < H.length; i++) {
            if (stack.peek() < H[i]) {
                stack.push(H[i]); //increase of wall height, which adds the need of a new block
                blocks++;
            } else if (stack.peek() > H[i]) {
                while (stack.pop() > H[i]) { //pop elements until you reach lower or equal height
                    if (stack.isEmpty() || stack.peek() < H[i]) { //we reached lower height, so we can push our new height and we need a new block
                        stack.push(H[i]);
                        blocks++;
                        break;
                    } else if (stack.peek() == H[i]) break; //we reached same height, stop loop, no need of new block
                }
            }
        }
        return blocks;
    }

    public class Stack {
        int stack[];
        int nextFree;

        public Stack(int size) {
            nextFree = 0;
            stack = new int[size];
        }

        public int peek() {
            if (isEmpty()) throw new IllegalStateException("Stack is empty");
            return stack[nextFree - 1];
        }

        public boolean isEmpty() {
            return nextFree == 0;
        }

        public boolean isFull() {
            return nextFree == stack.length;
        }

        public void push(int n) {
            if (isFull()) throw new IllegalStateException("Stack if full");

            stack[nextFree] = n;
            nextFree++;
        }

        public int pop() {
            if (isEmpty()) throw new IllegalStateException("Stack is empty");

            nextFree--;
            return stack[nextFree];
        }

    }

}
