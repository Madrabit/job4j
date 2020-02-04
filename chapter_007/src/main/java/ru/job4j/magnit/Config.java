package ru.job4j.magnit;

import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

/**
 * @author madrabit
 * Database properties.
 */
public class Config {
    /**
     * Values of DB properties.
     */
    private final Properties values = new Properties();

    /**
     * Create config getting props from resources.
     */
    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("magnit.properties")) {
            values.load(Objects.requireNonNull(in));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }
}
