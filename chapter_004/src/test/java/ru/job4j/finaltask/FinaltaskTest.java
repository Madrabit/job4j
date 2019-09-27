package ru.job4j.finaltask;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class FinaltaskTest {
    @Test
    public void whenArray1234ThenInt20() {
        int[] arr = {1, 2, 3, 4};
        Finaltask finaltask = new Finaltask();
        int result = finaltask.convert(arr);
        int expected = 20;
        assertThat(expected, is(result));
    }
}
