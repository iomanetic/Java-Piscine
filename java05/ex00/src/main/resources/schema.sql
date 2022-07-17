CREATE SCHEMA chat;

CREATE TABLE chat.users (
    id INT PRIMARY KEY,
    login TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL
);

CREATE TABLE chat.messages (
    message_id INT PRIMARY KEY,
    message_autor TEXT NOT NULL,
    message_room TEXT NOT NULL,
    message_text TEXT NOT NULL,
    date_of_message DATE NOT NULL
);

CREATE TABLE chat.chats (
    user_id INT PRIMARY KEY,
    chat_room_owner TEXT NOT NULL UNIQUE,
    chat_room_name TEXT NOT NULL UNIQUE

);