package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit
 */
public class ShellTest {
    @Test
    public void whenCdTargetUpTargetCurrentDirectoryTarget() {
        Shell shell = new Shell();
        shell.cd("target/../target");
        System.out.println(shell.getCurrent());
        assertThat(shell.getCurrent().endsWith("target"), is(true));
    }
}
