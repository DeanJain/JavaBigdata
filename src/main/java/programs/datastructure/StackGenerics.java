package programs.datastructure;

import java.util.LinkedList;
import java.util.List;

public class StackGenerics<T> {

    private final List<T> stack = new LinkedList<>();

    public void push(final T element) {
        stack.add(0, element);
    }

    public T pop() {
        if (stack.size() == 0)
            return null;

        return stack.remove(0);
    }

    public int size() {
        return stack.size();
    }


}
