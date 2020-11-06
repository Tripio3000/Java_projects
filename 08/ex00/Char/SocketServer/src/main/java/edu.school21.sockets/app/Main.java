package edu.school21.sockets.app;

// import edu.school21.sockets.models.*;
// import edu.school21.sockets.repositories.*;

import edu.school21.sockets.server.Server;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String ... args) {
        int port = Integer.parseInt(args[0].split("--port=")[1]);
        Server server = new Server(port);
        server.run();
    }
}