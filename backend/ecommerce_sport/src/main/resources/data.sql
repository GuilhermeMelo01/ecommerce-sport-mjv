---- CLIENTE
--insert into cliente (ID, CPF, EMAIL, END_BAIRRO, END_CIDADE, END_COMPLEMENTO,
-- END_LOGRADOURO, END_NUMERO, NOME, TELEFONE)
--values(1, '01234567890', 'Gui2022@Gmail.com', 'São Jorge', 'Recife', 'Proximo a Igreja',
--'Rua Paulo Afonso', '392', 'Guilherme', '85987911180');
--
--insert into cliente (ID, CPF, EMAIL, END_BAIRRO, END_CIDADE, END_COMPLEMENTO,
-- END_LOGRADOURO, END_NUMERO, NOME, TELEFONE)
--values(2, '11223344556', 'Maria2001@Gmail.com', 'São João', 'São Paulo', 'Proximo ao Itaquera',
--'Rua Celso Riberio', '39203', 'Maria Souza', '85987993280');

-- PRODUTO
-- BASQUETE
insert into produto (ID, CATEGORIA, NOME, PRECO)
values(1, 1,'Bola de basquete', 119.89);

insert into produto (ID, CATEGORIA, NOME, PRECO)
values(2, 1, 'Camisa NBA Boston', 109.90);

insert into produto (ID, CATEGORIA, NOME, PRECO)
values(3, 1,'Mochila Hoops', 649.99);

insert into produto (ID, CATEGORIA, NOME, PRECO)
values(4, 1,'Chinela Jurassic', 34.41);

--FUTEBOL
insert into produto (ID, CATEGORIA, NOME, PRECO)
values(5, 2,'Camisa do Flamengo', 239.19);

insert into produto (ID, CATEGORIA, NOME, PRECO)
values(6, 2, 'Chuteira Society', 212.49);

insert into produto (ID, CATEGORIA, NOME, PRECO)
values(7, 2,'Bola futsal', 110.00);

insert into produto (ID, CATEGORIA, NOME, PRECO)
values(8, 2,'Camisa Brasil', 39.90);

--NATACAO
insert into produto (ID, CATEGORIA, NOME, PRECO)
values(9, 3,'Sunga Wide', 89.99);

insert into produto (ID, CATEGORIA, NOME, PRECO)
values(10, 3, 'Chinela Aqua', 79.99);

insert into produto (ID, CATEGORIA, NOME, PRECO)
values(11, 3,'Macaquinho Fila', 139.99);

insert into produto (ID, CATEGORIA, NOME, PRECO)
values(12, 3,'Óculos natação Leader', 92.50);

--VOLEI
insert into produto (ID, CATEGORIA, NOME, PRECO)
values(13, 4,'Kit volei proteção', 63.00);

insert into produto (ID, CATEGORIA, NOME, PRECO)
values(14, 4, 'Kit 2 shorts tactel', 64.70);

insert into produto (ID, CATEGORIA, NOME, PRECO)
values(15, 4,'Bola volei AVP', 169.99);

insert into produto (ID, CATEGORIA, NOME, PRECO)
values(16, 4,'Fita de fixação da antena', 99.80);

--BASEBALL
insert into produto (ID, CATEGORIA, NOME, PRECO)
values(17, 5,'Bone New Era', 189.90);

insert into produto (ID, CATEGORIA, NOME, PRECO)
values(18, 5, 'Regata new Era Girls', 139.90);

insert into produto (ID, CATEGORIA, NOME, PRECO)
values(19, 5,'Camisa Baseball M10', 122.90);

insert into produto (ID, CATEGORIA, NOME, PRECO)
values(20, 5,'Jaqueta Dupla Face New York', 656.91);

--ARTES_MARCIAIS
insert into produto (ID, CATEGORIA, NOME, PRECO)
values(21, 6,'Tênis Boxe', 139.90);

insert into produto (ID, CATEGORIA, NOME, PRECO)
values(22, 6, 'Camisa de Compressão UFC', 28.99);

insert into produto (ID, CATEGORIA, NOME, PRECO)
values(23, 6,'Kit luva de boxe + Bandagem', 257.59);

insert into produto (ID, CATEGORIA, NOME, PRECO)
values(24, 6,'Mochila Everlast Clássica', 119.99);

--
---- PAGAMENTO
--insert into pagamento (ID, ESTADO_PAGAMENTO, TIPO_PAGAMENTO)
--values(1, 2, 3);
--
--insert into pagamento (ID, ESTADO_PAGAMENTO, TIPO_PAGAMENTO)
--values(2, 1, 1);
--
---- PEDIDO
--insert into pedido (ID, DATA_PEDIDO, CLIENTE_ID, PAGAMENTO_ID)
--values(1, '2022-7-9', 1, 1);
--
--insert into pedido (ID, DATA_PEDIDO, CLIENTE_ID, PAGAMENTO_ID)
--values(2, '2021-6-10', 2, 2);
--
---- ITEM PEDIDO
--insert into item_pedido (PRECO, QUANTIDADE, PEDIDO_ID, PRODUTO_ID)
--values(20.30, 2, 1, 1);
--
--insert into item_pedido (PRECO, QUANTIDADE, PEDIDO_ID, PRODUTO_ID)
--values(48.55, 1, 2, 2);