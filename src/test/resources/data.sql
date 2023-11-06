insert into role(id,nome) values (1, 'ROLE_USER');
insert into role(id,nome) values (2, 'ROLE_ADMIN');

insert into user(id,username,email,login,password) values (1,'Admin','admin@gmail.com','admin','$2a$10$HKveMsPlst41Ie2LQgpijO691lUtZ8cLfcliAO1DD9TtZxEpaEoJe');
insert into user(id,username,email,login,password) values (2,'User','user@gmail.com','user','$2a$10$HKveMsPlst41Ie2LQgpijO691lUtZ8cLfcliAO1DD9TtZxEpaEoJe');

insert into user_roles(user_id,role_id) values(1, 2);
insert into user_roles(user_id,role_id) values(2, 1);

INSERT INTO saloes (id, nome, cnpj, endereco, cidade, descricao, capacidade, logo, imagens, email)
VALUES
    (1, 'Teste', '01855743000106', 'endereço teste', 'cidade teste', 'descricao teste', 60, NULL, NULL, 'jeanmaxskrebs@gmail.com'),
    (2, 'Salao Luxor', '12345678901234', 'Rua Luxor, 123', 'Cidade Luxor', 'Um salão luxuoso para eventos especiais', 100, NULL, NULL, 'luxorevents@example.com'),
    (3, 'Salao Estrelar', '98765432109876', 'Avenida Estrelar, 456', 'Cidade das Estrelas', 'Um salão mágico sob as estrelas', 80, NULL, NULL, 'estrellounge@example.com');
