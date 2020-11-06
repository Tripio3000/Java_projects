package edu.school21.sockets.app;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class App {
    private static final String HOST = "localhost";

    public static void main(String[] args) {
        int port = Integer.parseInt(args[0].split("--port=")[1]);
        Socket socket = null;
        try {
            socket = new Socket(HOST, port);
            Scanner scan = new Scanner(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

            String str = "";

            String s = scanner.nextLine();
            while (!s.equals("signUp")) {
                s = scanner.nextLine();
            }
            printWriter.println(s);
            while (true) {
                str = scan.nextLine();
                System.out.println(str);
                if (str.equals("Successful!") || str.equals("Incorrect")) {
                    break;
                }
                printWriter.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}