# RENTAL EVENTOS

Sistema web para gerenciamento de equipamentos destinados à locação para eventos.

O **RENTAL EVENTOS** foi desenvolvido para facilitar o controle de equipamentos, estoque e movimentações de uma empresa de locação, substituindo processos manuais realizados em planilhas por um sistema centralizado, organizado e rastreável.

## Sobre o projeto

Empresas de locação trabalham com diversos tipos de equipamentos, como projetores, caixas de som, microfones, mesas, cadeiras, tendas e painéis de LED. O controle manual desses itens pode causar problemas como conflitos de disponibilidade, perda de informações sobre movimentações e dificuldade para acompanhar o estoque.

O RENTAL EVENTOS busca solucionar esses problemas através de um sistema que centraliza as informações dos equipamentos e registra todas as movimentações realizadas.

## O que terá na aplicação

### 🔐 Autenticação

O sistema contará com uma tela de login para controlar o acesso dos usuários.

Após a autenticação, o sistema identificará o usuário responsável pelas operações realizadas, permitindo maior rastreabilidade das movimentações.

### 🏠 Tela principal

A tela principal funcionará como um painel de acesso às principais funcionalidades do sistema.

Nela será possível visualizar o usuário conectado, acessar o gerenciamento de equipamentos, realizar operações de estoque e encerrar a sessão através do logout.

### 📦 Cadastro de equipamentos

A aplicação permitirá cadastrar e gerenciar os equipamentos disponíveis para locação.

Cada equipamento poderá possuir informações como:

* Nome
* Marca
* Modelo
* Categoria
* Potência
* Material
* Peso
* Dimensões
* Cor
* Quantidade disponível
* Estoque mínimo

Também será possível consultar, pesquisar, editar e excluir equipamentos cadastrados.

### 📊 Gestão de estoque

O sistema permitirá controlar as entradas e saídas dos equipamentos.

As movimentações poderão ser classificadas como:

* **Entrada** — novos equipamentos adicionados ao estoque.
* **Saída** — equipamentos destinados a uma locação.

Antes de realizar uma saída, o sistema verificará a quantidade disponível, evitando que sejam retirados mais equipamentos do que existem em estoque.

### ⚠️ Alerta de estoque mínimo

Cada equipamento poderá possuir uma quantidade mínima configurada.

Quando uma movimentação de saída fizer com que o estoque atinja ou fique abaixo desse limite, o sistema poderá sinalizar que o equipamento está em situação crítica.

Isso permite que a empresa identifique antecipadamente quais equipamentos precisam ser repostos.

### 📝 Histórico de movimentações

Todas as movimentações serão registradas para permitir rastreabilidade.

O histórico armazenará informações como:

* Equipamento movimentado
* Usuário responsável
* Data da movimentação
* Tipo da movimentação
* Quantidade movimentada

Dessa forma, será possível identificar quem realizou determinada operação e acompanhar as alterações realizadas no estoque.

## Diagrama Entidade-Relacionamento

O modelo de dados do sistema foi desenvolvido através de um Diagrama Entidade-Relacionamento (DER).

[Visualizar DER](https://drive.google.com/file/d/1ffQMqpOZJcuRL_g7kf1eI25xaqPzlKhi/view?usp=sharing)

## Objetivo

O objetivo do RENTAL EVENTOS é fornecer uma solução simples e organizada para o controle de equipamentos de locação, reduzindo erros de controle manual, melhorando a visualização do estoque e garantindo maior rastreabilidade das operações realizadas no sistema.

## Projeto acadêmico

Projeto desenvolvido como parte das atividades de **Programação de Aplicativos / SENAI**.

---

**RENTAL EVENTOS**
Sistema de gerenciamento de equipamentos para locação de eventos.
