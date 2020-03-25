package ru.job4j.io.minicmd;

import java.util.Stack;

/**
 * @author madrabit
 * Emulation of command shell
 */
public class Shell {

    public Stack<String> folders = new Stack<>();

    public Shell() {
    }

    public Shell cd(String path) {
        if ("/".equals(path)) {
            return this;
        } else {
            if (path.startsWith("//")) {
                folders.clear();
            }
            String[] dirs = path.split("/");
            for (String d : dirs) {
                if ("..".equals(d)) {
                    folders.pop();
                } else if (".".equals(d)) {
                    folders.push(folders.pop());
                } else if (!d.isEmpty()) {
                    folders.push(d);
                }
            }
        }
        return this;
    }

    public String path() {
        String result = folders.size() == 0 ? "/" : "";
        for (String folder : folders) {
            result += "/" + folder;
        }
        return result;
    }
}
