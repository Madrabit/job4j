package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Chat Bot server.
 *
 * @author madrabit on 03.12.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("JavaDoc")
public class Server {
    private final Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    /**
     * Starting server.
     *
     * @throws IOException
     */

    public void start() throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String ask;
        do {
            System.out.println("wait command ...");
            ask = in.readLine();
            System.out.println(ask);
            if ("hello".equals(ask)) {
                out.println("Hello, dear friend, I'm a oracle.");
            } else if ("what time is it?".equalsIgnoreCase(ask)) {
                out.println(new SimpleDateFormat("HH.mm").format(new Date()));
            } else if ("unsupported ask".equalsIgnoreCase(ask)) {
                out.println("I don't understand");
            }
        } while (!("exit".equals(ask)));
    }

    public static void main(String[] args) {
        try (final Socket socket = new ServerSocket(5000).accept()) {
            new Server(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
