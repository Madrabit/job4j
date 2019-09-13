package ru.job4j.tracker;

import java.util.function.Consumer;

/**
 * @author madrabit on 07.08.2019
 * @version 1$
 * @since 0.1
 */
public abstract class BaseAction implements UserAction {

    private final int key;
    private final String name;
    public final Consumer<String> output;

    protected BaseAction(final int key, final String name, Consumer<String> output) {
        this.key = key;
        this.name =  name;
        this.output =  output;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s : %s", this.key, this.name);
    }

    @Override
    public String infoMenu() {
        return String.format("%s", this.name);
    }
}
