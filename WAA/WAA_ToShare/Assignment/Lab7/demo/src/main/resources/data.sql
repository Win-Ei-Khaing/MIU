INSERT into USER (id, name, username, password, IS_Enabled)  VALUES (1, 'WinEiKhaing','win','12345',true);
INSERT into USER (id, name, username, password, IS_Enabled)  VALUES (2, 'Welda','welda','12345',true);

INSERT INTO ROLE(ROLE_ID, ROLE) VALUES (1, 'ADMIN');
INSERT INTO ROLE(ROLE_ID, ROLE) VALUES (2, 'USER');

insert into USER_ROLES(USER_ID, ROLE_ID) values (1, 1);
insert into USER_ROLES(USER_ID, ROLE_ID) values (2, 2);


INSERT into POST (id, title, content, author, user_id) VALUES (1, 'MIU','Life is structured in layers','Dean', 1);
INSERT into POST (id, title, content, author, user_id) VALUES (2, 'React','React is a good SPA library','Dean', 1);
INSERT into POST (id, title, content, author, user_id) VALUES (3, 'Spring','Spring is awesome','Dean', 1);
INSERT into POST (id, title, content, author, user_id)  VALUES (4, 'SpringBoot','This is a module that works over spring modules','John', 2);