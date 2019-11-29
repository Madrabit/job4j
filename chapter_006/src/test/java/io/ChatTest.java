package io;

import org.junit.Test;
import ru.job4j.io.Chat;

/**
 * @author madrabit on 28.11.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
public class ChatTest {
    @SuppressWarnings("StringOperationCanBeSimplified")
    @Test
    public void botTest() {
        String path = "./data/pair_without_comment.properties";
        Chat.Bot bot = new Chat.Bot(path);
        bot.load().toString();
    }
}
