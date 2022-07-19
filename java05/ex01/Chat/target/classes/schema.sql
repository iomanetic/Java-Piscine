CREATE SCHEMA if not exists chat;

CREATE TABLE if not exists chat.users (
    id SERIAL PRIMARY KEY,
    login TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL
);

CREATE TABLE if not exists chat.chats
(
    chat_id SERIAL PRIMARY KEY,
    chat_room_name TEXT NOT NULL UNIQUE,
    chat_room_owner INT NOT NULL UNIQUE REFERENCES chat.users(id)
);

CREATE TABLE if not exists chat.messages (
    message_id SERIAL PRIMARY KEY,
    message_autor INT NOT NULL REFERENCES chat.users(id),
    room_id INT NOT NULL REFERENCES chat.chats(chat_id),
    message_text TEXT NOT NULL,
    date_of_message TIMESTAMP NOT NULL
);