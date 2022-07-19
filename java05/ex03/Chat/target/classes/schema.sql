CREATE SCHEMA if not exists chat;

CREATE TABLE if not exists chat.users (
    id BIGSERIAL PRIMARY KEY,
    login TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL
);

CREATE TABLE if not exists chat.chats
(
    chat_id BIGSERIAL PRIMARY KEY,
    chat_room_name TEXT NOT NULL UNIQUE,
    chat_room_owner BIGINT NOT NULL UNIQUE REFERENCES chat.users(id)
);

CREATE TABLE if not exists chat.messages (
    message_id BIGSERIAL PRIMARY KEY,
    message_autor BIGINT NOT NULL REFERENCES chat.users(id),
    room_id BIGINT NOT NULL REFERENCES chat.chats(chat_id),
    message_text TEXT NOT NULL,
    date_of_message TIMESTAMP
);