package ru.job4j.tracker;

/**
 * @author madrabit on 07.08.2019
 * @version 1$
 * @since 0.1
 */
public abstract class BaseAction implements UserAction {

    private final int key;
    private final String name;

    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name =  name;
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

    public abstract void execute(Input input, ITracker tracker);
}
