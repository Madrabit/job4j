package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author madrabit
 * Emulation of command shell
 */
public class Shell {
    /**
     * Current directory
     */
    Path current;
    /**
     * List of sub folders.
     */
    List<Path> subFolders;

    public Shell(Path path) {
        current = path;

        try {
            this.subFolders = Files.walk(current, 2)
                    .filter(Files::isDirectory)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Path getCurrent() {
        return current;
    }

    public void setCurrent(Path current) {
        this.current = current;
    }

    public List<Path> getSubFolders() {
        return subFolders;
    }

    /**
     * Print list of Sub folders
     */
    public void ls() {
        for (Path folder : subFolders) {
            System.out.println(folder);
        }
    }

    /**
     * Change directory
     *
     * @param way cd way
     */
    public void cd(String way) {
        String[] folders = way.split(File.separator);
        for (String folder : folders) {
            if ("..".equals(folder)) {
                setCurrent(current.toAbsolutePath().getParent());
            } else {
                for (Path subFolder : subFolders) {
                    if (subFolder.endsWith(folder)) {
                        setCurrent(current.toAbsolutePath().resolve(folder));
                    }
                }
            }
        }
    }
}
