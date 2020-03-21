package ru.job4j.io;

import org.junit.Test;
import ru.job4j.io.minicmd.Shell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit
 */
public class ShellTest {

    @Test
    public void whenCdTargetUpTargetCurrentDirectoryTarget() {
        final Shell shell = new Shell();
        assert shell.path().equals("/");

        shell.cd("/");
        assert shell.path().equals("/");

        shell.cd("usr/..");
        assertEquals("/",  shell.path());

        shell.cd("usr").cd("local");
        shell.cd("../local").cd("./");
        assertEquals("/usr/local", shell.path());

        shell.cd("..");
        assert shell.path().equals("/usr");

        shell.cd("//lib///");
        assertEquals("/lib", shell.path());
    }
}
