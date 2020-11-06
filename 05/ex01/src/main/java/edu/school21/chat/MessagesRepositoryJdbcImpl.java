package edu.school21.chat;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessageRepository {
    private DataSource source;
    private List<Message> messages;
    public MessagesRepositoryJdbcImpl(DataSource source) throws SQLException {
        this.source = source;
    }
    private void fetchData() throws SQLException {
        String SQL__MES = "select * from messages";
        // String SQL__USER = "select * from users";
        // String SQL__ROOMS = "select * from rooms";
        this.messages = null;
        try {
            Connection con = source.getConnection();
            PreparedStatement pr_mes = con.prepareStatement( SQL__MES );
            // PreparedStatement pr_user = con.prepareStatement( SQL__USER );
            // PreparedStatement pr_room = con.prepareStatement( SQL__ROOMS );
            ResultSet res_mes = pr_mes.executeQuery();
            // ResultSet res_user = pr_user.executeQuery();
            // ResultSet res_room = pr_room.executeQuery();
            messages = new ArrayList<Message>();
            // List<User> users = new ArrayList<User>();
            // List<Room> rooms = new ArrayList<Room>();
            ResultSet rs = res_mes;
            while ( rs.next() ) {
                Message message = new Message();
                message.setMessage_id( rs.getInt( "id" ) );
                message.setMessage_author( rs.getInt( "author" ) );
                message.setMessage_room( rs.getInt( "room" ) );
                message.setMessage_text( rs.getString( "text" ) );
                // Timestamp timestamp = resultSet.getTimestamp(i);
                // Date date = new java.util.Date(timestamp.getTime()));
                // employee.setDate( date );
                message.setDate( rs.getDate( "date" ) );
                // employee.setSal( rs.getInt( "sal" ) );
                // employee.setComm( rs.getInt( "comm" ) );
                // employee.setDeptno( rs.getInt( "deptno" ) );
                messages.add( message );
            }
        } catch (Exception e) {
        }
    }

    @Override
    public Message findById(Long id) {
        try {
            fetchData();
        } catch (SQLException e) {
            return null;
        }
        Message mes = null;
        for (int i = 0; i < messages.size(); i++) {
            mes = messages.get(i);
            if (mes.setMessage_id() == id.intValue()) {
                return mes;
            }
        }
        return null;
    }
}
