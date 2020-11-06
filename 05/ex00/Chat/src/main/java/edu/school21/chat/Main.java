package edu.school21.chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final String url = "jdbc:postgresql://localhost:5432/chat_db";

    public static void main(String[] args) throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(url);
            if (!connection.isClosed()) {
                System.out.println("Соединение установлено!");
            }
            connection.close();
            if (connection.isClosed()) {
                System.out.println("Соединение разорвано!");
            }
        } catch (SQLException e) {
            System.err.println("Error!");
        }
    }
}
