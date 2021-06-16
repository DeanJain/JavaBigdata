package programs.datastructure;

import java.util.LinkedList;
import java.util.List;

public class MinStack {
    private final List<Integer> stack;
    private Integer min = null;

    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int val) {
        if (min == null || val < min)
            min = val;
        stack.add(0, val);
    }

    public void pop() {
        if (!stack.isEmpty())
            stack.remove(0);
    }

    public Integer top() {
        if (stack.isEmpty())
            return null;
        return stack.get(0);
    }

    public int size() {
        return stack.size();
    }

    public Integer getMin() {
        return min;
    }

}
