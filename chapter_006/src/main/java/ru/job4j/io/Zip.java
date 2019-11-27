package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author madrabit on 27.11.2019
 * @version 1$
 * @since 0.1
 */
public class Zip {
    /**
     * Searching file.
     *
     * @param root Folder where start searching.
     * @param ext  File extension.
     * @return Searchable file.
     */
    List<File> seekBy(String root, String ext) {
        Search search = new Search();
        return search.filesByOneExtension(root, ext);
    }

    /**
     * Zip files.
     *
     * @param sources List of folders which want to zip.
     * @param target  Target zip file.
     */
    public void pack(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source : sources) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
    public static void main(String[] args) {
        List<File> files = new ArrayList<>(Arrays.asList(new File("./chapter_005/pom.xml")));
        new Zip().pack(files, new File("./chapter_005/pom.zip"));
    }
}
