package socket;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * @author madrabit on 05.12.2019
 * @version 1$
 * @since 0.1
 */
public class ServerTest {
    private static final String LS = System.getProperty("line.separator");

    private void testServer(String input, String expected) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(
                input.getBytes()
        );
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.start();
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenHelloShouldHelloAnswer() throws IOException {
        this.testServer(Joiner.on(LS).join(
                "hello",
                "exit"),
                Joiner.on(LS).join(
                        "Hello, dear friend, I'm a oracle.",
                        "")
        );
    }

    @Test
    public void whenAskTimeShouldReturnTime() throws IOException {
        this.testServer(Joiner.on(LS).join(
                "what time is it?",
                "exit"),
                Joiner.on(LS).join(
                        new SimpleDateFormat("HH.mm").format(new Date()),
                        "")
        );
    }

    @Test
    public void whenInvalidTextShouldBotDidNotUnderstand() throws IOException {
        this.testServer(Joiner.on(LS).join(
                "unsupported ask",
                "exit"),
                Joiner.on(LS).join(
                        "I don't understand",
                        "")
        );
    }
}
