import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;


public class ArrayTransformerTest {
    private ArrayTransformer ar;
    String[] array;

    @Before
    public void setUp() throws Exception {
        ar = new ArrayTransformer();
        array = new String[]{"1,2-4,5-7", "7-10", "8,5"};
    }

    @Test
    public void transformToSequence() {
        int[] expected = ar.transformToSequence(array);

        int[] actual = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void grouping() {
        int[][] arrayOfGroupNumber = ar.grouping(array);
        System.out.println(Arrays.deepToString(arrayOfGroupNumber));
    }
}