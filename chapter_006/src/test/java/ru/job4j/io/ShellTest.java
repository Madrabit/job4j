package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit
 */
public class ShellTest {
    private Path root;

    @Before
    public void createFilesStructure() throws IOException {
        root = Files.createTempDirectory(System.getProperty("tmpdir"));
        Path target = Files.createDirectory(Paths.get(root + "/target"));
    }

    @Test
    public void whenCdTargetUpTargetCurrentDirectoryTarget() {
        Shell shell = new Shell(root);
        shell.cd("target/../target");
        System.out.println(shell.getCurrent());
        assertThat(shell.getCurrent().endsWith("target"), is(true));
    }
}
