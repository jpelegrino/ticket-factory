
INSERT INTO STATUS(description) VALUES ('ACTIVE'),('INACTIVE');

INSERT INTO TK_FAC_EVENT(event_date,event_name,seat_quantity,location,status_id) VALUES
(sysdate()+15,'Romeo Santos Concert',4000,'Centro Olympico',1),
(sysdate()+10,'Disney show',1000,'Sambil',1),
(sysdate()+15,'Quiereme como yo a ti',4000,'Estadio Quisquella Juan Marichal',1);

INSERT INTO USERS(username,password) VALUES
('admin','$2a$10$5e3dB36HeRcozRgp8xQfw.tfD3Qsut8xu/NT9g/DSpVKg9Kzuitrq'),
('user','$2a$10$5e3dB36HeRcozRgp8xQfw.tfD3Qsut8xu/NT9g/DSpVKg9Kzuitrq');


INSERT INTO ROLES(description) VALUES
('ADMIN'),('NORMAL');

INSERT INTO PRIVILEGE(description) VALUES
('CUENTAS'),('CLIENTE');


INSERT INTO USER_ROLES(user_id,role_id) VALUES
(1,1),(2,2);

INSERT INTO ROLES_PRIVILEGES(role_id,privilege_id) VALUES
(1,1),(1,2),(2,1);


