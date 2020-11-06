package edu.school21.sockets.server;

import edu.school21.sockets.config.SocketsApplicationConfig;
import edu.school21.sockets.repositories.UsersRepository;
import edu.school21.sockets.services.UsersService;
import edu.school21.sockets.services.UsersServiceImpl;
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

public class Server {
    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void run() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SocketsApplicationConfig.class);
        UsersRepository usersRepository = context.getBean("repository", UsersRepository.class);
        UsersService service = context.getBean("service", UsersServiceImpl.class);

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("Hello from Server!");
            Socket socket = server.accept();
            Scanner scan = new Scanner(socket.getInputStream());
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            while (scan.hasNextLine()) {
                String str = scan.nextLine();
                System.out.println(str);
                if (str.equals("signUp")) {
                    printWriter.println("Enter username:");
                    String username = scan.nextLine();
                    printWriter.println("Enter password:");
                    String password = scan.nextLine();
                    usersRepository.save(service.createNewUserAccount(username, password));
                    printWriter.println("Successful!");
                    break ;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}