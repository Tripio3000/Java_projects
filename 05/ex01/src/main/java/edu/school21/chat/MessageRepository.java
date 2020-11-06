package edu.school21.chat;

import java.util.Optional;

public interface MessageRepository {
    public Message findById(Long id);
}
