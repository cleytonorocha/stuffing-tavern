# Stuffing Tavern
### Bem-vindo à Stuffing Tavern! 🍻🏰

A Stuffing Tavern é uma tradicional taverna medieval, onde aventureiros de todas as partes podem se reunir para desfrutar das melhores comidas e, principalmente, das bebidas mais lendárias do reino. Seja você um guerreiro cansado de batalhas ou um bardo em busca de inspiração, aqui você encontrará conforto e hospitalidade.

### Objetivo do Projeto
O projeto Stuffing Tavern tem como objetivo criar uma aplicação que simula o funcionamento de uma taverna medieval focada na venda de comidas e bebidas. Com um catálogo diversificado de pratos típicos e uma seleção especial de bebidas, a taverna oferece aos seus clientes uma experiência imersiva, transportando-os para um ambiente acolhedor e repleto de histórias.

<!-- 
## Funcionalidades
Catálogo de Bebidas: Explore nossa vasta coleção de bebidas, desde hidromel e cerveja artesanal até vinhos raros e poções misteriosas.
Cardápio de Comidas: Acompanhe suas bebidas com pratos tradicionais como ensopados, pães frescos e carnes assadas.
Carrinho de Compras: Adicione suas comidas e bebidas favoritas ao carrinho para um banquete completo.
Sistema de Pagamento: Finalize sua compra com praticidade e segurança.
Histórias dos Produtos: Cada bebida e prato vem com uma história rica, oferecendo aos clientes um pouco da tradição e mística que torna a Stuffing Tavern especial.
Promoções Especiais: Descontos sazonais em bebidas e combos exclusivos para os mais fiéis frequentadores da taverna. -->

# Projeto

A aplicação utiliza o padrão Saga Orquestrado para garantir a consistência dos dados e realizar rollbacks automáticos em caso de falhas. Através da separação de tópicos distintos para SUCCESS e FAIL, organizados pelo Apache Kafka, a arquitetura assegura que cada etapa do processo seja monitorada e que falhas sejam tratadas e persistidas adequadamente, garantindo a confiabilidade do sistema.


### Serviços
A aplicação é composta pelos seguintes serviços, cada um desempenhando um papel fundamental no fluxo da saga:

- <strong>Order</strong>: Gerencia a criação, rastreamento e histórico dos pedidos feitos pelos usuários.;

- <strong>Client</strong>: Gerencia o cadastro, histórico e status do usuario cadastrado;

- <strong>Inventory</strong>: Gerencia o estoque dos produtos, garantindo que os níveis de inventário sejam atualizados conforme as vendas e reposições.;

- <strong>Notification</strong>: Envia notificações para os usuários por e-mail, SMS ou outros canais sobre atualizações de pedidos, promoções ou outros eventos importantes.;

- <strong>Payment</strong>: Processa os pagamentos dos pedidos, incluindo integração com gateways de pagamento e gerenciamento de transações.;

- <strong>Product</strong>:  Gerencia o catálogo de produtos, incluindo detalhes como nome, descrição, preço, estoque, categorias, e imagens;

- <strong>Orchestrator</strong>: O responsável pela organização dos eventos.

### Tópicos
Os eventos na aplicação são organizados nos seguintes tópicos:

| **SERVICE**     | **TOPIC**              | **TYPE**    |
|:---: |:---: |:---: |
| ORDER           | START-ORDER             | CONSUMER    |
| ORDER           | NOTIFY-ENDING           | CONSUMER    |
| PAYMENT         | PAYMENT-SUCCESS         | CONSUMER    |
| PAYMENT         | PAYMENT-FAIL            | CONSUMER    |
| PAYMENT         | ORCHESTRATOR            | PRODUCER    |
| PRODUCT         | PRODUCT-SUCCESS         | CONSUMER    |
| PRODUCT         | PRODUCT-FAIL            | CONSUMER    |
| PRODUCT         | ORCHESTRATOR            | PRODUCER    |
| CLIENT          | CLIENT-SUCCESS          | CONSUMER    |
| CLIENT          | CLIENT-FAIL             | CONSUMER    |
| CLIENT          | ORCHESTRATOR            | PRODUCER    |
| INVENTORY       | INVENTORY-SUCCESS       | CONSUMER    |
| INVENTORY       | INVENTORY-FAIL          | CONSUMER    |
| INVENTORY       | ORCHESTRATOR            | PRODUCER    |
| NOTIFICATION    | NOTIFICATION-SUCCESS    | CONSUMER    |
| NOTIFICATION    | NOTIFICATION-FAIL       | CONSUMER    |
| NOTIFICATION    | ORCHESTRATOR            | PRODUCER    |

### Requisitos

- Docker

### Tech

- Java 17;
- Spring Boot;
- Spring Data Jpa;
- PostgreSQL
- Kafka;
- Docker.