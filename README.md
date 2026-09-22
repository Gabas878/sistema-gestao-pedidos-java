# Sistema de Gestão de Pedidos

Projeto desenvolvido em **Java** para praticar e consolidar conceitos de **Programação Orientada a Objetos**, **Collections**, **Stream API**, **expressões lambda**, **Enums**, **tratamento de exceções** e implementação de **regras de negócio**.

O sistema simula o gerenciamento de produtos e pedidos, incluindo controle de estoque, clientes, itens de pedido e fluxo de status.

---

## Sobre o projeto

O projeto foi desenvolvido como parte do meu processo de aprendizagem em Java, buscando aplicar conceitos estudados em um cenário mais próximo de uma aplicação real.

Durante o desenvolvimento, o sistema evoluiu de operações básicas com produtos para um fluxo completo de pedidos, envolvendo validações, controle de estoque, associação entre objetos e regras para alteração do status do pedido.

---

## Funcionalidades

### Produtos

* Cadastro de produtos
* Validação de produtos duplicados
* Validação de produtos sem estoque
* Busca de produto por nome
* Busca de produtos por categoria
* Listagem de produtos
* Identificação de produtos sem estoque
* Controle de quantidade disponível em estoque

### Pedidos

* Criação de pedidos vinculados a um cliente
* Adição de itens ao pedido
* Controle de quantidade por item
* Permissão para adicionar o mesmo produto novamente ao pedido
* Validação da quantidade solicitada
* Validação de disponibilidade em estoque
* Atualização do estoque após a inclusão de itens
* Cálculo do valor total do pedido
* Exibição dos itens do pedido

### Status do pedido

O pedido possui os seguintes estados:

* `PENDENTE`
* `PROCESSANDO`
* `ENVIADO`
* `ENTREGUE`
* `CANCELADO`

Também foram implementadas regras para controlar as transições entre os diferentes estados do pedido.

Exemplo de fluxo:

```text
PENDENTE
   ↓
PROCESSANDO
   ↓
ENVIADO
   ↓
ENTREGUE
```

O sistema também contempla o cancelamento de pedidos de acordo com as regras definidas no projeto.

---

## Conceitos de Java praticados

Durante o desenvolvimento foram utilizados diversos conceitos da linguagem:

* Programação Orientada a Objetos (POO)
* Classes e objetos
* Encapsulamento
* Construtores
* Métodos e atributos
* Collections
* `ArrayList`
* `Enum`
* Stream API
* Lambda Expressions
* `Function`
* `Consumer`
* `Optional`
* `findFirst()`
* `filter()`
* `map()`
* `mapToDouble()`
* `anyMatch()`
* Method References
* Tratamento de exceções
* Validação de regras de negócio
* Associação entre objetos

---

## Estrutura do projeto

```text
src/
├── app/
│   └── TesteGeral.java
│
├── enums/
│   └── StatusPedido.java
│
├── exception/
│   └── ProdutoException.java
│
├── model/
│   ├── Cliente.java
│   ├── ItemPedido.java
│   ├── Pedido.java
│   └── Produto.java
│
└── service/
    └── ProdutoService.java
```

### Organização

**`model`**

Contém as principais entidades do sistema:

* `Cliente`
* `Produto`
* `ItemPedido`
* `Pedido`

**`service`**

Contém as operações relacionadas ao gerenciamento dos produtos.

**`enums`**

Contém os estados possíveis de um pedido.

**`exception`**

Contém as exceções utilizadas nas validações das regras de negócio.

**`app`**

Contém a classe utilizada para testar e demonstrar o funcionamento do sistema.

---

## Exemplo de funcionamento

Um pedido pode ser criado para um determinado cliente:

```java
Pedido pedido = new Pedido(
    cliente,
    StatusPedido.PENDENTE
);
```

Produtos podem ser adicionados ao pedido:

```java
pedido.adicionarItem(itemNotebook);
pedido.adicionarItem(itemBola);
```

O sistema verifica a quantidade disponível em estoque e atualiza o estoque após a inclusão do item.

Também é possível calcular o valor total:

```java
pedido.valorTotalPedido();
```

E alterar o status seguindo as regras definidas para o fluxo do pedido:

```java
pedido.alterarStatus(StatusPedido.PROCESSANDO);
pedido.alterarStatus(StatusPedido.ENVIADO);
pedido.alterarStatus(StatusPedido.ENTREGUE);
```

---

## Tecnologias e ferramentas

* **Java**
* **IntelliJ IDEA**
* **Git**
* **GitHub**

---

## Como executar

### 1. Clone o repositório

```bash
git clone <https://github.com/Gabas878/sistema-gestao-pedidos-java>
```

### 2. Abra o projeto

Abra o projeto em uma IDE compatível com Java, como o IntelliJ IDEA.

### 3. Configure o JDK

Certifique-se de que o JDK esteja configurado corretamente na IDE.

### 4. Execute

Execute a classe:

```text
src/app/TesteGeral.java
```

Ela contém exemplos para testar as principais funcionalidades implementadas no projeto.

---

## Próximos passos

Este projeto continua aberto para evolução. Algumas melhorias que podem ser implementadas futuramente:

* Implementação de testes automatizados
* Melhor separação das responsabilidades entre as classes
* Aprimoramento do tratamento de exceções
* Persistência de dados
* Integração com banco de dados
* Criação de uma API REST
* Migração da camada de serviço para uma aplicação utilizando Spring Boot
* Implementação de testes com JUnit
* Melhorias na arquitetura do projeto

---

## Objetivo

O principal objetivo deste projeto é **transformar conceitos estudados em Java em uma aplicação prática**, evoluindo gradualmente a implementação conforme novos conhecimentos são adquiridos.

O projeto também faz parte da construção do meu portfólio na área de desenvolvimento de software, com foco no aprendizado de **Java e desenvolvimento back-end**.
