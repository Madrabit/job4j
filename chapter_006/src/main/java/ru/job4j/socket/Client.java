package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Chat Bot Client.
 *
 * @author madrabit on 03.12.2019
 * @version 1$
 * @since 0.1
 */
@SuppressWarnings("JavaDoc")
public class Client {
    private final Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    /**
     * Starting Client.
     *
     * @throws IOException
     */

    public void start() throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner console = new Scanner(System.in);
        String answer = "";
        //noinspection ConstantConditions
        do {
            out.println(console.nextLine());
            String str = "";
            //noinspection ConstantConditions
            while (!str.isEmpty()) {
                str = in.readLine();
                System.out.println(str);
            }
        } while (!("exit".equals(answer)));
    }

    public static void main(String[] args) {
        try (final Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 5000)) {
            new Client(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
