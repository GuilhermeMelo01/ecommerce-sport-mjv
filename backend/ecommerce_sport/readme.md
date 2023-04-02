# E-COMMERCE SPORT MJV

API de um e-commerce que prover recursos para compra de produtos esportivos.

A Arquitetura do nosso projeto funciona da seguinte forma:

**Pacotes:**

|   Pacote   | Definição                                                    |
| :--------: | ------------------------------------------------------------ |
|   config   | Definições de configuração inicial do projeto                |
| controller | Recursos HTTP para disponibilizar o acesso as funcionalidades da aplicação |
| exception  | Contem a tratamento e personalização do retorno de exceções  |
|    dto     | Classes que ajudam no trasporte de dados necessarios para algum funcionalidade |
|   enums    | Classes com atributos pré-estabelecidos que serão usadas na aplicação |
|   model    | Classes e entidades com base nas diretivas do negócio da aplicação |
| repository | Interfaces para persistências de dados com base no Spring Data JPA |
|  service   | Classes contendo todas as regras de negócio da aplicação     |

## @Embeddable & @Embedded & @EmbeddedId

Caso 1: Tenho a classe **Cliente** que vai ter uma composição com a classe **Endereco**.

Mas no meu caso eu não quero criar duas tabelas para o meu banco de dados, então vou compor 

a minha Classe Cliente com os atributos da classe Enderenço utilizando as anotações **@Embeddable** e

**@Embedded** do JPA. 

- Cliente
  - o atributo endereco recebe a anotação @Embedded

- Enderenco
  - A classe vai receber a anotação @Embeddable



Caso 2: Tenho a classe **ItemPedido** que vai ter uma _chave primaria composta_ a partir do **ItemPedidoPK**. 

Dentro da minha classe ItemPedido eu vou ter um atributo da classe ItemPedidoPK que será anotada com 

**@EmbeddeId** e que tera os atributos do meu id composto, no meu caso o pedido e produto.

-  ItemPedido
  - o atributo itemPedidoPK recebe a anotação @EmbeddeId
- ItemPedidoPK
  - a classe ItemPedidoPK recebe a anotação @Embeddable



# Demonstração

A empresa MJV está querendo entrar para a área de vendas esportivas e solicitou para a nossa empresa de tecnologia o desenvolvimento de um e-commerce para vendas de produtos online. Foi alertado pela MJV a  importância inicial de disponibilizar cadastro de clientes, enderenço de entrega, a compra de produtos e a forma de pagamento.

###### LET'S DO IT!!!!  

Para a nossa demonstração estamos interagindo com nossa API diretamente através do Swagger conforme URL:

```
http://localhost:8080/swagger-ui.html#/
```

### 1° Etapa - Procedimentos com Cliente

1. Adicionando um novo cliente junto com o seu enderenço.

```
POST:/clientes
{
  "nome": "Monalisa Tavares",
  "cpf": "21137642025",
  "telefone": "85933445566",
  "email": "MonalisaTavares@gmail.com",
  "logradouro": "Rua Celso Ribeiro",
  "cidade": "São Paulo",
  "bairro": "São Vicente",
  "numero": "1810",
  "complemento": "Proximo a igreja matriz"
}
```

2. Consultando clientes no banco de dados.
   - Temos duas formas de consultar os clientes cadastrados no banco de dados.

- Através do ID do cliente

```
GET:/clientes/{id}
```

- Buscando todos os clientes

```
GET:/clientes
```

**JSON esperado ao fazer a busca por ID.**

```
{
  "id": 4,
  "nome": "Monalisa Tavares",
  "cpf": "21137642025",
  "telefone": "85933445566",
  "email": "MonalisaTavares@gmail.com",
  "endereco": {
    "logradouro": "Rua Celso Ribeiro",
    "cidade": "São Paulo",
    "bairro": "São Vicente",
    "numero": "1810",
    "complemento": "Proximo a igreja matriz"
  }
}
```

**JSON esperado ao fazer a busca por ID invalido.**

