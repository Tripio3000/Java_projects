package edu.school21.sockets.app;

// import edu.school21.sockets.repositories.*;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.*;
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

    // @Bean
    // UsersRepository repository() {
    //     try {
    //         return new UsersRepositoryImpl(dataSource());
    //     } catch (Exception e) {}
    //     return null;
    // }
}