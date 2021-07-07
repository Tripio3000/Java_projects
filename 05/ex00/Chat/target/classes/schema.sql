CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    login text NOT NULL,
    password text NOT NULL,
    list_of_created_rooms text[],
    list_of_chatrooms_where_a_user_socializes text[]
);

CREATE TABLE chatroom (
    chatroom_id SERIAL PRIMARY KEY,
    chatroom_name text NOT NULL,
    chatroom_owner int NOT NULL REFERENCES users (user_id),
    List_of_messages_in_a_chatroom text[]
);

CREATE TABLE message (
    message_id SERIAL PRIMARY KEY,
    message_author int NOT NULL REFERENCES users (user_id),
    message_room int NOT NULL REFERENCES chatroom (chatroom_id),
    message_text text NOT NULL,
    message_date TIMESTAMP
);
