INSERT INTO chat.users(login, password) VALUES ('tyuuki', 'karimvaliev'),
                                               ('delegrim', '11771177'),
                                               ('anonimus', 'abcd11177'),
                                               ('Karim Valiev', 'abcd1177'),
                                               ('ereginia', 'abcd1177');

INSERT INTO chat.chats(chat_room_name, chat_room_owner) VALUES ('tyuukiRoom', 1),
                                                               ('delegrimRoom', 2),
                                                               ('anonimusRoom', 3),
                                                               ('Karim ValievRoom', 4),
                                                               ('ereginiaRoom', 5);

INSERT INTO chat.messages(message_autor, room_id, message_text, date_of_message) VALUES (1, 1, 'Hello Everyone!', '2022-07-18'),
                                                                                        (2, 1, 'Hi, How are u?What u gonna do?', '2022-07-18'),
                                                                                        (1, 1, 'Im gonna go to shop' , '2022-07-18'),
                                                                                        (3, 2, 'Hello Everyone!', '2022-07-18'),
                                                                                        (4, 2, 'Hi.', '2022-07-18');