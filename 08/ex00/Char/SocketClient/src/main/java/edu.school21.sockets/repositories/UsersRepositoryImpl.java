package edu.school21.sockets.app;

// import edu.school21.sockets.models.*;

import javax.sql.*;
import java.util.*;
import java.sql.*;
// import org.springframework.jdbc.datasource.embedded.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.context.annotation.*;

@Component
public class UsersRepositoryImpl implements UsersRepository {
    @Autowired
    private DataSource source;
    private JdbcTemplate jdbcTemplate;

    private class UserMapper implements RowMapper {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    }

    public UsersRepositoryImpl(DataSource source) throws SQLException {
        this.source = source;
        jdbcTemplate = new JdbcTemplate(source);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from users", new UserMapper());
    }

    @Override
    public Optional<User> findById(Long id) {
        String SQL = "SELECT * FROM users WHERE id = ?";
        User user = (User)jdbcTemplate.queryForObject(SQL, new Object[]{id}, new UserMapper());
        return Optional.of(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        String SQL = "SELECT * FROM users WHERE username = ?";
        User user = (User)jdbcTemplate.queryForObject(SQL, new Object[]{username}, new UserMapper());
        return Optional.of(user);
    }

    @Override
    public void save(User user) {
        String SQL = "INSERT INTO users VALUES (DEFAULT, ?, ?)";
        jdbcTemplate.update(SQL, user.getUsername(), user.getPassword());
    }

    @Override
    public void update(User user) {
        String SQL = "UPDATE users SET username = ?, password = ? WHERE id = ?";
        jdbcTemplate.update(SQL, user.getUsername(), user.getPassword(), user.getId());
    }

    @Override
    public void delete (Long id) {
        String SQL = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(SQL, id);
    }
}