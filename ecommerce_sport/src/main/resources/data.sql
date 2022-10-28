-- CLIENTE
insert into cliente (ID, CPF, EMAIL, END_BAIRRO, END_CIDADE, END_COMPLEMENTO,
 END_LOGRADOURO, END_NUMERO, NOME, TELEFONE)
values(1, '01234567890', 'Gui2022@Gmail.com', 'São Jorge', 'Recife', 'Proximo a Igreja',
'Rua Paulo Afonso', '392', 'Guilherme', '85987911180');

insert into cliente (ID, CPF, EMAIL, END_BAIRRO, END_CIDADE, END_COMPLEMENTO,
 END_LOGRADOURO, END_NUMERO, NOME, TELEFONE)
values(2, '11223344556', 'Maria2001@Gmail.com', 'São João', 'São Paulo', 'Proximo ao Itaquera',
'Rua Celso Riberio', '39203', 'Maria Souza', '85987993280');

-- PRODUTO
insert into produto (ID, CATEGORIA, NOME, PRECO)
values(1, 2,'Bola', 9.90);

insert into produto (ID, CATEGORIA, NOME, PRECO)
values(2, 5, 'Taco de Baseball', 34.50);

-- PAGAMENTO
insert into pagamento (ID, ESTADO_PAGAMENTO, TIPO_PAGAMENTO)
values(1, 2, 3);

insert into pagamento (ID, ESTADO_PAGAMENTO, TIPO_PAGAMENTO)
values(2, 1, 1);

-- PEDIDO
insert into pedido (ID, DATA_PEDIDO, CLIENTE_ID, PAGAMENTO_ID)
values(1, '2022-7-9', 1, 1);

insert into pedido (ID, DATA_PEDIDO, CLIENTE_ID, PAGAMENTO_ID)
values(2, '2021-6-10', 2, 2);

-- ITEM PEDIDO
insert into item_pedido (PRECO, QUANTIDADE, PEDIDO_ID, PRODUTO_ID)
values(20.30, 2, 1, 1);

insert into item_pedido (PRECO, QUANTIDADE, PEDIDO_ID, PRODUTO_ID)
values(48.55, 1, 2, 2);