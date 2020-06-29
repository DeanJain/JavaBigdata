package programs.problems;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDynamicOperation {

    /**
     * apply dynamic operation based on passed operation to an input list
     * and returns new list with processed values
     */
    public static List<Integer> applyDynamicOperation(List<Integer> input, char operation, int operand) {

        Iterator it = input.listIterator();
        ArrayList<Integer> processedList = new ArrayList<>(input.size());

        while (it.hasNext()) {
            switch (operation) {
                case '+':
                    processedList.add((int) it.next() + operand);
                    break;
                case '-':
                    processedList.add((int) it.next() - operand);
                    break;
                case '*':
                    processedList.add((int) it.next() * operand);
                    break;
                case '/':
                    processedList.add((int) it.next() / operand);
                    break;
                default:
                    it.next();
                    System.out.println("invalid operation");
                    break;
            }

        }

        return processedList;
    }

}
