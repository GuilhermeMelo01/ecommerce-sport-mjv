-- CLIENTE
insert into cliente (ID, CPF, EMAIL, END_BAIRRO, END_CIDADE, END_COMPLEMENTO,
 END_LOGRADOURO, END_NUMERO, NOME, TELEFONE)
values(1, '01234567890', 'Gui2022@Gmail.com', 'São Jorge', 'Recife', 'Proximo a Igreja',
'Rua Paulo Afonso', '392', 'Guilherme', '85987911180');

insert into cliente (ID, CPF, EMAIL, END_BAIRRO, END_CIDADE, END_COMPLEMENTO,
 END_LOGRADOURO, END_NUMERO, NOME, TELEFONE)
values(2, '11223344556', 'Maria2001@Gmail.com', 'São João', 'São Paulo', 'Proximo ao Itaquera',
'Rua Celso Riberio', '39203', 'Maria Souza', '85987993280');

-- PEDIDO
insert into pedido (ID, DATA_PEDIDO, CLIENTE_ID)
values(1, '2022-7-9', 1);

insert into pedido (ID, DATA_PEDIDO, CLIENTE_ID)
values(2, '2021-6-10', 2);

-- PRODUTO
insert into produto (ID, NOME, PRECO)
values(1, 'BOLA', 9.90);

insert into produto (ID, NOME, PRECO)
values(2, 'Taco de Baseball', 34.50);

-- ITEM PEDIDO
insert into item_pedido (ID, QUANTIDADE, PEDIDO_ID, PRODUTO_ID)
values(1, 2, 1, 1);

insert into item_pedido (ID, QUANTIDADE, PEDIDO_ID, PRODUTO_ID)
values(2, 1, 2, 2);