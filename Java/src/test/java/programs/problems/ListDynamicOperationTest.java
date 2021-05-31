package programs.problems;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ListDynamicOperationTest {

    @Test
    public void testApplyDynamicOperation() {

        ArrayList<Integer> al = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6));

        ArrayList<Integer> nl = new ArrayList(Arrays.asList(2, 4, 6, 8, 10, 12));

        List<Integer> pl = ListDynamicOperation.applyDynamicOperation(al, '*', 2);

        assertEquals(nl, pl);
    }
}