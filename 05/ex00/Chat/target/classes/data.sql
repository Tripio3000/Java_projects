INSERT INTO users
(user_id, login, password, list_of_created_rooms, list_of_chatrooms_where_a_user_socializes)
VALUES
(DEFAULT, 'Dima', '123456', '{first, second}', null),
(DEFAULT, 'Alex', 'qwerty', null, null),
(DEFAULT, 'Helena', '12345678', '{first, second}', '{second, third}'),
(DEFAULT, 'Vasya', 'asdfghjkl', null, '{second, third}'),
(DEFAULT, 'Artem', 'zxp', null, null);

INSERT INTO chatroom
    (chatroom_id, chatroom_name, chatroom_owner, List_of_messages_in_a_chatroom)
VALUES
(DEFAULT, 'room1', 1, null),
(DEFAULT, 'room2', 2, '{message1, message2, message3}'),
(DEFAULT, 'room3', 3, null),
(DEFAULT, 'room4', 4, null),
(DEFAULT, 'room5', 5, '{message1, message2}');

INSERT INTO message
(message_id, message_author, message_room, message_text, message_date)
VALUES
(DEFAULT, 1, 5, 'texttext', CURRENT_TIMESTAMP),
(DEFAULT, 2, 4, 'texttext', CURRENT_TIMESTAMP),
(DEFAULT, 3, 3, 'texttext', CURRENT_TIMESTAMP),
(DEFAULT, 4, 2, 'texttext', CURRENT_TIMESTAMP),
(DEFAULT, 5, 1, 'texttext', CURRENT_TIMESTAMP);