```
{
  "timeStamp": 1667326404487,
  "status": 400,
  "error": "Argumento inválido",
  "sugestao": "Verifique se preencheu o campo 'Id', com um id existente!",
  "message": "Id não encotrado",
  "path": "/clientes/5"
}
```

3. Atualização de clientes.
   - Temos duas formas de atualizar os clientes.

- Podemos atualizar os atributos parcialmente.

```
PATCH:/clientes/atualizar/{id}
{
  "nome": "Monalisa",
  "email": "Monalisa@hotmail.com",
  "telefone": "11922334456"
}
```

- Podemos atualizar todos os atributos

```
PUT:/clientes/atualizar/{id}
{
  "nome": "Guilherme",
  "cpf": "30566904047",
  "email": "Guilherme@gmail.com",
  "telefone": "85911223344",
  "logradouro": "Avenida Principal",
  "cidade": "Fortaleza",
  "bairro": "Montese",
  "numero": "1109",
  "complemento": "Proximo ao Universal Park"
}
```

**JSON esperado ao tentar atualizar um cliente passando argumentos inválidos.**

```
{
  "timeStamp": 1667328597035,
  "status": 400,
  "error": "Argumento inválido",
  "sugestao": "Verifique se todos os dados estão corretos",
  "message": "default message [Campo cidade não pode ser vazio]]", - [*]
  "path": "/clientes/atualizar/4"
}
```

4. Remoção de um cliente
   - Um cliente não pode ser removido com pedidos associados.

```
DELETE:/clientes/remover/{id}
```



### 2° Etapa - Processo com pedidos

- Fazendo um pedido a partir de um cliente, lista de itens, quantidade e tipo do pagamento.  

```
POST:/pedidos
{
  "idCliente": 1,
  "itens": [
    {
      "id": {
        "produto": {
          "categoria": "BASQUETE",
          "id": 1,
          "nome": "string",
          "preco": 0
        }
      },
      "preco": 0,
      "quantidade": 2,
      "subTotal": 0
    }
  ],
  "tipoPagamento": 1
}
```

- Também podemos fazer um pedido com mais itens.

```
POST:/pedidos
{
  "idCliente": 1,
  "itens": [
    {
      "id": {
        "produto": {
          "categoria": "BASQUETE",
          "id": 1,
          "nome": "string",
          "preco": 0
        }
      },
      "preco": 0,
      "quantidade": 2,
      "subTotal": 0
    },
    {
      "id": {
        "produto": {
          "categoria": "BASQUETE",
          "id": 2,
          "nome": "string",
          "preco": 0
        }
      },
      "preco": 0,
      "quantidade": 2,
      "subTotal": 0
    }
  ],
  "tipoPagamento": 1
}
```

1. Cancelando um pedido, podemos cancelar um pedido de acordo estado de pagamento do cliente.

- Se o estado do pagamento for 'QUITADO', um pedido que já está quitado não pode ser cancelado.
- Se o estado do pagamento for 'CANCELADO', um pedido que já foi cancelado não pode ser cancelado.
- Tá! mas qual pedido pode ser cancelado? um pedido que está 'PENDENTE'.

Utilizado o PATCH porque o pedido não será removido apenas cancelado.

```
PATCH:/pedidos/cancelar/{id}
```

**Se eu cancelar o mesmo pedido duas vezes, ocorrera um erro!**

- Por que não remover um pedido? Porque na minha regra de negocio não faz sentindo remover um pedido mesmo que ele esteja quitado, porque eu quero ter o histórico de todos os pedidos.



### 3° Etapa - Processo com produtos

1. Com produtos foram feitos processos GET, como por exemplo buscar um produto por nome e buscar produtos passando o preço como parâmetro.

Buscando produtos que contêm a palavra passada na requisição.

```
GET:/produtos/buscarNome
```

Buscando produtos que tem o preço menor que o valor requisitado.

```
GET:/produtos/buscarPreco
```

Buscando produtos a partir da sua categoria.

```
GET:/produtos/buscarCategoria
```



# THAT'S IT!!! MUITO OBRIGADO!!! 