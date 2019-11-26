package io;

import org.junit.Test;
import ru.job4j.io.Config;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author madrabit on 25.11.2019
 * @version 1$
 * @since 0.1
 */
public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("John Smith")
        );
    }
}
