package edu.school21.sockets.config;

// import edu.school21.sockets.repositories.*;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.sockets.repositories.UsersRepository;
import edu.school21.sockets.repositories.UsersRepositoryImpl;
import edu.school21.sockets.services.UsersServiceImpl;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.io.FileReader;
import java.util.Properties;
import javax.sql.*;

@Configuration
@ComponentScan(basePackages = "edu.school21.sockets.app")
public class SocketsApplicationConfig {

    @Bean
    DataSource dataSource(){
        try  {
            FileReader reader = new FileReader("target/classes/db.properties");
            Properties prop = new Properties();
            prop.load(reader);
            String drivers = prop.getProperty("db.driver.name");
            String connectionURL = prop.getProperty("db.url");
            String username = prop.getProperty("db.username");
            String password = prop.getProperty("db.password");
            HikariConfig hikariConfig = new HikariConfig();
            hikariConfig.setDriverClassName(drivers);
            hikariConfig.setJdbcUrl(connectionURL); 
            hikariConfig.setUsername(username);
            hikariConfig.setPassword(password);
            return new HikariDataSource(hikariConfig);
        } catch (Exception e) {
        }
        return null;
    }

    @Bean
    UsersRepository repository() {
        try {
            return new UsersRepositoryImpl(dataSource());
        } catch (Exception e) {}
        return null;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UsersServiceImpl service() {
        try {
            return new UsersServiceImpl(passwordEncoder());
        } catch (Exception e) {}
        return null;
    }
}