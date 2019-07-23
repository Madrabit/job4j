package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * @author madrabit on 22.07.19
 * @version 1$
 * @since 0.1
 */
public class MergeTest {

    @Test
    public void whenTwoArraysThenMergeIntoOne() {
        Merge merge = new Merge();
        int[] result = merge.merge(new int[] {1, 2}, new int[] {3, 4});
        int[] expected = new int[] {1, 2, 3, 4};
        assertThat(result, is(expected));
    }

    @Test
    public void whenTwoArraysThenMergeIntoOne2() {
        Merge merge = new Merge();
        int[] result = merge.merge(new int[] {5, 6, 7}, new int[] {2, 3, 4});
        int[] expected = new int[] {2, 3, 4, 5, 6, 7};
        assertThat(result, is(expected));
    }

    @Test
    public void whenTwoArraysThenMergeIntoOne3() {
        Merge merge = new Merge();
        int[] result = merge.merge(new int[] {5, 6, 7, 8, 9, 10}, new int[] {2, 3});
        int[] expected = new int[] {2, 3, 5, 6, 7, 8, 9, 10};
        assertThat(result, is(expected));
    }
}
